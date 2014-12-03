package com.randomapps.pokemondb;

import android.content.Context;

import com.randomapps.pokemonactivity.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by wonkyulee on 11/30/14.
 * This class will hold all the schema information of the pokedex.db database
 */
public class PokeSchemaService {

    public static final String DB_NAME = "pokemon.db";
    public static final int DB_VERSION = 1;

    private static PokeSchemaService singleInstance = null;

    private static Context context;
    private static String pokeSchema = "CREATE TABLE Pokedex (" +
        "Num varchar(3), " +
        "Name varchar(20), " +
        "Elem varchar(50), " +
        "Evo varchar(20), " +
        "Height varchar(10), " +
        "Weight varchar(10), " +
        "Dex varchar(255)" +
        ");";

    private static String[] pokeTuple;

    private static final String pokeTupleTemplate = "INSERT INTO Pokedex VALUES";

    // constructor, this is a singleton so it's just poop here
    protected PokeSchemaService() {
        // DO NUTTIN
    }

    public static PokeSchemaService getPokeSchemaService(Context context) {
        if (singleInstance == null) {
            PokeSchemaService.context = context;
            singleInstance = new PokeSchemaService();
            PokeSchemaService.setPokeTuple();
        }
        return singleInstance;
    }

    public String getPokeSchema() {
        return pokeSchema;
    }

    public String[] getPokeTuple() {
        return pokeTuple;
    }

    public static void setPokeTuple() {
        // read and parse csv file to serve each pokemon in INSERT statement ready format.
        // EX: "INSERT INTO Pokedex VALUES ( 1, 2, 3, 4, 5, 6, 7);"
        try {
            // open csv file!
            ArrayList<String> pokeTupleList = new ArrayList<String>();
            InputStream is = context.getResources().openRawResource(R.raw.pokedex);
            BufferedReader pokeReader = new BufferedReader(new InputStreamReader(is));
            String readLine;
            // read csv file!
            while ((readLine = pokeReader.readLine()) != null) {
                // format and add to array list!
                readLine = "INSERT INTO Pokedex VALUES (" + readLine + ");";
                pokeTupleList.add(readLine);
                // Log.v("csv reading!", readLine);
            }
            // converting from ArrayList<String> to String[]
            pokeTuple = new String[pokeTupleList.size()];
            pokeTuple = pokeTupleList.toArray(pokeTuple);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







