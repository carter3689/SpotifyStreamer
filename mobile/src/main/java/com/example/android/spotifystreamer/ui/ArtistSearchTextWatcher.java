package com.example.android.spotifystreamer.ui;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by jc on 6/30/15.
 */
public class ArtistSearchTextWatcher implements TextWatcher {

    private EditText mArtistSearchBox;

    private static final String TAG =ArtistSearchTextWatcher.class.getSimpleName();
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String text = mArtistSearchBox.getText().toString().trim();
        if (text.length()> 2){
            Log.d(TAG, text);
            FetchArtistsTask artistsTask = new FetchArtistsTask();
            artistsTask.execute(text);
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


}
