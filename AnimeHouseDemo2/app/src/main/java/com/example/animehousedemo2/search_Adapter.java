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

public class search_Adapter extends ArrayAdapter<search_item> {
    public search_Adapter(Context context, int resource, ArrayList<search_item> objects) {
        super(context, 0, objects);
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.search_item, parent, false);
        }

        search_item top = getItem(position);


        Button showRev = convertView.findViewById(R.id.showRBT2);

        ImageView animePhoto = (ImageView) convertView.findViewById(R.id.animePhoto4);
        TextView animeName = (TextView) convertView.findViewById(R.id.animeName4);
        TextView rank = (TextView) convertView.findViewById(R.id.rate);
        TextView type = (TextView) convertView.findViewById(R.id.type2);
        TextView date = (TextView) convertView.findViewById(R.id.date2);
        TextView desc = (TextView) convertView.findViewById(R.id.desc);

        //animePhoto.setImageResource(top.getAnimePhoto());
        new loadPhotoURL(animePhoto).execute(top.getImage_url());
        animeName.setText(top.getTitle());
        rank.setText("rate " + Integer.toString(top.getScore()));
        desc.setText( top.getSynopsis());
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
                search_item top = getItem(p);
                //Toast.makeText(getContext(), "yyyyyyyyyyyyyyy", Toast.LENGTH_SHORT).show();
                String url = top.getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                getContext().startActivity(i);

            }
        });
    }



}
