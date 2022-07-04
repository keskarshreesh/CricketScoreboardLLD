package org.scoreboard.util.player;

import org.scoreboard.model.player.Player;

public class PlayerUtil {

    public void printPlayerScore(Player player){
        System.out.println(player.getPlayerName());
        System.out.printf("Runs: %d%n",player.getPlayerScore().getScore());
        System.out.printf("Balls Faced: %d%n",player.getPlayerScore().getNumberOfBallsPlayed());
        System.out.printf("Sixes: %d%n",player.getPlayerScore().getSixes());
        System.out.printf("Fours: %d%n",player.getPlayerScore().getFours());
    }
}
