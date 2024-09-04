package hexlet.code.games;

import hexlet.code.Engine;
import static hexlet.code.Engine.GAME_ROUNDS;

import java.util.Random;


public class Calc {
    private static final String TITLE = "What is the result of the expression?";
    private static String[][] gameData = new String[GAME_ROUNDS][2];

    public static void prepareGameData() {
        char[] operators = {'+', '*', '-'};
        final int bound = 100;
        char rndOp = '+';
        int rndNum1 = 0;
        int rndNum2 = 0;
        Random random = new Random();

        for (int i = 0; i < gameData.length; i++) {
            rndNum1 = random.nextInt(bound);
            rndNum2 = random.nextInt(bound);
            rndOp = operators[random.nextInt(operators.length)];

            gameData[i][0] = rndNum1 + " " + rndOp + " " + rndNum2; //question
            gameData[i][1] = calcExpression(rndNum1, rndNum2, rndOp).toString(); //correct answer
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
        Engine.start(gameData, TITLE);
    }

}
