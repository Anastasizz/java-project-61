package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class GCD {
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    private static final String[][] gameData = new String[GAME_ROUNDS][2];
    private static final int maxNumber = 100;

    public static void prepareGameData() {
        Random random = new Random();

        for (int i = 0; i < gameData.length; i++) {
            int rndNum1 = random.nextInt(maxNumber);
            int rndNum2 = random.nextInt(maxNumber);
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
        Engine.start(gameData, RULES);
    }
}
