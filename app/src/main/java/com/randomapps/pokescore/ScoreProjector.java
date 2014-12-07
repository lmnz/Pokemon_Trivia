package com.randomapps.pokescore;

import android.app.Activity;
import android.widget.TextView;

import com.randomapps.pokemonactivity.R;

/**
 * Created by wonkyulee on 12/6/14.
 */
public class ScoreProjector {
    private TextView hot;
    private TextView current;
    private ScoreKeeper sk;

    public ScoreProjector(Activity activity) {
        hot = (TextView) activity.findViewById(R.id.hotstreak);
        current = (TextView) activity.findViewById(R.id.currentstreak);
        sk = ScoreKeeper.getScoreKeeper(activity);
    }

    public void setTriviaScores() {
        hot.setText(sk.getHighScoreString());
        current.setText(sk.getCurrentScoreString());
    }
}
