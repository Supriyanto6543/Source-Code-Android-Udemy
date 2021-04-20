package com.app.latihanretrofit.configretrofit;

public class RetrofitBaseUrl {

    public static String BaseUrl = "http://192.168.43.210/ebook/";

    public static GetJson getJsonServices(){

        return RetrofitInstance.getInstance(BaseUrl).create(GetJson.class);
    }

}
