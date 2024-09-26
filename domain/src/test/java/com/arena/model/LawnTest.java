package com.arena.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LawnTest {

    @Test
    public void testPositionWithinBounds() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(3, 3);
        assertTrue(lawn.isWithinBounds(position));
    }

    @Test
    public void testPositionOnLowerBoundary() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(0, 0);
        assertTrue(lawn.isWithinBounds(position));
    }

    @Test
    public void testPositionOnUpperBoundary() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(5, 5);
        assertTrue(lawn.isWithinBounds(position));
    }

    @Test
    public void testPositionOutsideUpperBoundary() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(6, 6);
        assertFalse(lawn.isWithinBounds(position));
    }

    @Test
    public void testPositionOutsideLowerBoundary() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(-1, -1);
        assertFalse(lawn.isWithinBounds(position));
    }

    @Test
    public void testPositionOutsideXBoundary() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(6, 2);
        assertFalse(lawn.isWithinBounds(position));
    }

    @Test
    public void testPositionOutsideYBoundary() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(2, 6);
        assertFalse(lawn.isWithinBounds(position));
    }
}
