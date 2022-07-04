package org.scoreboard.service.ball;

import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.team.Team;
import org.scoreboard.util.team.TeamUtil;

public class RegularBallProcessingService implements BallProcessingService {

    TeamUtil teamUtil;

    public RegularBallProcessingService() {
        teamUtil = new TeamUtil();
    }

    @Override
    public void processBall(Ball ball, Team team) {

        team.getTeamScore().setTotalRuns(team.getTeamScore().getTotalRuns() + ball.getRuns());
        team.getCurrentStriker().getPlayerScore().setScore(team.getCurrentStriker().getPlayerScore().getScore() + ball.getRuns());
        processRuns(ball,team);
    }

    private void processRuns(Ball ball, Team team) {
        switch (ball.getRuns())
        {
            case 4:
                team.getCurrentStriker().getPlayerScore().setFours(team.getCurrentStriker().getPlayerScore().getFours() + 1);
                break;
            case 6:
                team.getCurrentStriker().getPlayerScore().setSixes(team.getCurrentStriker().getPlayerScore().getSixes() + 1);
                break;
            default:
                if(ball.getRuns() % 2 == 1)
                    teamUtil.changeTeamStrike(team);
                break;
        }
    }
}
