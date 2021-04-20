package com.app.latihanretrofit.configretrofit;

import com.app.latihanretrofit.jsonretrofit.EbookList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetJson {

    @GET("api.php?ebooks")
    Call<EbookList> getEbooks();
}
