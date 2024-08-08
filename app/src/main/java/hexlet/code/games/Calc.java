package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    public static void start() {
        final int gameRounds = Engine.getGameRounds();
        String introText = "What is the result of the expression?";
        String[][] gameData = new String[gameRounds][2];

        prepareGameData(gameData);
        Engine.start(gameData, introText);
    }

    private static void prepareGameData(String[][] gameData) {
        char[] operators = {'+', '*', '-'};
        char rndOp = '+';
        int rndNum1 = 0;
        int rndNum2 = 0;
        Random random = new Random();

        for (int i = 0; i < gameData.length; i++) {
            rndNum1 = random.nextInt(100);
            rndNum2 = random.nextInt(100);
            rndOp = operators[random.nextInt(3)];

            gameData[i][0] = rndNum1 + " " + rndOp + " " + rndNum2; //question
            gameData[i][1] = getCorrectAnswer(rndNum1, rndNum2, rndOp); //correct answer
        }
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
