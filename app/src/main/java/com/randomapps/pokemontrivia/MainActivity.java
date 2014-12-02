package com.randomapps.pokemontrivia;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity {

//    private final String makeTable = "CREATE TABLE Pokedex (" +
//            "Num varchar(3), " +
//            "Name varchar(20), " +
//            "Elem varchar(50), " +
//            "Evo varchar(20), " +
//            "Height varchar(10), " +
//            "Weight varchar(10), " +
//            "Dex varchar(255)" +
//            ");";
//    private final String populate = "INSERT INTO Pokedex " +
//            "VALUES (" +
//            "1, " +
//            "2, " +
//            "3, " +
//            "4, " +
//            "5, " +
//            "6, " +
//            "7" +
//            ");";

    int DB_VERSION = 1;
    PokeSQLiteHelper pdb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // POKEDEX BUTTON
        // Starts pokedex activity woop
        final Button button = (Button) findViewById(R.id.pokedex);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PokedexActivity.class);
                startActivity(intent);
            }
        });

        // this.deleteDatabase("pokemon.db"); // <- this deletes the database making onCreate() run.

        pdb = new PokeSQLiteHelper(this);
        // NOTE: onCreate() gets called when the object is accessed but not instantiated.
        db = pdb.getWritableDatabase(); // <- onCreate() happens here.
        Cursor c = db.rawQuery("SELECT * FROM Pokedex", null);
        Log.v(this.getClass().getName(), "SQLite STUFF ABOUT TO HAPPEN");
        c.moveToFirst();
        Log.v("TEST", c.getString(6));
        c.close();
        pdb.close();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
