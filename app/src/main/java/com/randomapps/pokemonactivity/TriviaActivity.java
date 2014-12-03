package com.randomapps.pokemonactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.randomapps.pokemon.Pokemon;
import com.randomapps.pokemondb.Pokeball;
import com.randomapps.pokemondb.Util;

import java.util.ArrayList;


public class TriviaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        Pokeball pb = Pokeball.getPokeball(this);
        ArrayList<Pokemon> candidates = pb.openRandomPokeball();
        Pokemon ans = candidates.get(0);
        Pokemon option1 = candidates.get(1);
        Pokemon option2 = candidates.get(2);
        Pokemon option3 = candidates.get(3);

        setContentView(R.layout.activity_trivia);
        TextView tv = (TextView) findViewById(R.id.question);
        ImageView iv = (ImageView) findViewById(R.id.first_pic);
        iv.setImageResource(R.drawable.image1);
        tv.setText(ans.getPokeDesc());

        Util.shufflePokemons(candidates);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pokedex, menu);
        return true;
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
