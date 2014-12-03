package com.randomapps.pokemontrivia;

/**
 * Created by wonkyulee on 12/3/14.
 */
public class TriviaChecker extends TriviaOptionPopulator {

    public static String getAnswer() {
        return TriviaOptionPopulator.ansId;
    }

    public static boolean checkAnswer(String chosenId) {
        return ansId == chosenId;
    }
}
