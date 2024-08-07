package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Even {
    final public static int GAME_ROUNDS = 3;
    final public static int WIN_SCORE = 3;

    public static void start() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int round = 0;
        int gameScore = 0;
        int randomNumber = 0;
        String userAnswer = "";
        String correctAnswer = "";
        String userName;

        Greet.start();
        userName = Greet.getUserName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (round < GAME_ROUNDS) {
            randomNumber = random.nextInt(100);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            userAnswer = sc.next();
            correctAnswer = ( randomNumber % 2 == 0 ) ? "yes" : "no";

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                round++;
                gameScore++;
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'" + ".");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (gameScore == WIN_SCORE) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
