package org.scoreboard.service.ball;

import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.team.Team;

public class ExtraBallProcessingService implements BallProcessingService {


    @Override
    public void processBall(Ball ball, Team team) {

        team.getTeamScore().setTotalExtras(team.getTeamScore().getTotalExtras() + 1);
    }
}
