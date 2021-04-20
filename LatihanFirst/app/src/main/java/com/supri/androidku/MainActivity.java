package com.supri.androidku;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.supri.androidku.fragments.FragmentFavourites;
import com.supri.androidku.fragments.FragmentHelp;
import com.supri.androidku.fragments.FragmentHome;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.latihan_widgets);

        bottom = findViewById(R.id.bottom_navigation);
        bottom.setOnNavigationItemSelectedListener(this);

        tampilkanFragment(new FragmentHome());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int i = menuItem.getItemId();
        Fragment f = null;

        switch (i){
            case R.id.home:
                f = new FragmentHome();
                break;

            case R.id.fav:
                f = new FragmentFavourites();
                break;

            case R.id.help:
                f = new FragmentHelp();
                break;

        }

        return tampilkanFragment(f);
    }

    private boolean tampilkanFragment(Fragment f) {

        if (f != null){

            getSupportFragmentManager().beginTransaction().replace(R.id.fm_layout, f).commit();

        }

        return false;
    }
}
