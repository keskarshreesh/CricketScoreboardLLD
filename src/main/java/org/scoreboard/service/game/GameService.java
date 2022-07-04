package org.scoreboard.service.game;

import org.scoreboard.model.Game;
import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.team.Team;
import org.scoreboard.service.ball.BallProcessingService;
import org.scoreboard.service.ball.BallProcessingServiceFactory;

import java.util.List;

public class GameService {

    Game game;
    BallProcessingServiceFactory ballProcessingServiceFactory;

    public GameService(Game game) {
        this.game = game;
        ballProcessingServiceFactory = new BallProcessingServiceFactory();
    }

    public void initializeGame(List<String> gameInputs) {
        //initializeGame
    }

    public void playInning(Team team, List<String> gameInputs) {
        //playInning
        //call below processBall method iteratively for current team
    }

    public void processBall(Ball ball, Team team) {
        BallProcessingService ballProcessingService = ballProcessingServiceFactory.getBallProcessingServiceFromBallType(ball.getBallType());
        ballProcessingService.processBall(ball, team);
    }
}
