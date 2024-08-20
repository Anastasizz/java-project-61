package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Greet;
import hexlet.code.games.Calc;

import java.util.Scanner;

import static hexlet.code.Engine.GAME_ROUNDS;

public class App {
    public static void main(String[] args) {
//        System.out.println("Welcome to the Brain Games!");
//        Cli.hello();
        String[] games = {"Exit", "Greet", "Even", "Calc"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < games.length; i++) {
            System.out.println(i + " - " + games[i]);
        }
        System.out.println("0 - " + games[0]);

        System.out.print("Your choice: ");
        int userChoice = sc.nextInt();

        String[][] gameData = new String[GAME_ROUNDS][2];
        String title = "";
        switch (userChoice) {
            case 1:
                Greet.start();
                break;
            case 2:
                Even.prepareGameData(gameData);
                title = Even.getTitle();
                break;
            case 3:
                Calc.prepareGameData(gameData);
                title = Even.getTitle();
                break;
            case 0:
                System.out.println("Goodbye, <username>!");
                break;
            default:
                System.out.println("Incorrect input, try again!");
        }

        if (userChoice > 1) {
            Engine.start(gameData, title);
        }

    }
}
