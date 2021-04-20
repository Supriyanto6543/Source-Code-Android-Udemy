package com.supri.latihankedua;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class LatihanAndroid extends AppCompatActivity {

    TextView rubah;
    Typeface customFonts;
    ImageView img;
    WebView myweb;
    String webku = "http://www.marilahcoding.com";
    int id_user = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        rubah = findViewById(R.id.rubah);

        customFonts = Typeface.createFromAsset(getAssets(), "proximanova-regular.otf");

        rubah.setTypeface(customFonts);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "MY_NOTIFICATION");
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.drawable.aroma4);
        builder.setContentTitle("INI ADALAH APP NOTIFICATION");
        builder.setContentText("INI ADALAH BODY DARI NOTIFICATION");

        NotificationManager manager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        manager.notify(id_user, builder.build());

        img = findViewById(R.id.img);

        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(img);

        myweb = findViewById(R.id.myweb);
        myweb.loadUrl(webku);
        myweb.setWebViewClient(new WebViewClient());

        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("KAMU MAU PILIH YANG MANA?, KLIK YES JIKA BENAR, KLIK NO JIKA INGIN KELUAR");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog showme = builder.create();
        showme.show();*/

    }
}
