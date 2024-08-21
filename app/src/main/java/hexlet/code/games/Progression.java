package hexlet.code.games;

import java.util.Random;

public class Progression {
    private static final String TITLE = "What number is missing in the progression?";

    public static void prepareGameData(String[][] gameData) {
        final int prgLength = 10;
        final int bound = 10;
        Random random = new Random();
        StringBuilder progression = new StringBuilder();
        String correctAnswer = "";

        int step;
        int x;
        int start;

        for (int i = 0; i < gameData.length; i++) {
            step = random.nextInt(1, bound);
            x = random.nextInt(bound);
            start = random.nextInt(bound);
            progression.append(start);
            for (int j = 0; j < prgLength; j++) {
                start += step;
                progression.append(" ");
                if (j == x) {
                    progression.append("..");
                    correctAnswer = String.valueOf(start);
                } else {
                    progression.append(start);
                }
            }
            gameData[i][0] = progression.toString();
            gameData[i][1] = correctAnswer;
            progression.setLength(0);
        }
    }

    public static String getTitle() {
        return TITLE;
    }

}
