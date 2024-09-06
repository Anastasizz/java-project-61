package hexlet.code;

import hexlet.code.games.Greet;

import java.util.Scanner;

public class Engine {
    public static final int WIN_SCORE = 3;
    public static final int GAME_ROUNDS = 3;

    public static void start(String[][] gameData, String title) {
        int currRound = 0, gameScore = 0;

        Greet.start();
        String userName = Greet.getUserName();
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
