package hexlet.code.games;

import java.util.Random;


public class Calc {
    private static final String TITLE = "What is the result of the expression?";

    public static void prepareGameData(String[][] gameData) {
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
            gameData[i][1] = getCorrectAnswer(rndNum1, rndNum2, rndOp); //correct answer
        }
    }

    public static String getTitle() {
        return TITLE;
    }

    private static String getCorrectAnswer(int num1, int num2, char op) {
        String correctAnswer = "";
        switch (op) {
            case '+':
                correctAnswer = String.valueOf(num1 + num2);
                break;
            case '-':
                correctAnswer = String.valueOf(num1 - num2);
                break;
            case '*':
                correctAnswer = String.valueOf(num1 * num2);
            default:
        }
        return correctAnswer;
    }

}
