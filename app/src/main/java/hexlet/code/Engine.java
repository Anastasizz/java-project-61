package hexlet.code;

import hexlet.code.games.Greet;

import java.util.Scanner;

public class Engine {
    final private static int GAME_ROUNDS = 3;
    final private static int WIN_SCORE = 3;

    public static void start(String[][] gameData, String introText) {
        int round = 0;
        int gameScore = 0;
        String userAnswer = "";
        String correctAnswer = "";

        Greet.start();
        String userName = Greet.getUserName();
        System.out.println(introText);

        while (round < GAME_ROUNDS) {
            printQuestion(gameData[round][0]);
            userAnswer = getUserAnswer();
            correctAnswer = gameData[round][1];

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                gameScore++;
                round++;
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was "
                                   + "'" + correctAnswer + "'" + ".");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
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

    public static int getGameRounds() {
        return GAME_ROUNDS;
    }

    public static int getWinScore() {
        return WIN_SCORE;
    }
}
