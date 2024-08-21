package hexlet.code.games;

import java.util.Random;

public class GCD {
    private static final String TITLE = "Find the greatest common divisor of given numbers.";

    public static void prepareGameData(String[][] gameData) {
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

    public static String getTitle() {
        return TITLE;
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
}
