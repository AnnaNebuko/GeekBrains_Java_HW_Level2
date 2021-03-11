package ru.geekbrains.gb;

import java.util.ArrayList;
import java.util.List;

public class Course {
    Challenge[]challenges;

    public Course(Challenge[] challenges) {
        this.challenges = challenges;
    }
    public List DoIt(Team team){
        List <Participant> successfulParticipants = new ArrayList<>();
        for (int i = 0; i < team.participants.length; i++) {
            int score = 0;
            for(Challenge challenge: challenges)
            if(challenge.goThroughChallenge(team.participants[i]))
                score++;
            if (score == 2) successfulParticipants.add(team.participants[i]);
        }
        return successfulParticipants;
    }
}
