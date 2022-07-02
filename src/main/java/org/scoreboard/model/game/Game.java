package org.scoreboard.model;

import lombok.Getter;
import lombok.Setter;
import org.scoreboard.model.team.Team;

@Getter
@Setter
public class Game {

    Team firstTeam;
    Team secondTeam;
    int numberOfPlayers;
    int numberOfOvers;
}
