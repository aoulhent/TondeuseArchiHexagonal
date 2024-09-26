package com.arena.model;

public enum Orientation {
    N, E, S, W;

    public Orientation rotateLeft() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
        }
        return this;
    }

    public Orientation rotateRight() {
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
        }
        return this;
    }
}
