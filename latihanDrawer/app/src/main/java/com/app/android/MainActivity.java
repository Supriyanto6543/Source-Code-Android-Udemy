package com.app.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.android.myadapter.MyAdapter;
import com.app.android.mymodal.MyModal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recycler_view;
    DrawerLayout drawer;

    MyAdapter myAdapter;
    GridLayoutManager gm;
    ArrayList<MyModal> myModals;
    RequestQueue queue;
    String url = "http://192.168.43.210/ebook/api.php?ebooks";
    String urls = "https://newsapi.org/v2/top-headlines?country=id&apiKey=94dbfe81124e4f6eaa34583005e20cb0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "FAB DI TEKAN", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        queue = Volley.newRequestQueue(this);

        recycler_view = findViewById(R.id.recycler_view);
        gm = new GridLayoutManager(this, 2);
        recycler_view.setLayoutManager(gm);
        myModals = new ArrayList<>();

        tampilkanDataUser();
    }

    private void tampilkanDataUser(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urls, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Berhasil", response + "");

                try {
                    JSONArray array = response.getJSONArray("articles");
                    for (int i = 0; i < array.length(); i++){

                        JSONObject object = array.getJSONObject(i);
                        String title = object.getString("title");
                        String image = object.getString("urlToImage");

                        MyModal myModal = new MyModal(title, image);
                        myModals.add(myModal);
                        myAdapter = new MyAdapter(getApplicationContext(), myModals);
                        recycler_view.setAdapter(myAdapter);
                        myAdapter.notifyDataSetChanged();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Errorku", error + "");
            }
        });
        queue.add(jsonObjectRequest);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(getApplicationContext(), "KAMU KLIK HOME", Toast.LENGTH_LONG).show();
            Snackbar.make(drawer, "KAMU KLIK HOME", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(), "KAMU KLIK GALLERY", Toast.LENGTH_LONG).show();
            Snackbar.make(drawer, "KAMU KLIK GALLERY", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(getApplicationContext(), "KAMU KLIK SLIDESHOW", Toast.LENGTH_LONG).show();
            Snackbar.make(drawer, "KAMU KLIK SLIDESHOW", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_tools) {
            Intent intent = new Intent(MainActivity.this, MySetting.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
