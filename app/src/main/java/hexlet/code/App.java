package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = {"Exit", "Greet", "Even", "Calc"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < games.length; i++) {
            System.out.println(i + " - " + games[i]);
        }
        System.out.println("0 - " + games[0]);

        System.out.print("Your choice: ");
        int userChoice = sc.nextInt();

        Game game = null;
        switch (userChoice) {
            case 1:
                Greet.start();
                break;
            case 2:
                game = new Even();
                break;
            case 3:
                game = new Calc();
                break;
            case 0:
                System.out.println("Goodbye, <username>!");
                break;
            default:
                System.out.println("Incorrect input, try again!");
        }
        if (game != null) {
            Engine engine = new Engine();
            engine.start(game);
        }

    }
}
