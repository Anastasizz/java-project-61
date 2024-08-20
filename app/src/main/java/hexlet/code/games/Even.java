package hexlet.code.games;

import java.util.Random;


public class Even {
    private static final String TITLE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void prepareGameData(String[][] gameData) {
        Random random = new Random();
        int randomNumber = 0;

        for (int i = 0; i < gameData.length; i++) {
            randomNumber = random.nextInt(100);
            gameData[i][0] = String.valueOf(randomNumber); //question
            gameData[i][1] = (randomNumber % 2 == 0) ? "yes" : "no"; //correct answer
        }
    }

    public static String getTitle() {
        return TITLE;
    }

}
