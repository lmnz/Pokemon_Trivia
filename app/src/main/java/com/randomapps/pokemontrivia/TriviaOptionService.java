package com.randomapps.pokemontrivia;

import com.randomapps.pokemonactivity.R;

/**
 * Created by wonkyulee on 12/2/14.
 */
public class TriviaOptionService {
    private static int[] optTextId;
    private static int[] optPicId;
    private static TriviaOptionService inst = null;
    private static final int NUM_OPTS = 4;

    protected TriviaOptionService() {
        setOptTextId();
        setOptPicId();
    }

    public static TriviaOptionService getTriviaOptionService () {
        if (inst == null) {
            inst = new TriviaOptionService();
        }
        return inst;
    }

    private void setOptTextId() {
        optTextId = new int[NUM_OPTS];
        optTextId[0] = R.id.first_text;
        optTextId[1] = R.id.second_text;
        optTextId[2] = R.id.third_text;
        optTextId[3] = R.id.fourth_text;
    }
    private void setOptPicId() {
        optPicId = new int[NUM_OPTS];
        optPicId[0] = R.id.first_pic;
        optPicId[1] = R.id.second_pic;
        optPicId[2] = R.id.third_pic;
        optPicId[3] = R.id.fourth_pic;
    }
    public int[] getOptTextId() {
        return optTextId;
    }
    public int[] getOptPicId() {
        return optPicId;
    }
}
