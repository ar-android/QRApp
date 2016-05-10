package com.ahmadrosid.qrapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class QRActivity extends AppCompatActivity {

    private ImageView img;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        String encoded_text;
        encoded_text = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        String url = "https://api.qrserver.com/v1/create-qr-code/?data=" + encoded_text +"&size=200x200";

        img = (ImageView) findViewById(R.id.imageQr);
        progressBar = (ProgressBar) findViewById(R.id.pg);

        assert progressBar != null;
        progressBar.setVisibility(View.VISIBLE);
        Glide.with(this).load(url).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(img);

    }

}
