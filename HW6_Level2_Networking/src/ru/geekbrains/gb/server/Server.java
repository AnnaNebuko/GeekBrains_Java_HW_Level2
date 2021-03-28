package ru.geekbrains.gb.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is ready...");
            System.out.println("Waiting for a connection...");
            Socket accept = serverSocket.accept();
            System.out.println("Connection established: " + accept);
            System.out.println("Write \"-quit\" for closing connection");

            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                        System.out.println("Sent!");
                    } catch (IOException e) {
                        System.out.println("Client down...");
                        System.out.println("Connection closed.");
                        break;
                    }
                }
            })
                    .start();
            while (true) {
                try {
                    String message = in.readUTF();
                    if (message.equals("-quit")) {
                        out.writeUTF("Conversation is over");
                        System. exit(0);
                    }
                    System.out.println("From client: " + message);
                } catch (Exception e) {
                    System.out.println("Incoming message channel closed.");
                    System.out.println("Please double press ENTER...");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
