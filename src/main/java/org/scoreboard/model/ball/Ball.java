package org.scoreboard.model.ball;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ball {

    BallType ballType;
    int runs;

    public Ball(BallType ballType) {
        this.ballType = ballType;
        this.runs = 0;
    }
}
