package org.scoreboard.model.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerScore {

    int score;
    int numberOfBallsPlayed;
    int fours;
    int sixes;

    public PlayerScore() {
        this.score = 0;
        this.numberOfBallsPlayed = 0;
        this.fours = 0;
        this.sixes = 0;
    }
}
