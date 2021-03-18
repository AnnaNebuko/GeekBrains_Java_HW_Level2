package ru.geekbrains.gb;

public class Wall implements Challenge{
    private int height;
    public Wall(int height) { this.height = height; }
    @Override
    public boolean goThroughChallenge(Participant participant) {
        return height <= participant.getMaxHeight();
    }
}
