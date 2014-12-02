package com.randomapps.pokemontrivia;

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
        super(context, "pokemon.db", null, 1);
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
        // DO NOTHING (for now)
    }

    public static SQLiteDatabase getConnection() {
        return db;
    }

}
