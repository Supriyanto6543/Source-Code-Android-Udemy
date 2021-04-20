package com.supri.latihankedua;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button clickMe; //VARIABLE GLOBAL
    CoordinatorLayout root; //VARIABLE GLOBAL
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickMe = findViewById(R.id.clickMe);
        root = findViewById(R.id.root);
        textView = findViewById(R.id.textView);

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickMe.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "BERHASIL DI KLIK BUTTONNYA", Toast.LENGTH_LONG).show();
                Snackbar.make(root, "YEAH, BUTTON BERHASIL DI KLIK", Snackbar.LENGTH_LONG).show();
            }
        });

        for (int i = 0; i < 10; i++){
            Log.d("CODEKU", i + "");
            textView.setText("" + i);

        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MULAI", "ACTIVITY MULAI");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("RESUME", "ACTIVITY RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("PAUSE", "ACTIVITY PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STOP", "ACTIVITY STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
