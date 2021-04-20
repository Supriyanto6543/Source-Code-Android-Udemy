package com.app.latihanretrofit.jsonretrofit;

import com.google.gson.annotations.SerializedName;

public class Ebook {

    @SerializedName("image")
    String image;

    @SerializedName("title")
    String title;

    @SerializedName("ebook_description")
    String ebook_description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEbook_description() {
        return ebook_description;
    }

    public void setEbook_description(String ebook_description) {
        this.ebook_description = ebook_description;
    }
}
