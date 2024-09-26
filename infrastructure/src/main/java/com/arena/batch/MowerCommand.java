package com.arena.batch;

public class MowerCommand {
    private int x;
    private int y;
    private String orientation;
    private String commands;

    public MowerCommand(int x, int y, String orientation, String commands) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.commands = commands;
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

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }
}