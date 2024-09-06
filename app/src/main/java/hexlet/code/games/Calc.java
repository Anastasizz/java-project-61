package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Engine.GAME_ROUNDS;

import java.util.Random;


public class Calc {
    private static final String RULES = "What is the result of the expression?";
    private static final String[][] GAME_DATA = new String[GAME_ROUNDS][2];
    private static final char[] OPERATORS = {'+', '*', '-'};
    private static final int MAX_NUMBER = 100;

    public static void prepareGameData() {
        Random random = new Random();

        for (int i = 0; i < GAME_DATA.length; i++) {
            int rndNum1 = random.nextInt(MAX_NUMBER);
            int rndNum2 = random.nextInt(MAX_NUMBER);
            char rndOp = OPERATORS[random.nextInt(OPERATORS.length)];

            GAME_DATA[i][0] = rndNum1 + " " + rndOp + " " + rndNum2; //question
            GAME_DATA[i][1] = calcExpression(rndNum1, rndNum2, rndOp).toString(); //correct answer
        }
    }

    private static Integer calcExpression(int num1, int num2, char op) {
        Integer correctAnswer = null;
        switch (op) {
            case '+':
                correctAnswer = num1 + num2;
                break;
            case '-':
                correctAnswer = num1 - num2;
                break;
            case '*':
                correctAnswer = num1 * num2;
                break;
            default:
                correctAnswer = null;
        }
        return correctAnswer;
    }

    public static void start() {
        Engine.start(GAME_DATA, RULES);
    }

}
