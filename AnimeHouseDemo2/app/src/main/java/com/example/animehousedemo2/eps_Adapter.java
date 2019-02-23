package com.example.animehousedemo2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class eps_Adapter extends ArrayAdapter <eps> {

    public eps_Adapter(Context context, int resource, ArrayList<eps> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.episode_item, parent, false);
        }

        eps Eps = getItem(position);

        Button watch = (Button) convertView.findViewById(R.id.watchEps) ;
        Button showRev = convertView.findViewById(R.id.showRB);

        ImageView animePhoto = (ImageView) convertView.findViewById(R.id.animePhoto2) ;
        TextView epsName = (TextView) convertView.findViewById(R.id.epName);
        TextView ebNum = (TextView) convertView.findViewById(R.id.ebNum);

        //animePhoto.setImageBitmap(Eps.getAnimePhoto());
        new loadPhotoURL(animePhoto).execute(Eps.getAnimePhoto());
        epsName.setText(Eps.getEpsName());
        ebNum.setText("eps "+Integer.toString(Eps.getEpsNum()));

        watchButton(watch,position);
        revButton(showRev,position);

        return convertView;
    }



    //HANDLING BUTTONS
    private void watchButton(Button w,int position) {

        final int p = position;

        w.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "ttttttttttttttt", Toast.LENGTH_SHORT).show();
                eps Eps = getItem(p);

                String url = Eps.getVideo_url();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                getContext().startActivity(i);

            }
        });
    }

    private void revButton(Button R,int i) {

        final int p = i;
        R.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "yyyyyyyyyyyyyyy", Toast.LENGTH_SHORT).show();
                eps Eps = getItem(p);
                String url = Eps.getForum_url();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                getContext().startActivity(i);

            }
        });
    }
}

