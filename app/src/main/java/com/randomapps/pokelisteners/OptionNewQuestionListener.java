package com.randomapps.pokelisteners;

import android.app.Activity;
import android.content.DialogInterface;

import com.randomapps.pokemontrivia.TriviaOptionPopulator;

/**
 * Created by wonkyulee on 12/3/14.
 */
public class OptionNewQuestionListener implements DialogInterface.OnClickListener {
    Activity activity;

    public OptionNewQuestionListener(Activity activity) {
        this.activity = activity;
    }
    public void onClick(DialogInterface di, int i) {
        TriviaOptionPopulator.setOptions(activity);
    }
}
