package com.randomapps.pokemondb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wonkyulee on 11/15/14.
 * pokedex.db model class
 * This class uses SQLiteOpenHelper to open, populate, and update the pokedex.db
 * with schema and tuples grabbed from the PokeSchemaService class
 */
public class PokeSQLiteHelper extends SQLiteOpenHelper {

//    private final String DB_NAME = "pokemon.db";
//    private final int DB_VERSION = 1;

    private static SQLiteDatabase db;
    private static PokeSchemaService pss;

    public PokeSQLiteHelper (Context context) {
        super(context, PokeSchemaService.DB_NAME, null, PokeSchemaService.DB_VERSION);
        pss = PokeSchemaService.getPokeSchemaService(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        PokeSQLiteHelper.db = db;

        db.execSQL(pss.getPokeSchema());
        String[] pokeTuple = pss.getPokeTuple();
        // Populating table!
        Log.v(this.getClass().getName(), "onCreate() populating database");
        for (int i = 0; i < pokeTuple.length; i++) {
            db.execSQL(pokeTuple[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO: pokedex upgrade algorithm needs to be written!
    }

    public static SQLiteDatabase getConnection() {
        return db;
    }

}
