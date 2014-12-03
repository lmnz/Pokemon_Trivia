package com.randomapps.pokemon;

import android.util.Log;

/**
 * Created by wonkyulee on 12/2/14.
 */
public class Pokemon {
    private String pokeId;
    private String pokeName;
    private String pokeType;
    private String toEvo;
    private String pokeHeight;
    private String pokeWeight;
    private String pokeDesc;

    public Pokemon(String id, String name, String type, String evo, String h, String w, String desc) {
        pokeId = id;
        pokeName = name;
        pokeType = type;
        toEvo = evo;
        pokeHeight = h;
        pokeWeight = w;
        pokeDesc = desc;
    }

    public String getPokeId() {
        return pokeId;
    }

    public String getPokeName() {
        return pokeName;
    }

    public String getPokeType() {
        return pokeType;
    }

    public String getToEvo() {
        return toEvo;
    }

    public String getPokeHeight() {
        return pokeHeight;
    }

    public String getPokeWeight() {
        return pokeWeight;
    }

    public String getPokeDesc() {
        return pokeDesc;
    }

    public void printMe() {
        Log.v("POKEMON", "id: " + pokeId);
        Log.v("POKEMON", "name: " + pokeName);
        Log.v("POKEMON", "type: " + pokeType);
        Log.v("POKEMON", "evo: " + toEvo);
        Log.v("POKEMON", "height: " + pokeHeight);
        Log.v("POKEMON", "weight: " + pokeWeight);
        Log.v("POKEMON", "desc: " + pokeDesc);
    }
}