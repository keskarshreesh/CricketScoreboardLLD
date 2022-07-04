package org.scoreboard.model.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamScore {

    int totalRuns;
    int numberOfBallsPlayed;
    int totalWickets;
    int totalExtras;

    public TeamScore() {
        this.totalRuns = 0;
        this.numberOfBallsPlayed = 0;
        this.totalWickets = 0;
        this.totalExtras = 0;
    }
}
