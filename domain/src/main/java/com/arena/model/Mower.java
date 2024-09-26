package com.arena.model;

public class Mower {
    private Position position;
    private Orientation orientation;

    public Mower(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    public void setOrientation(Orientation newOrientation) {
        this.orientation = newOrientation;
    }
}
