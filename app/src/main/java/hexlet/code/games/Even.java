package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;


public class Even {
    private static final String TITLE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static String[][] gameData = new String[GAME_ROUNDS][2];

    public static void prepareGameData() {
        Random random = new Random();
        final int bound = 100;
        int randomNumber = 0;

        for (int i = 0; i < gameData.length; i++) {
            randomNumber = random.nextInt(bound);
            gameData[i][0] = String.valueOf(randomNumber); //question
            gameData[i][1] = isEven(randomNumber) ? "yes" : "no"; //correct answer
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void start() {
        Engine.start(gameData, TITLE);
    }

}
