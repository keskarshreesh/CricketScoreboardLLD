package org.scoreboard.service.ball;

import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.team.Team;

public interface BallProcessingService {

    public void processBall(Ball ball, Team team);
}
