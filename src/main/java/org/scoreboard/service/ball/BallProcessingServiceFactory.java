package org.scoreboard.service.ball;

import org.scoreboard.model.ball.BallType;

public class BallProcessingServiceFactory {

    ExtraBallProcessingService extraBallProcessingService;
    WicketBallProcessingService wicketBallProcessingService;
    RegularBallProcessingService regularBallProcessingService;

    public BallProcessingServiceFactory() {
        extraBallProcessingService = new ExtraBallProcessingService();
        wicketBallProcessingService = new WicketBallProcessingService();
        regularBallProcessingService = new RegularBallProcessingService();
    }

    public BallProcessingService getBallProcessingServiceFromBallType(BallType ballType) {
        switch (ballType)
        {
            case WIDE:
            case NO_BALL: return extraBallProcessingService;
            case WICKET: return wicketBallProcessingService;
            case REGULAR:
            default: return regularBallProcessingService;
        }
    }
}
