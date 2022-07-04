package org.scoreboard.model.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    String playerName;
    PlayerScore playerScore;

    public Player(String playerName) {
        this.playerName = playerName;
        playerScore = new PlayerScore();
    }
}
