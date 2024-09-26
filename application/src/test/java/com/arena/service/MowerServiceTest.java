package com.arena.service;

import com.arena.model.Lawn;
import com.arena.model.Mower;
import com.arena.model.Orientation;
import com.arena.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerServiceTest {

    @InjectMocks
    private MowerService mowerService;

    private Lawn lawn;
    private Mower mower;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lawn = new Lawn(5, 5);
    }

    @Test
    void testMoveForwardNorth() {
        mower = new Mower(new Position(1, 1), Orientation.N);
        mowerService.executeCommands(lawn, mower, "A");
        assertEquals(1, mower.getPosition().getX());
        assertEquals(2, mower.getPosition().getY());
    }

    @Test
    void testMoveForwardEast() {
        mower = new Mower(new Position(1, 1), Orientation.E);
        mowerService.executeCommands(lawn, mower, "A");
        assertEquals(2, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
    }

    @Test
    void testMoveForwardSouth() {
        mower = new Mower(new Position(1, 1), Orientation.S);
        mowerService.executeCommands(lawn, mower, "A");
        assertEquals(1, mower.getPosition().getX());
        assertEquals(0, mower.getPosition().getY());
    }

    @Test
    void testMoveForwardWest() {
        mower = new Mower(new Position(1, 1), Orientation.W);
        mowerService.executeCommands(lawn, mower, "A");
        assertEquals(0, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
    }

    @Test
    void testTurnLeft() {
        mower = new Mower(new Position(1, 1), Orientation.N);
        mowerService.executeCommands(lawn, mower, "G");
        assertEquals(Orientation.W, mower.getOrientation());
    }

    @Test
    void testTurnRight() {
        mower = new Mower(new Position(1, 1), Orientation.N);
        mowerService.executeCommands(lawn, mower, "D");
        assertEquals(Orientation.E, mower.getOrientation());
    }

    @Test
    void testDoNotMoveOutOfBounds() {
        mower = new Mower(new Position(0, 0), Orientation.W);
        mowerService.executeCommands(lawn, mower, "A");
        assertEquals(0, mower.getPosition().getX());
        assertEquals(0, mower.getPosition().getY());
    }

    @Test
    void testStayWithinBounds() {
        mower = new Mower(new Position(5, 5), Orientation.E);
        mowerService.executeCommands(lawn, mower, "A");
        assertEquals(5, mower.getPosition().getX());
        assertEquals(5, mower.getPosition().getY());
    }


}
