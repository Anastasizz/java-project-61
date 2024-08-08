package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;


public class Even {
    public static void start() {
        final int gameRounds = Engine.getGameRounds();
        String introText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] gameData = new String[gameRounds][2];

        prepareGameData(gameData);
        Engine.start(gameData, introText);
    }

    private static void prepareGameData(String[][] gameData) {
        Random random = new Random();
        int randomNumber = 0;

        for (int i = 0; i < gameData.length; i++) {
            randomNumber = random.nextInt(100);
            gameData[i][0] = String.valueOf(randomNumber); //question
            gameData[i][1] = (randomNumber % 2 == 0) ? "yes" : "no"; //correct answer
        }
    }
}
