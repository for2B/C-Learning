package com.bignerdranch.android.outputsteamtest;

/**
 * Created by Administrator on 2017\11\27 0027.
 */

public class Book {

    private String BookName;

    private int ImgId;

    public Book(String BN,int ID){
        this.BookName = BN;
        ImgId = ID;
    }

    public String getBookName() {
        return BookName;
    }

    public int getImgId() {
        return ImgId;
    }
}
