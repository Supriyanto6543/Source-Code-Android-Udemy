package com.latihan.tiga;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.latihan.tiga.networkingku.CheckConnectToWww;
import com.latihan.tiga.networkingku.CheckNetwork;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BelajarAsync extends AppCompatActivity {

    String url = "http://api.banghasan.com/quran/format/json/surat";
    CheckNetwork status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = new CheckNetwork(this);

        new tampilkanSemua().execute(url);
    }

    class tampilkanSemua extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            try {

                if (status.checkInternet()){

                    JSONObject jsonObject = new JSONObject(CheckConnectToWww.connectWww(strings[0]));
                    JSONArray array = jsonObject.getJSONArray("hasil");

                    for (int i = 0; i < array.length(); i++){

                        JSONObject object = array.getJSONObject(i);
                        String nama = object.getString("nama");
                        String arti = object.getString("arti");
                        String asma = object.getString("asma");

                        Log.d("hasilTampil", "Nama: " + nama + " "+ "ARti: " + arti + " " + "Asma: " + asma);


                    }

                    return "1";

                }else {
                    Toast.makeText(getApplicationContext(), "PERIKSA JARINGAN ANDA", Toast.LENGTH_LONG).show();
                }

                return "";

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
}
