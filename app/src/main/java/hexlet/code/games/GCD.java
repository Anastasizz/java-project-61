package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class GCD {
    private static final String TITLE = "Find the greatest common divisor of given numbers.";
    private static String[][] gameData = new String[GAME_ROUNDS][2];

    public static void prepareGameData() {
        Random random = new Random();
        final int bound = 100;
        int rndNum1 = 0;
        int rndNum2 = 0;

        for (int i = 0; i < gameData.length; i++) {
            rndNum1 = random.nextInt(bound);
            rndNum2 = random.nextInt(bound);
            gameData[i][0] = rndNum1 + " " + rndNum2; //question
            gameData[i][1] = String.valueOf(getGCD(rndNum1, rndNum2)); //correct answer
        }
    }

    private static int getGCD(int num1, int num2) {
        int gcd = 1;
        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void start() {
        Engine.start(gameData, TITLE);
    }
}
