package ru.gb.chat.client.gui.api;

@FunctionalInterface
public interface Receiver {
    void receive(String data);
}
