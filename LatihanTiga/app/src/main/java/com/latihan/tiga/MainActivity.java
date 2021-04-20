package com.latihan.tiga;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.latihan.tiga.adapter.AdapterPertama;
import com.latihan.tiga.modal.ModalPertama;
import com.latihan.tiga.networkingku.CheckNetwork;
import com.latihan.tiga.okrequest.OkRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    GridLayoutManager glm;
    AdapterPertama adapterPertama;
    ArrayList<ModalPertama> modalPertamas;

    RequestQueue requestQueue;
    String url = "https://al-quran-8d642.firebaseio.com/data.json?print=pretty";

    CheckNetwork checkNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = findViewById(R.id.recycler_view);
        glm = new GridLayoutManager(this, 2);
        recycler_view.setLayoutManager(glm);

        modalPertamas = new ArrayList<>();

        checkNetwork = new CheckNetwork(this);
        if (checkNetwork.checkInternet()){
            Toast.makeText(getApplicationContext(), "BERHASIL CONNECT", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "TIDAK CONNECT", Toast.LENGTH_LONG).show();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            modalPertamas.add(new ModalPertama("Komputer", getApplicationContext().getDrawable(R.drawable.aroma1)));
            modalPertamas.add(new ModalPertama("Laptop", getApplicationContext().getDrawable(R.drawable.aroma10)));
            modalPertamas.add(new ModalPertama("Jam Tangan", getApplicationContext().getDrawable(R.drawable.aroma9)));
            modalPertamas.add(new ModalPertama("Jam Dinding", getApplicationContext().getDrawable(R.drawable.aroma8)));
            modalPertamas.add(new ModalPertama("Handphone", getApplicationContext().getDrawable(R.drawable.aroma4)));
        }

        adapterPertama = new AdapterPertama(this, modalPertamas);
        recycler_view.setAdapter(adapterPertama);

       // new tampilkanLogApi().execute("https://al-quran-8d642.firebaseio.com/data.json?print=pretty");

        requestQueue = Volley.newRequestQueue(this);
        //requestJsonObj();

        requestJsonArray();

    }

    class tampilkanLogApi extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                JSONArray jsonObject = new JSONArray(OkRequest.getUrl(strings[0]));
                Log.d("myJosn", jsonObject + "");

                return "1";
            } catch (JSONException e) {
                e.printStackTrace();
                return "0";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    private void requestJsonObj(){
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("MYJSONOBJVOL", response + "");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(objectRequest);
    }

    private void requestJsonArray(){
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("MYJSONAARR", response + "");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("SALAH", error + "");
            }
        });
        requestQueue.add(request);
    }
}
