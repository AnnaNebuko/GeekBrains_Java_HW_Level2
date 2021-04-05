package ru.gb.chat.client.gui;

import ru.gb.chat.client.gui.api.Receiver;
import ru.gb.chat.client.gui.api.Sender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatFrame extends JFrame {
    private final JTextArea chatArea;
    JLabel counterLabel;
    Font font = new Font("Arial", Font.BOLD, 40);
    Timer timer;
    int seconds = 0;

    public ChatFrame(Sender sender) {
        setTitle("Chat v1.0");
        setBounds(0, 0, 400, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        top.add(chatArea, BorderLayout.CENTER);


        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        JTextField inputField = new JTextField();
        bottom.add(inputField, BorderLayout.CENTER);
        JButton submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new SubmitButtonListener(inputField, sender));
        bottom.add(submitBtn, BorderLayout.EAST);

        counterLabel = new JLabel("");
        counterLabel.setBounds(100, 20, 100, 20);
        counterLabel.setFont(font);
        top.add(counterLabel, BorderLayout.EAST);

        add(top, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
        countDown();
        timer.start();
    }

    public Receiver getReceiver() {
        return (message) -> {
            if (!message.isBlank()) {
                chatArea.append(message);
                chatArea.append("\n");
            }
        };
    }

    public void countDown(){
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                counterLabel.setText("Timer: " + seconds);
                if (seconds == 120) counterLabel.setText("Time to chat!");
            }
        });
    }


}
