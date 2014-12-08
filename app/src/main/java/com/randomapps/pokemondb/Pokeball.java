package com.randomapps.pokemondb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.randomapps.pokemon.Pokemon;

import java.util.ArrayList;

/**
 * Created by wonkyulee on 12/2/14.
 * This class uses PokeSQLiteHelper to run queries. SERVE ALL THE POKEMON!!
 */
public class Pokeball {
    private static PokeSQLiteHelper pdb;
    private static Pokeball pg = null;
    private static SQLiteDatabase db;


    protected Pokeball() {
        // do nuttin
    }

    public static Pokeball getPokeball (Context context) {
        if (pg == null) {
            pg = new Pokeball();
            pdb = new PokeSQLiteHelper(context);
            db = pdb.getWritableDatabase();
        }
        return pg;
    }

    public ArrayList<Pokemon> openRandomPokeball() {
        Cursor c = db.rawQuery("SELECT * FROM Pokedex ORDER BY RANDOM() LIMIT 4;", null);
        c.moveToFirst();
        ArrayList<Pokemon> result = new ArrayList<Pokemon>();
        result.add(new Pokemon(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
                c.getString(4), c.getString(5), c.getString(6)));
        c.moveToNext();
        result.add(new Pokemon(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
                c.getString(4), c.getString(5), c.getString(6)));
        c.moveToNext();
        result.add(new Pokemon(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
                c.getString(4), c.getString(5), c.getString(6)));
        c.moveToNext();
        result.add(new Pokemon(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
                c.getString(4), c.getString(5), c.getString(6)));
        for (int i = 0; i < result.size(); i++) {
            result.get(i).printMe();
        }
        c.close();
        return result;
    }

    public Pokemon iChooseYou(String name) {
        Cursor c = db.rawQuery("SELECT * FROM Pokedex WHERE Name = '" + name + "';", null);
        c.moveToFirst();
        Pokemon result = new Pokemon(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
                c.getString(4), c.getString(5), c.getString(6));
        result.printMe();
        c.close();
        return result;
    }

    public ArrayList<Pokemon> getAllPokemon() {
        Cursor c = db.rawQuery("SELECT * FROM Pokedex", null);
        c.moveToFirst();
        ArrayList<Pokemon> result = new ArrayList<Pokemon>();
        while (!c.isLast()) {
            result.add(new Pokemon(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
                    c.getString(4), c.getString(5), c.getString(6)));
            c.moveToNext();
        }
        // add the last pokemon
        result.add(new Pokemon(c.getString(0), c.getString(1), c.getString(2), c.getString(3),
                c.getString(4), c.getString(5), c.getString(6)));

        return result;
    }
}
