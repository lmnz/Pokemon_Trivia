package com.randomapps.pokelisteners;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.randomapps.pokeadapter.PokelistAdapter;
import com.randomapps.pokemon.Pokemon;
import com.randomapps.pokemonactivity.PokedexActivity;
import com.randomapps.pokemonactivity.R;

/**
 * Created by wonkyulee on 12/7/14.
 */
public class PokedexEntryListener implements ListView.OnItemClickListener {
    Activity activity;
    Pokemon picked;
    String pokeUri_template;

    public PokedexEntryListener(Activity activity) {
        this.activity = activity;
        pokeUri_template = "android.resource://" + activity.getPackageName() + "/drawable/image";
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        picked = (Pokemon) new PokelistAdapter(activity).getItem(position);
        activity.setContentView(R.layout.pokedex_fullentry_layout);
        ViewHolder vh = new ViewHolder();
        vh.setLayout();
        PokedexActivity.currentLayout = "entry";
    }

    private class ViewHolder {
        ImageView avatar;
        TextView id, name, height, weight, desc;
        public ViewHolder () {
            avatar = (ImageView) activity.findViewById(R.id.full_entry_pic);
            id = (TextView) activity.findViewById(R.id.full_entry_id);
            name = (TextView) activity.findViewById(R.id.full_entry_name);
            height = (TextView) activity.findViewById(R.id.full_entry_height);
            weight = (TextView) activity.findViewById(R.id.full_entry_weight);
            desc = (TextView) activity.findViewById(R.id.full_entry_desc);
        }
        public void setLayout() {
            id.setText("No. " + picked.getPokeId());
            name.setText(picked.getPokeName());
            height.setText("Height: " + picked.getPokeHeight());
            weight.setText("Weight: " + picked.getPokeWeight());
            desc.setText(picked.getPokeDesc());

            Uri avatarUri =
                    Uri.parse(pokeUri_template + picked.getPokeId().replaceFirst("^0+(?!$)", ""));
            avatar.setImageURI(avatarUri);
        }
    }
}
