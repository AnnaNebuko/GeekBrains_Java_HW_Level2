package ru.geekbrains.gb;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Participant[]participants = {
                new Cat("Мурчик", 10, 10),
                new Person("Снежана", 20, 20),
                new Person("Сергей", 25, 20),
                new Robot("Терминатор", 30, 30),

        };
        Team team = new Team(participants, "DreamTeam");

        Challenge[]challenges = {
                new RunningTrack(25),
                new Wall(20)
        };
        Course c = new Course(challenges);

        List <Participant> successfulParticipants = c.DoIt(team);
        team.printTeam();
        System.out.println("========");
        team.showResult(successfulParticipants);
    }
}
