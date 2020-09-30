package chadchat.entries;

import chadchat.api.ChadChat;
import chadchat.domain.User;
import chadchat.ui.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server {
    private final static int PORT = 2222;

    public static void main(String[] args) {
        ChadChat chadChat = new ChadChat();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("[SERVER]: Started at " + serverSocket);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("[SERVER]: Client accepted from " + socket);
                Client client = new Client(socket.getInputStream(), socket.getOutputStream(), chadChat);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
