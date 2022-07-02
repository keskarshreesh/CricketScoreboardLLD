package org.scoreboard.model.ball;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BallType {

    WIDE("Wide","Wd"),
    NO_BALL("No Ball","Nb"),
    WICKET("Wicket","W"),
    REGULAR("Regular","R");

    String typeName;
    String typeCode;
}

