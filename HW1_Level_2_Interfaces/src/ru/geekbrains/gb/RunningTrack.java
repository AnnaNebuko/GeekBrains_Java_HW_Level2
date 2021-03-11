package ru.geekbrains.gb;

public class RunningTrack implements Challenge{
    private int length;
    public RunningTrack(int length) {
        this.length = length;
    }
    @Override
    public boolean goThroughChallenge(Participant participant) {
        return length <= participant.getMaxLength();
    }
}
