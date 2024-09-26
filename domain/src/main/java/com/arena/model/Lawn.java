package com.arena.model;

public class Lawn {
    private final int maxX;
    private final int maxY;

    public Lawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isWithinBounds(Position position) {
        return position.getX() >= 0 && position.getX() <= maxX &&
                position.getY() >= 0 && position.getY() <= maxY;
    }
}
