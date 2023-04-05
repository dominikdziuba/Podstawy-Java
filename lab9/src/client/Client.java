package client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable {
    private Socket clSocket;
    private BufferedReader buffReader;
    private BufferedWriter buffWriter;

    public static ArrayList<Client> clArrayList = new ArrayList<>();

    public Client(Socket socket) {
        try {
            this.clSocket = socket;
            this.buffWriter = new BufferedWriter(new OutputStreamWriter(clSocket.getOutputStream()));
            this.buffReader = new BufferedReader(new InputStreamReader(clSocket.getInputStream()));
            String username = buffReader.readLine();

            clArrayList.add(this);
            if(username != null) {
                sendMessage(username + " joined the lobby");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            exit(clSocket, buffReader, buffWriter);
        }
    }
    @Override
    public void run() {
        String input;
        while (clSocket.isConnected()) {
            try {
                input = buffReader.readLine();
                if (input != null)
                    sendMessage(input);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                exit(clSocket, buffReader, buffWriter);
                break;
            }
        }
    }


    public void sendMessage(String message) {
        for (Client i : clArrayList) {
            try {
                i.buffWriter.write(message);
                i.buffWriter.newLine();
                i.buffWriter.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                exit(clSocket, buffReader, buffWriter);
            }
        }
    }

    public void exit(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (socket != null)
                socket.close();
            if (bufferedReader != null)
                bufferedReader.close();
            if (bufferedWriter != null)
                bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
