package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int WIN_SCORE = 3;
    public static final int GAME_ROUNDS = 3;

    public static void start(String[][] gameData, String title) {
        int currRound = 0;
        int gameScore = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        String userName = sc.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(title);

        while (currRound < GAME_ROUNDS) {
            printQuestion(gameData[currRound][0]);
            String userAnswer = getUserAnswer();
            String correctAnswer = gameData[currRound][1];

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                gameScore++;
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'" + ".");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
            currRound++;
        }
        if (gameScore == WIN_SCORE) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    private static void printQuestion(String text) {
        System.out.println("Question: " + text);
    }

    private static String getUserAnswer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your answer: ");
        return sc.next();
    }
}
