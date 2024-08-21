package hexlet.code.games;

import java.util.Random;

public class Prime {
    private static final String TITLE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void prepareGameData(String[][] gameData) {
        Random random = new Random();
        final int BOUND = 100;
        int randomNumber = 0;

        for (int i = 0; i < gameData.length; i++) {
            randomNumber = random.nextInt(BOUND);
            gameData[i][0] = String.valueOf(randomNumber); //question
            gameData[i][1] = (isPrime(randomNumber)) ? "yes" : "no"; //correct answer
        }
    }

    public static String getTitle() {
        return TITLE;
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

}
