package ru.geekbrains.gb;

import ru.geekbrains.gb.server.ChatServer;

/*1. Разобраться с кодом
  2. * Реализовать личные сообщения, если клиент пишет
  «/w nick3 Привет», то только клиенту с ником nick3
  должно прийти сообщение «Привет»
 */
//ТЫ ЯВНО НАПОРТАЧИЛА С БАЗОЙ ДАННОЙ)))))) У ТЕБЯ НЕ ПОЛУЧАЕТСЯ ОТПРАВИТЬ ДАННЫЕ.
//ПОСМОТРИ КАК У МАКСА
public class ServerApp {

    public static void main(String[] args) {
	    new ChatServer();
    }
}
