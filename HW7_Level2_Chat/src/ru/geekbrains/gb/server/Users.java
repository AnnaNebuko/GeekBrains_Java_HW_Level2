package ru.geekbrains.gb.server;

import java.util.Optional;
import java.util.Set;

public class Users {
    private static final Set<User> users = Set.of(
            new User("Nick1"),
            new User("Nick2"),
            new User("Nick3")
    );

    public Optional<User> findUserByName(String name) {
        return users.stream()
                .filter(entry -> entry.getNick().equals(name))
                .findFirst();
    }

    public  static class User {
        private String nick;
        public User(String nick) {
            this.nick = nick;
        }
        public String getNick() {
            return nick;
        }
    }
}
