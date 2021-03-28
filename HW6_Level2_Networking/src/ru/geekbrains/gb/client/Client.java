package ru.geekbrains.gb.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Typical TCP\IP socket
 * 127.0.0.1:8080
 */

public class Client {
    public Client() {

        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("You can chat! When finish write \"-quit\" for closing connection");

            Scanner scanner = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                        System.out.println("Sent!");
                    } catch (IOException e) {
                        System.out.println("Server down...");
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
                        break;
                    }
                    System.out.println("From server: " + message);
                } catch (IOException e) {
                    System.out.println("Incoming message channel closed.");
                    System.out.println("Please double press ENTER...");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Server is off!!!");
        }
    }
}

