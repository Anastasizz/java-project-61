package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class Calc implements Game {
    private final String[][] gameData = new String[GAME_ROUNDS][2];
    private String introText = "";

    public Calc() {
        this.introText = "What is the result of the expression?";
        prepareGameData();
    }

    public void prepareGameData() {
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

    private String getCorrectAnswer(int num1, int num2, char op) {
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

    public String[][] getGameData() {
        return gameData;
    }

    public String getIntroText() {
        return introText;
    }
}
