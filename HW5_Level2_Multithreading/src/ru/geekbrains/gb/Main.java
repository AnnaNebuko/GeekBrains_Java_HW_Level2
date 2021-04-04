package ru.geekbrains.gb;

public class Main {

    public static void main(String[] args) {
        new ArrayConverter().convertWithoutThreads();
        new ArrayConverter().convertWithThreads();
    }
}
