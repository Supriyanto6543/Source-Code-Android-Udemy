package com.app.latihanretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.app.latihanretrofit.configretrofit.GetJson;
import com.app.latihanretrofit.configretrofit.RetrofitBaseUrl;
import com.app.latihanretrofit.jsonretrofit.Ebook;
import com.app.latihanretrofit.jsonretrofit.EbookList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Ebook> ebooks;
    GetJson getJson;
    String title, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ebooks = new ArrayList<>();
        getJson = RetrofitBaseUrl.getJsonServices();

        getJson.getEbooks().enqueue(new Callback<EbookList>() {
            @Override
            public void onResponse(Call<EbookList> call, Response<EbookList> response) {

                Log.d("Berhasil", response + "");

                ebooks = response.body().getEbooku();
                Log.d("ResponJson", ebooks + "");

                title = ebooks.get(1).getTitle();
                image = ebooks.get(1).getImage();
                Log.d("title", title + " " + image);

            }

            @Override
            public void onFailure(Call<EbookList> call, Throwable t) {

                Log.d("Gagal", t + "");

            }
        });

    }
}
