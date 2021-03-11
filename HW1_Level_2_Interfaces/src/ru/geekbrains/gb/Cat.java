package ru.geekbrains.gb;

public class Cat implements Participant{
    private String name;
    private int maxLength;
    private int maxHeight;

    public Cat(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }
    public int getMaxLength() {
        return maxLength;
    }
    public int getMaxHeight() {
        return maxHeight;
    }
    public String getName() {
        return name;
    }

    @Override
    public String runMaxDistance() {
        return name + " может пробежать: " + maxLength + " км";
    }
    @Override
    public String jumpUpMax() {
        return name + " может прыгнуть: " + maxHeight + " м";
    }
}
