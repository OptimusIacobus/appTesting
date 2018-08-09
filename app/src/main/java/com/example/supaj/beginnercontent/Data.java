package com.example.supaj.beginnercontent;

import java.io.Serializable;

public class Data implements Serializable{
    public String title;
    public String description;
    public int imageId;
    public String detail;


    Data(String title, String detail, int imageId, String description) {
        this.title = title;
        this.description = description;
        this.imageId = imageId;
        this.detail = detail;

    }


}