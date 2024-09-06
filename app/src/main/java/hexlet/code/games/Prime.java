package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String[][] gameData = new String[GAME_ROUNDS][2];
    private static final int maxNumber = 100;

    public static void prepareGameData() {
        Random random = new Random();

        for (int i = 0; i < gameData.length; i++) {
            int randomNumber = random.nextInt(maxNumber);
            gameData[i][0] = String.valueOf(randomNumber); //question
            gameData[i][1] = isPrime(randomNumber) ? "yes" : "no"; //correct answer
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void start() {
        Engine.start(gameData, RULES);
    }

}
