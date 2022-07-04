package org.scoreboard.service.game;

import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.ball.BallType;
import org.scoreboard.model.game.Game;
import org.scoreboard.model.player.Player;
import org.scoreboard.model.team.Team;
import org.scoreboard.service.ball.BallProcessingService;
import org.scoreboard.service.ball.BallProcessingServiceFactory;
import org.scoreboard.util.ball.BallUtil;
import org.scoreboard.util.team.TeamUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    Game game;
    BallProcessingServiceFactory ballProcessingServiceFactory;
    TeamUtil teamUtil;
    BallUtil ballUtil;

    public GameService() {
        ballProcessingServiceFactory = new BallProcessingServiceFactory();
        teamUtil = new TeamUtil();
        ballUtil = new BallUtil();
    }

    private void initializeGame(List<String> gameInputs) {

        game = new Game();
        game.setNumberOfPlayers(Integer.parseInt(gameInputs.get(0)));
        game.setNumberOfOvers(Integer.parseInt(gameInputs.get(1)));
    }

    private void processBall(Ball ball, Team team) {

        BallProcessingService ballProcessingService = ballProcessingServiceFactory.getBallProcessingServiceFromBallType(ball.getBallType());
        ballProcessingService.processBall(ball, team);
    }

    private void processOver(String over, Team team) {

        Arrays.stream(over.split(" ")).collect(Collectors.toList()).forEach(ballString -> {
            BallType ballType = ballUtil.getBallTypeFromTypeCode(ballString);
            Ball ball;
            try {
                int currentRuns = Integer.parseInt(ballString);
                ball = new Ball(ballType,currentRuns);
            }
            catch (NumberFormatException e) {
                ball = new Ball(ballType);
            }
            processBall(ball,team);
        });
    }

    private int playInning(Team team, List<String> gameInputs, int startInputFrom) {

        int currentOver = 0;
        while((currentOver < game.getNumberOfOvers()) && (team.getTeamScore().getTotalWickets() < game.getNumberOfPlayers()))
        {
            processOver(gameInputs.get(startInputFrom + currentOver),team);
            currentOver++;
        }

        return currentOver;
    }

    public void playGame(List<String> gameInputs) {

        initializeGame(gameInputs);
        Team firstTeam = teamUtil.initializeTeam(gameInputs.get(2));
        int oversPlayedInFirstInning = playInning(firstTeam,gameInputs,3);
        game.setFirstTeam(firstTeam);
        Team secondTeam = teamUtil.initializeTeam(gameInputs.get(3 + oversPlayedInFirstInning));
        playInning(secondTeam,gameInputs,4 + oversPlayedInFirstInning);
        game.setSecondTeam(secondTeam);
    }

    public int getWinner(Team firstTeam, Team secondTeam) {
        return (firstTeam.getTeamScore().getTotalRuns() > secondTeam.getTeamScore().getTotalRuns()) ? 1 : ((firstTeam.getTeamScore().getTotalRuns() == secondTeam.getTeamScore().getTotalRuns()) ? 0 : 2);
    }

    public void printGameResults() {
        System.out.println("Game Results:");
        System.out.println("");
        System.out.println("Team 1 Results:");
        teamUtil.printTeamScore(game.getFirstTeam());
        System.out.println("");
        System.out.println("Team 2 Results:");
        teamUtil.printTeamScore(game.getSecondTeam());
        System.out.println("");
        switch (getWinner(game.getFirstTeam(),game.getSecondTeam())) {
            case 0:
                System.out.println("It's a draw!!");
                break;
            case 1:
                System.out.println("Team 1 wins!!");
                break;
            case 2:
                System.out.println("Team 2 wins!!");
                break;
        }
    }
}
