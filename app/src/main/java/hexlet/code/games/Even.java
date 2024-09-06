package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;


public class Even {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String[][] GAME_DATA = new String[GAME_ROUNDS][2];
    private static final int MAX_NUMBER = 100;

    public static void prepareGameData() {
        Random random = new Random();

        for (int i = 0; i < GAME_DATA.length; i++) {
            int randomNumber = random.nextInt(MAX_NUMBER);
            GAME_DATA[i][0] = String.valueOf(randomNumber); //question
            GAME_DATA[i][1] = isEven(randomNumber) ? "yes" : "no"; //correct answer
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void start() {
        Engine.start(GAME_DATA, RULES);
    }

}
