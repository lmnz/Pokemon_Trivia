package com.randomapps.pokescore;

import android.app.Activity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wonkyulee on 12/5/14.
 */
public class ScoreKeeper {
    private static int h_score = 0; // score is 0 by default
    private static int score = 0; // score is 0 by default

    private static ScoreKeeper instance;
    private static Activity activity;
    private static final String scoreFileName = "score";
    private static FileOutputStream fos;
    private static FileInputStream fis;
    private String scoreTemplate = "Hot Streak: ";

    private ScoreKeeper (Activity activity) {
        ScoreKeeper.activity = activity;
    }

    public static ScoreKeeper getScoreKeeper(Activity activity) {
        if (instance == null) {
            instance = new ScoreKeeper(activity);
            initializeScore();
            readScore();
        }
        return instance;
    }

    private static void initializeScore() {
        File file = new File(activity.getFilesDir(), scoreFileName);
        if (file.exists()) {
            // file exists! grab score :)
            h_score = readScore();
        } else {
            // file doesn't exist! so we initialize it with value 0.
            writeScore();
        }
    }

    // reads the score file and returns the content of it
    private static int readScore() {
        try {
            fis = activity.openFileInput(scoreFileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String readLine = br.readLine();
            fis.close();
            br.close();
            Log.v("Setting score to: ", readLine);
            return Integer.parseInt(readLine);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void writeScore () {
        try {
            fos = activity.openFileOutput(scoreFileName, activity.MODE_PRIVATE);
            fos.write(new Integer(h_score).toString().getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkNewScore(int newScore) {
        if (newScore > h_score) {
            // logic to rewrite old score
            h_score = newScore;
            writeScore();
            return true;
        }
        // else do nothing
        return false;
    }

    public void reset() {
        score = 0;
    }

    public boolean gotItRight() {
        score++;
        return checkNewScore(score);
    }

    public static int getScore() {
        return score;
    }

    public static int getHighScore() {
        return h_score;
    }

    public String getHighScoreString() {
        return scoreTemplate + new Integer(h_score).toString();
    }

}
