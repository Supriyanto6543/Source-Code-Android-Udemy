package com.app.latihanretrofit.jsonretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EbookList {

    @SerializedName("ebooku")
    List<Ebook> ebooku;

    public List<Ebook> getEbooku() {
        return ebooku;
    }

    public void setEbooku(List<Ebook> ebooku) {
        this.ebooku = ebooku;
    }
}
