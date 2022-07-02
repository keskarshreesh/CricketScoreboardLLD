package org.scoreboard.model.team;

import lombok.Getter;
import lombok.Setter;
import org.scoreboard.model.player.Player;

import java.util.List;

@Getter
@Setter
public class Team {

    List<Player> players;
    TeamScore teamScore;
    Player currentStriker;
    Player currentNonStriker;
    int nextPlayer;
}
