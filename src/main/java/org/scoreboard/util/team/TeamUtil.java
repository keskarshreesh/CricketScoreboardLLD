package org.scoreboard.util.team;

import org.scoreboard.model.player.Player;
import org.scoreboard.model.team.Team;

public class TeamUtil {

    public void changeTeamStrike(Team team) {

        Player currentStriker = team.getCurrentStriker();
        Player currentNonStriker = team.getCurrentNonStriker();
        team.setCurrentStriker(currentNonStriker);
        team.setCurrentNonStriker(currentStriker);
    }

    public Player getNextPlayer(Team team) {
        return team.getPlayers().get(team.getNextPlayer());
    }
}
