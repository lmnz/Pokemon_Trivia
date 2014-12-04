package com.randomapps.pokemonactivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.randomapps.pokelisteners.OptionCloseActivityListener;
import com.randomapps.pokemontrivia.TriviaChecker;
import com.randomapps.pokemontrivia.TriviaOptionPopulator;


public class TriviaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        TriviaOptionPopulator.setOptions(this);
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
    public void onBackPressed() {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        AlertDialog alert = setDialog(adb);
        alert.show();
    }

    private AlertDialog setDialog(AlertDialog.Builder bob) {
        bob.setTitle("Give up?");
        bob.setMessage("Do you give up already?");
        bob.setPositiveButton("YES", new OptionCloseActivityListener(this));
        bob.setNegativeButton("NO", null);
        return bob.create();
    }
}
