package com.example.animehousedemo2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class top_Adapter extends ArrayAdapter<tob_item> {

    public top_Adapter(Context context, int resource, ArrayList<tob_item> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.top_item, parent, false);
        }

        tob_item top = getItem(position);


        Button showRev = convertView.findViewById(R.id.showRBT);

        ImageView animePhoto = (ImageView) convertView.findViewById(R.id.animePhoto3);
        TextView animeName = (TextView) convertView.findViewById(R.id.animeName3);
        TextView rank = (TextView) convertView.findViewById(R.id.rank);
        TextView type = (TextView) convertView.findViewById(R.id.type);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        //animePhoto.setImageResource(top.getAnimePhoto());
        new loadPhotoURL(animePhoto).execute(top.getAnimePhoto());
        animeName.setText(top.getAnimeName());
        rank.setText("rank " + Integer.toString(top.getAnimeRank()));
        type.setText("type: " + top.getType());
        date.setText("date: " + top.getDate());

        revButton(showRev, position);

        return convertView;
    }

    private void revButton(Button R, int position) {

        final int p = position;

        R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tob_item top = getItem(p);
                //Toast.makeText(getContext(), "yyyyyyyyyyyyyyy", Toast.LENGTH_SHORT).show();
                String url = top.getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                getContext().startActivity(i);

            }
        });
    }
}