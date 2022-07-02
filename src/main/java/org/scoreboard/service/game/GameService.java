package org.scoreboard.service;

import org.scoreboard.model.Game;
import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.team.Team;

import java.util.List;

public class GameService {

    Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void initializeGame(List<String> gameInputs) {
        //initializeGame
    }

    public void playInning(Team team, List<String> gameInputs) {
        //playInning
    }

    public void processBall(Ball ball) {

    }
}
