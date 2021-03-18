package ru.geekbrains.gb;

import java.util.List;

public class Team {
    private String name;
    Participant[]participants;

    public Team(Participant[] participants, String name) {
        this.participants = participants;
        this.name = name;
    }

    public void printTeam(){
        System.out.println("Все участники: ");
        for (Participant participant : participants) {
            System.out.println(participant.getName() + ": ");
            System.out.println("MaxHeight: " + participant.getMaxHeight());
            System.out.println("MaxLength: " + participant.getMaxLength());
        }

    }
    public void showResult(List <Participant>successfulParticipants){
        System.out.println("Участники, преодолевшие все препятствия: ");
        for (Participant participant: successfulParticipants){
           System.out.println(participant.getName());
       }
    }
}
