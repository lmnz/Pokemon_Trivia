package com.randomapps.pokelisteners;

import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.randomapps.pokemontrivia.TriviaChecker;
import com.randomapps.pokescore.ScoreKeeper;

/**
 * Created by wonkyulee on 12/3/14.
 */
public class OptionListener implements View.OnClickListener {
    private Activity activity;
    private static final String CORRECT = "CORRECT!";
    private static final String INCORRECT = "INCORRECT!";
    private static final String CORRECT_MSG = "Press the button to continue!";
    private static final String INCORRECT_MSG = null;
    public OptionListener(Activity activity) {
        this.activity = activity;
    }
    private ScoreKeeper sk = ScoreKeeper.getScoreKeeper(activity);

    public void onClick (View view) {
        String chosenOne = view.getContentDescription().toString();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        AlertDialog alert = null;
        Log.v("OptionOnClickListener", "Checking to see if " +
                chosenOne + " is the right answer");
        if (TriviaChecker.checkAnswer(chosenOne)) {
            Log.v("OptionOnClickListener", "You are correct!");
            sk.getScoreKeeper(activity).gotItRight();
            alert = setDialog(alertBuilder, CORRECT, CORRECT_MSG);
            alert.show();
        } else {
            sk.reset();
            alert = setDialog(alertBuilder, INCORRECT, INCORRECT_MSG);
            alert.show();
            Log.v("OptionOnClickListener", "WRAONG");
        }
    }

    private AlertDialog setDialog(AlertDialog.Builder bob, String title, String msg) {
        bob.setTitle(title);
        bob.setOnCancelListener(new OptionCancelCloseListener(activity));
        if (title == CORRECT) {
            bob.setMessage(msg);
            bob.setPositiveButton("Next", new OptionNewQuestionListener(activity));
        }
        else {
            bob.setPositiveButton("Okay...", new OptionNewQuestionListener(activity));
        }
        return bob.create();
    }

}
