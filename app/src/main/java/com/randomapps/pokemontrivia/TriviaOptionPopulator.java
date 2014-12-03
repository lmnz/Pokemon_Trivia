package com.randomapps.pokemontrivia;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.randomapps.pokemon.Pokemon;
import com.randomapps.pokemonactivity.R;
import com.randomapps.pokemondb.Pokeball;
import com.randomapps.pokemondb.Util;

import java.util.ArrayList;

/**
 * Created by wonkyulee on 12/2/14.
 */
public abstract class TriviaOptionPopulator {

    private static String pokeUri_template;

    public static void setOptions(Activity activity, Context context) {
        TextView text = (TextView) activity.findViewById(R.id.question);
        Pokeball pb = Pokeball.getPokeball(context);
        ArrayList<Pokemon> candidates = pb.openRandomPokeball();
        text.setText(candidates.get(0).getPokeDesc());
        Util.shufflePokemons(candidates);
        pokeUri_template = "android.resource://" + activity.getPackageName() + "/drawable/image";
        TriviaOptionService tos = TriviaOptionService.getTriviaOptionService();
        for (int i = 0; i < candidates.size(); i++) {
            setOption(activity, tos.getOptTextId()[i], tos.getOptPicId()[i], candidates.get(i));
        }
    }

    private static void setOption(Activity activity, int textId, int picId, Pokemon candidate) {
        TextView text = (TextView) activity.findViewById(textId);
        text.setText(candidate.getPokeName());
        ImageView image = (ImageView) activity.findViewById(picId);
        image.setImageURI(Uri.parse(pokeUri_template + candidate.getPokeId().replaceFirst("^0+(?!$)", "")));
    }
}
