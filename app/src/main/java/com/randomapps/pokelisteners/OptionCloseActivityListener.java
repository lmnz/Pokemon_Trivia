package com.randomapps.pokelisteners;

import android.app.Activity;
import android.content.DialogInterface;

/**
 * Created by wonkyulee on 12/3/14.
 */
public class OptionCloseActivityListener implements DialogInterface.OnClickListener {
    Activity activity;

    public OptionCloseActivityListener(Activity activity) {
        this.activity = activity;
    }
    public void onClick(DialogInterface di, int i) {
        activity.finish();
    }
}
