package com.example.android.spotifystreamer.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.spotifystreamer.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import info.SpotifyArtist;

/**
 * Created by jc on 6/28/15.
 */
public class ArtistsAdapter extends ArrayAdapter <SpotifyArtist> {
    private Context mContext;
    private int mResource;
    private ArrayList<SpotifyArtist> mItems;

    public ArtistsAdapter(Context context, int resource, ArrayList<SpotifyArtist> items) {

        super(context, resource, items);

        mContext = context;
        mResource = resource;
        mItems = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        SpotifyArtist artist = getItem(position);
        viewHolder.nameView.setText(artist.name);
        if (artist.imageURL != null) {
            Picasso.with(mContext).load(artist.imageURL).into(viewHolder.imageView);
        } else {
            Picasso.with(mContext).load(R.drawable.ic_launcher).into(viewHolder.imageView);
        }

        return view;
    }

    public SpotifyArtist getItem(Object position) {
        return null;
    }



    /**
     * Cache of the children views for a forecast list item.
     */
    public static class ViewHolder {
        public final ImageView imageView;
        public final TextView nameView;

        public ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.list_item_image_artist);
            nameView = (TextView) view.findViewById(R.id.list_item_name_artist);
        }
    }
}
