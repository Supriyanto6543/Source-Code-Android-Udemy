package com.latihan.tiga.networkingku;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CheckConnectToWww {

    public static String connectWww(String wwwUrl)
    {

        OkHttpClient client = new OkHttpClient.Builder().build();

        Request request = new Request.Builder().url(wwwUrl).build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }
}
