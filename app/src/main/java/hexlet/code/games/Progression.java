package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final String[][] GAME_DATA = new String[GAME_ROUNDS][2];
    private static final int BOUND = 10;

    public static void start() {
        prepareGameData();
        Engine.start(GAME_DATA, RULES);
    }

    private static void prepareGameData() {
        Random random = new Random();

        for (int i = 0; i < GAME_DATA.length; i++) {
            int start = random.nextInt(BOUND);
            int step = random.nextInt(1, BOUND);
            int progressionLength = 10;
            String[] progression = generateProgression(start, step, progressionLength);
            int hiddenIndex = random.nextInt(progressionLength);

            GAME_DATA[i][0] = createQuestion(progression, hiddenIndex);
            GAME_DATA[i][1] = getHiddenNumber(progression, hiddenIndex);
        }
    }

    private static String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        progression[0] = String.valueOf(start);
        int currNumber = start;
        for (int j = 1; j < progression.length; j++) {
            currNumber += step;
            progression[j] = String.valueOf(currNumber);
        }
        return progression;
    }

    private static String createQuestion(String[] progression, int hiddenIndex) {
        String[] question = Arrays.copyOf(progression, progression.length);
        question[hiddenIndex] = "..";
        return String.join(" ", question);
    }

    private static String getHiddenNumber(String[] progression, int hiddenIndex) {
        return progression[hiddenIndex];
    }

}
