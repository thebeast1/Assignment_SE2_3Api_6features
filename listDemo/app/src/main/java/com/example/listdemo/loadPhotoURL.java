package com.example.listdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;

public class loadPhotoURL extends AsyncTask<String ,Void,Bitmap> {

    Bitmap bit;
    ImageView IMG;
    public loadPhotoURL(ImageView img) {
        IMG = img;
    }

    @Override
    protected Bitmap doInBackground(String... url) {
        String Url = url[0];

        try {

            InputStream Inpstr = new java.net.URL(Url).openStream();
            bit = BitmapFactory.decodeStream(Inpstr);

        }catch (Exception e ){
            e.printStackTrace();
        }
        return bit;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        IMG.setImageBitmap(bitmap);
    }
}
