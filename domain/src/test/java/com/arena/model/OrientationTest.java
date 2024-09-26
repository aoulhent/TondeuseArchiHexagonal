package com.arena.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {

    @Test
    public void testRotateLeftFromNorth() {
        Orientation orientation = Orientation.N;
        assertEquals(Orientation.W, orientation.rotateLeft());
    }

    @Test
    public void testRotateLeftFromWest() {
        Orientation orientation = Orientation.W;
        assertEquals(Orientation.S, orientation.rotateLeft());
    }

    @Test
    public void testRotateLeftFromSouth() {
        Orientation orientation = Orientation.S;
        assertEquals(Orientation.E, orientation.rotateLeft());
    }

    @Test
    public void testRotateLeftFromEast() {
        Orientation orientation = Orientation.E;
        assertEquals(Orientation.N, orientation.rotateLeft());
    }

    @Test
    public void testRotateRightFromNorth() {
        Orientation orientation = Orientation.N;
        assertEquals(Orientation.E, orientation.rotateRight());
    }

    @Test
    public void testRotateRightFromEast() {
        Orientation orientation = Orientation.E;
        assertEquals(Orientation.S, orientation.rotateRight());
    }

    @Test
    public void testRotateRightFromSouth() {
        Orientation orientation = Orientation.S;
        assertEquals(Orientation.W, orientation.rotateRight());
    }

    @Test
    public void testRotateRightFromWest() {
        Orientation orientation = Orientation.W;
        assertEquals(Orientation.N, orientation.rotateRight());
    }
}
