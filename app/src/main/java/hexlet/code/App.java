package hexlet.code;

import hexlet.code.games.Greet;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;



public class App {
    public static void main(String[] args) {
//        System.out.println("Welcome to the Brain Games!");
//        Cli.hello();
        final int grtCase = 1;
        final int evnCase = 2;
        final int clcCase = 3;
        final int gcdCase = 4;
        final int prgCase = 5;
        final int prmCase = 6;
        final int extCase = 0;
        String[] games = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < games.length; i++) {
            System.out.println(i + " - " + games[i]);
        }
        System.out.println("0 - " + games[0]);

        System.out.print("Your choice: ");
        int userChoice = sc.nextInt();


        switch (userChoice) {
            case grtCase:
                Greet.start();
                break;
            case evnCase:
                Even.prepareGameData();
                Even.start();
                break;
            case clcCase:
                Calc.prepareGameData();
                Calc.start();
                break;
            case gcdCase:
                GCD.prepareGameData();
                GCD.start();
                break;
            case prgCase:
                Progression.prepareGameData();
                Progression.start();
                break;
            case prmCase:
                Prime.prepareGameData();
                Prime.start();
                break;
            case extCase:
                System.out.println("Goodbye, <username>!");
                break;
            default:
                System.out.println("Incorrect input, try again!");
        }

//        if (userChoice > grtCase && userChoice <= prmCase) {
//            Engine.start(gameData, title);
//        }

    }
}
