package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final String[][] gameData = new String[GAME_ROUNDS][2];
    private static final int prgLength = 10;
    private static final int bound = 10;

    public static void prepareGameData() {
        Random random = new Random();

        for (int i = 0; i < gameData.length; i++) {
            int start = random.nextInt(bound);
            int step = random.nextInt(1, bound);
            int hiddenIndex = random.nextInt(bound);
            int[] progression = generateProgression(start, step);

            gameData[i][0] = createQuestion(progression, hiddenIndex);
            gameData[i][1] = String.valueOf(getHiddenNumber(progression, hiddenIndex));
            Arrays.fill(progression, 0);
        }
    }

    private static int[] generateProgression(int start, int step) {
        int[] progression = new int[prgLength];
        progression[0] = start;
        int currNumber = start;
        for (int j = 1; j < progression.length; j++) {
            currNumber += step;
            progression[j] = currNumber;
        }
        return progression;
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
        Engine.start(gameData, RULES);
    }

}
