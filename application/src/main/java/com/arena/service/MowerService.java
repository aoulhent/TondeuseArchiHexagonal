package com.arena.service;

import com.arena.model.Lawn;
import com.arena.model.Mower;
import com.arena.model.Position;
import com.arena.port.MowerCommandExecutorPort;
import org.springframework.stereotype.Service;

@Service
public class MowerService implements MowerCommandExecutorPort {


    @Override
    public void executeCommands(Lawn lawn, Mower mower, String commands) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'G':
                    mower.setOrientation(mower.getOrientation().rotateLeft());
                    break;
                case 'D':
                    mower.setOrientation(mower.getOrientation().rotateRight());
                    break;
                case 'A':
                    Position newPosition = new Position(mower.getPosition().getX(), mower.getPosition().getY());
                    newPosition.moveForward(mower.getOrientation());
                    if (lawn.isWithinBounds(newPosition)) {
                        mower.setPosition(newPosition);
                    }
                    break;
            }
        }
    }
}