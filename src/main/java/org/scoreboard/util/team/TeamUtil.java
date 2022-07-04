package org.scoreboard.util.team;

import org.scoreboard.model.player.Player;
import org.scoreboard.model.team.Team;
import org.scoreboard.util.player.PlayerUtil;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TeamUtil {

    PlayerUtil playerUtil;

    public TeamUtil() {
        playerUtil = new PlayerUtil();
    }

    public void changeTeamStrike(Team team) {
        Player currentStriker = team.getCurrentStriker();
        Player currentNonStriker = team.getCurrentNonStriker();
        team.setCurrentStriker(currentNonStriker);
        team.setCurrentNonStriker(currentStriker);
    }

    public Player getNextPlayer(Team team) {
        return team.getPlayers().get(team.getNextPlayer());
    }

    public Team initializeTeam(String players) {
        Team team = new Team();
        Arrays.stream(players.split(" ")).collect(Collectors.toList()).forEach(playerName -> team.getPlayers().add(new Player(playerName)));
        team.setCurrentStriker(team.getPlayers().get(0));
        team.setCurrentNonStriker(team.getPlayers().get(1));
        team.setNextPlayer(2);
        return team;
    }

    public void printTeamScore(Team team) {
        System.out.printf("Total Score: %d%n",(team.getTeamScore().getTotalRuns() + team.getTeamScore().getTotalExtras()));
        System.out.printf("Wickets: %d%n",team.getTeamScore().getTotalWickets());
        System.out.printf("Extras: %d%n",team.getTeamScore().getTotalExtras());
        System.out.printf("Overs: %f%n",((float)team.getTeamScore().getNumberOfBallsPlayed())/6.0);
        for(Player player : team.getPlayers())
            playerUtil.printPlayerScore(player);
    }
}
