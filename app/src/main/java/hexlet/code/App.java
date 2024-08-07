package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Greet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = {"Exit", "Greet", "Even"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < games.length; i++) {
            System.out.println(i + " - " + games[i]);
        }
        System.out.println("0 - " + games[0]);

        System.out.print("Your choice: ");
        int userChoice = sc.nextInt();

        switch (userChoice) {
            case 1:
                Greet.start();
                break;
            case 2:
                Even.start();
                break;
            case 0:
                System.out.println("Goodbye, <username>!");
                break;
            default:
                System.out.println("Incorrect input, try again!");
        }
    }
}
