package com.randomapps.pokelisteners;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.randomapps.pokemontrivia.TriviaChecker;

/**
 * Created by wonkyulee on 12/3/14.
 */
public class OptionListener implements View.OnClickListener {
    private Activity activity;
    private static final String CORRECT = "CORRECT!";
    private static final String INCORRECT = "INCORRECT!";
    private static final String CORRECT_MSG = "Continue on road the to becoming a Pokémon Master?";
    private static final String INCORRECT_MSG = "Do you want to give up?";
    public OptionListener(Activity activity) {
        this.activity = activity;
    }

    public void onClick (View view) {
        String chosenOne = view.getContentDescription().toString();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        AlertDialog alert = null;
        Log.v("OptionOnClickListener", "Checking to see if " +
                chosenOne + " is the right answer");
        if (TriviaChecker.checkAnswer(chosenOne)) {
            Log.v("OptionOnClickListener", "You are correct!");
            alert = setDialog(alertBuilder, CORRECT, CORRECT_MSG);
            alert.show();
        } else {
            alert = setDialog(alertBuilder, INCORRECT, INCORRECT_MSG);
            alert.show();
            Log.v("OptionOnClickListener", "WRAONG");
        }
    }

    private AlertDialog setDialog(AlertDialog.Builder bob, String title, String msg) {
        bob.setTitle(title);
        bob.setMessage(msg);
        if (title == CORRECT) {
            bob.setPositiveButton("Yes", new OptionNewQuestionListener(activity));
            bob.setNegativeButton("No", new OptionCloseActivityListener(activity));
        }
        else {
            bob.setPositiveButton("Yes", new OptionCloseActivityListener(activity));
            bob.setNegativeButton("No", null);
        }
        return bob.create();
    }

}
