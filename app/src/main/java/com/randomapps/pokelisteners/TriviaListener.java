package com.randomapps.pokelisteners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.randomapps.pokemonactivity.TriviaActivity;

/**
 * Created by wonkyulee on 12/2/14.
 */
public class TriviaListener implements View.OnClickListener {
    private Context context;
    public TriviaListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, TriviaActivity.class);
        context.startActivity(intent);
    }
}
