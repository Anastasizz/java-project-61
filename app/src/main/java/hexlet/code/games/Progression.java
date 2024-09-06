package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final String[][] GAME_DATA = new String[GAME_ROUNDS][2];
    private static final int PRG_LENGTH = 10;
    private static final int BOUND = 10;

    public static void prepareGameData() {
        Random random = new Random();

        for (int i = 0; i < GAME_DATA.length; i++) {
            int start = random.nextInt(BOUND);
            int step = random.nextInt(1, BOUND);
            int hiddenIndex = random.nextInt(BOUND);
            int[] progression = generateProgression(start, step);

            GAME_DATA[i][0] = createQuestion(progression, hiddenIndex);
            GAME_DATA[i][1] = String.valueOf(getHiddenNumber(progression, hiddenIndex));
            Arrays.fill(progression, 0);
        }
    }

    private static int[] generateProgression(int start, int step) {
        int[] progression = new int[PRG_LENGTH];
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
        Engine.start(GAME_DATA, RULES);
    }

}
