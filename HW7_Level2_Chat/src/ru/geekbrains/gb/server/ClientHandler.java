package ru.geekbrains.gb.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ChatServer chatServer;
    private String name;

    public ClientHandler(Socket socket, ChatServer chatServer) {
        this.socket = socket;
        this.chatServer = chatServer;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during client establishing.", e);
        }

        new Thread(() -> {
            try {
                chatWithPeople();
            } catch (IOException e) {
                throw new ChatServerException("chatWithPeople() has a problem", e);
            }
        })
                .start();
    }
    private void chatWithPeople() throws IOException {
        sendMessage("Hi! What is your nick (Nick1/Nick2/Nick3)?");
        String message = in.readUTF();
        Optional<Users.User> mayBeUser = chatServer.getUser()
                .findUserByName(message);
        while (mayBeUser.isEmpty()) {
            sendMessage("No user with such nick. Try again!");
            message = in.readUTF();
            mayBeUser = chatServer.getUser()
                    .findUserByName(message);
        }
        Users.User userInfo = mayBeUser.get();
        name = userInfo.getNick();
        chatServer.readyForChat(this);

        sendMessage("Great! You can chat. Please write like this: /w nick message:");
        sendMessage("Type 'exit' to stop conversation.");
        while (true) {
            try {
                /**
                 * Message pattern
                 * /w nick message
                 */
                message = in.readUTF();

                if (message.startsWith("/w")) {
                    String[] privateMessage = message.split("\\s");
                    String receiver = privateMessage[1];
                    String text = privateMessage[2];

                    Optional<Users.User> mayBeReceiver = chatServer.getUser()
                            .findUserByName(receiver);
                    if (mayBeReceiver.isPresent())
                        chatServer.sendPrivateMessage(text, receiver, name);
                    else{
                        sendMessage("Your receiver is not found.");
                    }
                }
                else if (message.equals("exit")) {
                    sendMessage("Conversation stopped.");
                    return;
                } else {
                    sendMessage("Incorrect message pattern. " +
                            "Please write like this: /w nick message");
                }
            } catch (IOException e) {
                throw new ChatServerException("Something went wrong during client authentication.", e);
            }
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new ChatServerException("Something went wrong during sending the message.", e);
        }
    }

    public String getName() {
        return name;
    }
}