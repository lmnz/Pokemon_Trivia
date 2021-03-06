package com.randomapps.pokemonactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.randomapps.pokemontrivia.TriviaOptionPopulator;
import com.randomapps.pokescore.ScoreProjector;


public class TriviaActivity extends Activity {

    ScoreProjector ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        TriviaOptionPopulator.setOptions(this);
        ss = new ScoreProjector(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onResume() {
        ss.setTriviaScores();
        super.onResume();
    }
}
