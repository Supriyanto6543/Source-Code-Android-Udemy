package com.supri.latihankedua;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    int duration = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);*/

                /*Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, "ini head");
                intent.putExtra(Intent.EXTRA_SUBJECT, "ini subject");
                intent.putExtra(Intent.EXTRA_TEXT, "ini unuk isi");
                startActivity(Intent.createChooser(intent, "kirim lewat apa?"));*/

                Intent web = new Intent(SplashScreen.this, LatihanAndroid.class);
                startActivity(web);
                finish();

               /*try{
                   Intent webPencarian = new Intent(Intent.ACTION_WEB_SEARCH);
                   webPencarian.putExtra(SearchManager.QUERY, "tutorial android");
                   startActivity(webPencarian);
               }catch (Exception e){
                   Toast.makeText(getApplicationContext(), "APPS TIDAK SUPPORT DI HP ANDROID INI", Toast.LENGTH_LONG).show();
               }*/

               /*String[] tryCatch = {"android", "dev", "flutter"};

               try {
                   Toast.makeText(getApplicationContext(), "BENAR" + tryCatch[2], Toast.LENGTH_LONG).show();
               }catch (Exception i){
                   Toast.makeText(getApplicationContext(), "SALAH", Toast.LENGTH_LONG).show();
               }*/


            }
        }, duration);

    }
}
