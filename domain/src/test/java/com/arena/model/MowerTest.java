package com.arena.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerTest {

    private Mower mower;
    private Position initialPosition;
    private Orientation initialOrientation;

    @BeforeEach
    public void setUp() {
        initialPosition = new Position(2, 2);
        initialOrientation = Orientation.N;
        mower = new Mower(initialPosition, initialOrientation);
    }

    @Test
    public void testMowerInitialization() {
        assertEquals(initialPosition, mower.getPosition());
        assertEquals(initialOrientation, mower.getOrientation());
    }

    @Test
    public void testGetPosition() {
        assertEquals(initialPosition, mower.getPosition());
    }

    @Test
    public void testGetOrientation() {
        assertEquals(initialOrientation, mower.getOrientation());
    }

    @Test
    public void testSetPosition() {
        Position newPosition = new Position(3, 3);
        mower.setPosition(newPosition);
        assertEquals(newPosition, mower.getPosition());
    }

    @Test
    public void testSetOrientation() {
        Orientation newOrientation = Orientation.E;
        mower.setOrientation(newOrientation);
        assertEquals(newOrientation, mower.getOrientation());
    }

    @Test
    public void testSetPositionAndOrientation() {
        Position newPosition = new Position(5, 5);
        Orientation newOrientation = Orientation.S;
        mower.setPosition(newPosition);
        mower.setOrientation(newOrientation);
        assertEquals(newPosition, mower.getPosition());
        assertEquals(newOrientation, mower.getOrientation());
    }
}
