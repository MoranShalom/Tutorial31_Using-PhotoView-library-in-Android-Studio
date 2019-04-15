package com.example.imagezoomin;

/** In order to be able to use PhotoView library we need to do the following steps:
1. Open up build.gradle (Module:app) and add PhotoView library
   -> implementation 'com.github.chrisbanes:PhotoView:2.1.3'
2.  open up build.gradle (Project) and you need to add this line
 maven { url "https://jitpack.io" } inside (allprojects) tag.

 3.  open up build.gradle (Project) and you need to add this line
 maven { url 'https://maven.google.com' } inside (buildscript) tag.
 */


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private ImageView eiffel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title= (TextView) findViewById(R.id.TitelTV);
        description=  (TextView) findViewById(R.id.descriptionTV);
        eiffel= (ImageView) findViewById(R.id.eiffelview);

        //Next you need to change the shape of ImageView (ivIcon) to circle using RoundedBitmapDrawable and Bitmap.

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.eiffel);
        RoundedBitmapDrawable mDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        mDrawable.setCircular(true);
        eiffel.setImageDrawable(mDrawable);


        //to be able to tap on the ImageView you will need to use setOnClickListener and
        // inside onClick is where you will create AlertDialog.

        eiffel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder= new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
                PhotoView photoView= mView.findViewById(R.id.imageView);
                photoView.setImageResource(R.drawable.eiffel);
                mBuilder.setView(mView);
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
             }
        });



    }
}
