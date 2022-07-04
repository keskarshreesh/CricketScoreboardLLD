package org.scoreboard;

import org.scoreboard.service.game.GameService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class CricketScoreboardLLD {
    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputs = classloader.getResourceAsStream("inputs.txt");
        if(inputs != null)
        {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputs, StandardCharsets.UTF_8));
            List<String> gameInputs = inputReader.lines().collect(Collectors.toList());
            GameService gameService = new GameService();
            gameService.playGame(gameInputs);
            gameService.printGameResults();
        }
    }
}