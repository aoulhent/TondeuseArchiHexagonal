package com.arena.port;

import com.arena.model.Lawn;
import com.arena.model.Mower;

public interface MowerCommandExecutorPort {
    void executeCommands(Lawn lawn, Mower mower, String commands);
}