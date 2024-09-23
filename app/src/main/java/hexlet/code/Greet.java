package hexlet.code;

import java.util.Scanner;

public class Greet {
    private static String userName = "";

    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");
        userName = sc.next();
        System.out.println("Hello, " + userName + "!");
    }

    public static String getUserName() {
        return userName;
    }
}
