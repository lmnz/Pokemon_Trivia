package com.randomapps.pokemonactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.randomapps.pokeadapter.PokelistAdapter;
import com.randomapps.pokelisteners.PokedexEntryListener;
import com.randomapps.pokemonactivity.R;

public class PokedexActivity extends Activity {

    ListView pokelist;
    public static String currentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        onResume();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (currentLayout != "list") {
                setContentView(R.layout.activity_pokedex);
                onResume();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        currentLayout = "list";
        pokelist = (ListView) this.findViewById(R.id.pokelist);
        pokelist.setAdapter(new PokelistAdapter(this));
        pokelist.setOnItemClickListener(new PokedexEntryListener(this));
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
