package org.scoreboard.util.ball;

import org.scoreboard.model.ball.Ball;
import org.scoreboard.model.ball.BallType;

public class BallUtil {

    public BallType getBallTypeFromTypeCode(String ballTypeCode) {

        switch (ballTypeCode) {
            case "Wd" : return BallType.WIDE;
            case "Nb" : return BallType.NO_BALL;
            case "W" : return BallType.WICKET;
            default : return BallType.REGULAR;
        }
    }
}
