package com.Type;

/**
 * Created by Administrator on 2017\11\27 0027.
 */

public class Book {

    private String BookName;
    private int ImgId;
    private  String Directory[];


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
    public void setDirectory(String directory[]){
        this.Directory = directory;
    }
    public String[] getDirectory(){
        return this.Directory;
    }

}
