package com.arena.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    private Position position;

    @BeforeEach
    public void setUp() {
        position = new Position(0, 0); // Set the initial position to (0, 0) for testing
    }

    // Test initialization
    @Test
    public void testPositionInitialization() {
        Position initialPosition = new Position(5, 7);
        assertEquals(5, initialPosition.getX());
        assertEquals(7, initialPosition.getY());
    }


    @Test
    public void testGetXAndY() {
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void testSetXAndY() {
        position.setX(3);
        position.setY(4);
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
    }

    // Test move forward to the north
    @Test
    public void testMoveForwardNorth() {
        position.moveForward(Orientation.N);
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
    }

    // Test move forward to the east
    @Test
    public void testMoveForwardEast() {
        position.moveForward(Orientation.E);
        assertEquals(1, position.getX());
        assertEquals(0, position.getY());
    }

    // Test move forward to the south
    @Test
    public void testMoveForwardSouth() {
        position.moveForward(Orientation.S);
        assertEquals(0, position.getX());
        assertEquals(-1, position.getY());
    }

    // Test move forward to the west
    @Test
    public void testMoveForwardWest() {
        position.moveForward(Orientation.W);
        assertEquals(-1, position.getX());
        assertEquals(0, position.getY());
    }

    // Test multiple consecutive moves (N -> E -> S -> W)
    @Test
    public void testMoveForwardMultipleDirections() {
        position.moveForward(Orientation.N); // move north
        position.moveForward(Orientation.E); // move east
        position.moveForward(Orientation.S); // move south
        position.moveForward(Orientation.W); // move west

        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }


    @Test
    public void testMoveForwardPositiveCoordinates() {
        position.setX(3);
        position.setY(3);

        position.moveForward(Orientation.N); // Move north
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());

        position.moveForward(Orientation.E); // Move east
        assertEquals(4, position.getX());
        assertEquals(4, position.getY());
    }

    // Test moving in negative x and y coordinates
    @Test
    public void testMoveForwardNegativeCoordinates() {
        position.setX(-3);
        position.setY(-3);

        position.moveForward(Orientation.S); // Move south
        assertEquals(-3, position.getX());
        assertEquals(-4, position.getY());

        position.moveForward(Orientation.W); // Move west
        assertEquals(-4, position.getX());
        assertEquals(-4, position.getY());
    }


    @Test
    public void testMoveForwardBoundaryCondition() {
        position.setX(Integer.MAX_VALUE - 1);
        position.setY(Integer.MAX_VALUE - 1);

        position.moveForward(Orientation.N);
        position.moveForward(Orientation.E);

        assertEquals(Integer.MAX_VALUE, position.getX());
        assertEquals(Integer.MAX_VALUE, position.getY());
    }


    @Test
    public void testMoveForwardNegativeBoundaryCondition() {
        position.setX(Integer.MIN_VALUE + 1);
        position.setY(Integer.MIN_VALUE + 1);

        position.moveForward(Orientation.S);
        position.moveForward(Orientation.W);

        assertEquals(Integer.MIN_VALUE, position.getX());
        assertEquals(Integer.MIN_VALUE, position.getY());
    }
}
