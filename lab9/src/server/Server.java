package server;

import client.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket servSocket;

    public Server(int port) throws IOException {
        this.servSocket = new ServerSocket(port);
    }



    public static void main(String[] args) {
        Server server = null;

        try {
            server = new Server(6666);
            server.runServer();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        if (server != null)
            server.shutServer();
    }

    public void runServer() throws IOException {
        while (!servSocket.isClosed()) {
            Socket socket = servSocket.accept();
            Client clHandler = new Client(socket);

            Thread thread = new Thread(clHandler);
            thread.start();
        }
    }

    public void shutServer() {
        try {
            this.servSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}