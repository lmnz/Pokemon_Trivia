package com.randomapps.pokelisteners;

import android.app.Activity;
import android.content.DialogInterface;

/**
 * Created by wonkyulee on 12/3/14.
 */
public class OptionCancelCloseListener implements DialogInterface.OnCancelListener{

    Activity activity;

    public OptionCancelCloseListener(Activity activity) {
        this.activity = activity;
    }

    public void onCancel(DialogInterface di) {
        activity.finish();
    }
}
