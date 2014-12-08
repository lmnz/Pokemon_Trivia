package com.randomapps.pokemonactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.randomapps.pokelisteners.PokedexListener;
import com.randomapps.pokelisteners.TriviaListener;
import com.randomapps.pokescore.ScoreKeeper;


public class MainActivity extends Activity {

    ScoreKeeper sk;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // POKEDEX BUTTON
        // Starts pokedex activity woop
        final Button trivia = (Button) findViewById(R.id.trivia);
        trivia.setOnClickListener(new TriviaListener(this));
        final Button pokedex = (Button) findViewById(R.id.pokedex);
        pokedex.setOnClickListener(new PokedexListener(this));
        sk = ScoreKeeper.getScoreKeeper(this);
        score = (TextView) findViewById(R.id.score);
        // this.deleteDatabase("pokemon.db"); // <- this deletes the database making onCreate() run.
    }

    @Override
    protected void onResume() {
        score.setText(sk.getHighScoreString());
        super.onResume();
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
}
