package com.arena.model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveForward(Orientation orientation) {
        switch (orientation) {
            case N: y += 1; break;
            case E: x += 1; break;
            case S: y -= 1; break;
            case W: x -= 1; break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
