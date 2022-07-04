package org.scoreboard.service.ball;

import org.scoreboard.model.ball.BallType;

public class BallProcessingServiceFactory {

    public BallProcessingService getBallProcessingServiceFromBallType(BallType ballType) {
        switch (ballType)
        {
            case WIDE:
            case NO_BALL: return new ExtraBallProcessingService();
            case WICKET: return new WicketBallProcessingService();
            case REGULAR:
            default: return new RegularBallProcessingService();
        }
    }
}
