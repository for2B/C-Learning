package com.test.file;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.Type.Book;
import com.Type.Bookdirectory;
import com.bignerdranch.android.outputsteamtest.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BookDirectory extends AppCompatActivity {
    private List<Bookdirectory> DirectoryList = new ArrayList<>();
        private String Bookname = "C++入门";
    private String AbsPath = "Book/";
        private static final String TAG = "BookDirectory";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//      Intent getintent = getIntent();
//      Bookname = getintent.getStringExtra("bookname");
    setContentView(R.layout.book_directory);
    getDirectory();
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_directory);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    BookDirectoryAdapter Bdadapter = new BookDirectoryAdapter(DirectoryList);
        recyclerView.setAdapter(Bdadapter);
}


    private void getDirectory(){
        BufferedReader reader = null;
        AssetManager Am = getAssets();
        try {
            InputStream in =  Am.open(AbsPath+Bookname+"/"+Bookname+"Directory");
            reader = new BufferedReader((new InputStreamReader(in)));
            String line = "";
            while ((line = reader.readLine()) != null) {
                Bookdirectory Bookdt = new Bookdirectory(Bookname,line);
                DirectoryList.add(Bookdt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
