package org.scoreboard.service.ball;

import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.team.Team;
import org.scoreboard.util.team.TeamUtil;

public class WicketBallProcessingService implements BallProcessingService {

    TeamUtil teamUtil;

    public WicketBallProcessingService() {
        this.teamUtil = new TeamUtil();
    }

    @Override
    public void processBall(Ball ball, Team team) {
        team.getTeamScore().setTotalWickets(team.getTeamScore().getTotalWickets() + 1);
        processWicket(team);
    }

    private void processWicket(Team team) {
        if(team.getNextPlayer() < team.getPlayers().size())
            team.setCurrentStriker(teamUtil.getNextPlayer(team));
        team.setNextPlayer(team.getNextPlayer() + 1);
    }
}
