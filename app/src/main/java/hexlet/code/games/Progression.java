package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class Progression {
    private static final String TITLE = "What number is missing in the progression?";
    private static String[][] gameData = new String[GAME_ROUNDS][2];

    public static void prepareGameData() {
        final int prgLength = 10;
        final int bound = 10;
        Random random = new Random();
        int[] progression = new int[prgLength];

        int start;
        int step;
        int hiddenIndex;
        int currNumber = 0;


        for (int i = 0; i < gameData.length; i++) {
            start = random.nextInt(bound);
            step = random.nextInt(1, bound);
            hiddenIndex = random.nextInt(bound);

            progression[0] = start;
            currNumber = start;
            for (int j = 1; j < progression.length; j++) {
                currNumber += step;
                progression[j] = currNumber;
            }

            gameData[i][0] = createQuestion(progression, hiddenIndex);
            gameData[i][1] = String.valueOf(getHiddenNumber(progression, hiddenIndex));
            Arrays.fill(progression, 0);
        }
    }

    private static String createQuestion(int[] progression, int hiddenIndex) {
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                question.append("..");
            } else {
                question.append(progression[i]);
            }
            question.append(" ");
        }
        return question.toString().trim();
    }

    private static int getHiddenNumber(int[] progression, int hiddenIndex) {
        return progression[hiddenIndex];
    }

    public static void start() {
        Engine.start(gameData, TITLE);
    }

}
