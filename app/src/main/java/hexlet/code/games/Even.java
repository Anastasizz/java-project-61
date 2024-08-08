package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.GAME_ROUNDS;

public class Even implements Game {
    private final String[][] gameData = new String[GAME_ROUNDS][2];
    private String introText = "";

    public Even() {
        this.introText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        prepareGameData();
    }

    public void prepareGameData() {
        Random random = new Random();
        int randomNumber = 0;

        for (int i = 0; i < gameData.length; i++) {
            randomNumber = random.nextInt(100);
            gameData[i][0] = String.valueOf(randomNumber); //question
            gameData[i][1] = (randomNumber % 2 == 0) ? "yes" : "no"; //correct answer
        }
    }

    public String[][] getGameData() {
        return gameData;
    }

    public String getIntroText() {
        return introText;
    }
}
