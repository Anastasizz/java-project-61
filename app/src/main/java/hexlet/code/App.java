package hexlet.code;

import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

import static hexlet.code.Engine.GAME_ROUNDS;

public class App {
    public static void main(String[] args) {
//        System.out.println("Welcome to the Brain Games!");
//        Cli.hello();
        final int GRT = 1;
        final int EVN = 2;
        final int CLC = 3;
        final int GCD = 4;
        final int PRG = 5;
        final int PRM = 6;
        final int EXT = 0;
        String[] games = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
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
            case GRT:
                Greet.start();
                break;
            case EVN:
                Even.prepareGameData(gameData);
                title = Even.getTitle();
                break;
            case CLC:
                Calc.prepareGameData(gameData);
                title = Calc.getTitle();
                break;
            case GCD:
                Gcd.prepareGameData(gameData);
                title = Gcd.getTitle();
                break;
            case PRG:
                Progression.prepareGameData(gameData);
                title = Progression.getTitle();
                break;
            case PRM:
                Prime.prepareGameData(gameData);
                title = Prime.getTitle();
                break;
            case EXT:
                System.out.println("Goodbye, <username>!");
                break;
            default:
                System.out.println("Incorrect input, try again!");
        }

        if (userChoice > 1 && userChoice < 7) {
            Engine.start(gameData, title);
        }

    }
}
