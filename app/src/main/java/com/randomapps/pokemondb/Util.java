package com.randomapps.pokemondb;

import android.util.Log;

import com.randomapps.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wonkyulee on 12/2/14.
 */
public class Util {
    public static void shufflePokemons (ArrayList<Pokemon> candidates) {
        Log.v("Util.shufflePokemons()", "Everyday I'm shuffling!");
        Pokemon temp = null;
        Random rand = new Random();
        int r;
        int len = candidates.size();
        for (int i = 0; i < len; i++) {
            r = rand.nextInt(len - i) + i;
            temp = candidates.get(i);
            candidates.set(i, candidates.get(r));
            candidates.set(r, temp);
        }
    }
}
