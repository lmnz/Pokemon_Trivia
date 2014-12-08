package com.randomapps.pokeadapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.randomapps.pokemon.Pokemon;
import com.randomapps.pokemonactivity.R;
import com.randomapps.pokemondb.Pokeball;

import java.util.ArrayList;

/**
 * Created by wonkyulee on 12/6/14.
 */
public class PokelistAdapter extends BaseAdapter {
    static ArrayList<Pokemon> pokelist = null;
    LayoutInflater layoutInflater;
    String pokeUri_template;
    Context activity;


    public PokelistAdapter (Context context) {
        activity = context;
        if (pokelist == null)
            pokelist = Pokeball.getPokeball(context).getAllPokemon();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pokelist.size();
    }

    @Override
    public Object getItem(int position) {
        return pokelist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.pokedex_entry_layout, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.pokemon_nameId);
            holder.description = (TextView) view.findViewById(R.id.pokemon_desc);
            holder.avatar = (ImageView) view.findViewById(R.id.pokeicon);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        Pokemon display = pokelist.get(position);
        holder.name.setText(display.getPokeId() + ": " + display.getPokeName());
        holder.description.setText(display.getPokeDesc());
        pokeUri_template = "android.resource://" + activity.getPackageName() + "/drawable/image";
        Uri imageUri = Uri.parse(pokeUri_template + display.getPokeId().replaceFirst("^0+(?!$)", ""));
        holder.avatar.setImageURI(imageUri);
        return view;
    }

    private class ViewHolder {
        public ImageView avatar;
        public TextView name, description;
    }
}
