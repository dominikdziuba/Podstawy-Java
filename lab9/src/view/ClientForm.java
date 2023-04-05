package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ClientForm {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;

    private JPanel mainPanel;
    private JTextArea allMessagesTextArea;
    private JButton loginButton;
    private JTextField loginTextField;


    private JLabel loginLabel;
    private JLabel messageLabel;
    private JTextField yourMessageTextField;
    private JButton sendButton;

    public ClientForm(Socket socket){
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e){
            close(socket, bufferedReader, bufferedWriter);
        }
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(username == null || username.equals("")){
                        username = loginTextField.getText();
                        bufferedWriter.write(username);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
                } catch (IOException er){
                    close(socket, bufferedReader, bufferedWriter);
                }
                loginTextField.setText(username +" logged in successfully");

            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(socket.isConnected()){
                    String messege = yourMessageTextField.getText();
                    try {
                        bufferedWriter.write(username + ":  " + messege);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    yourMessageTextField.setText("");

                }

            }
        });
    }
    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messegeFromChat;

                while (socket.isConnected()){
                    try {
                        messegeFromChat = bufferedReader.readLine();
                        allMessagesTextArea.append(messegeFromChat + "\n");
                    } catch (IOException e){
                        close(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }

    public void close(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666);
        JFrame mainFrame = new JFrame("Chat");
        ClientForm client = new ClientForm(socket);
        mainFrame.setContentPane(client.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        client.listenForMessage();
    }

}
