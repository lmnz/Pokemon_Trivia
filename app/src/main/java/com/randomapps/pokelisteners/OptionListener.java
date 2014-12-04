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
    private static final String CORRECT_MSG = "Would you like to continue?";
    private static final String INCORRECT_MSG = null;
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
        if (title == CORRECT) {
            bob.setMessage(msg);
            bob.setPositiveButton("Yes", new OptionNewQuestionListener(activity));
            bob.setNegativeButton("No", new OptionCloseActivityListener(activity));
            bob.setOnCancelListener(new OptionCancelCloseListener(activity));
        }
        else {
            bob.setPositiveButton("Okay..", null);
        }
        return bob.create();
    }

}
