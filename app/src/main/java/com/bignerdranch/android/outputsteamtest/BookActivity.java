package com.bignerdranch.android.outputsteamtest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookActivity extends AppCompatActivity {

    private Book[] books = { new Book("C++程序设计辅导",R.drawable.book_c1),
                             new Book("21天学通C++",R.drawable.book_c2),
                             new Book("C++常用算法手册",R.drawable.book_c3),
                             new Book("C++程序设计",R.drawable.book_c4),
                             new Book("C++面向对象程序设计教程",R.drawable.book_c5),
                             new Book("C++语言学习利器",R.drawable.book_c6)};
private List<Book> mBookList = new ArrayList<>();

private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarbook);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.img_back);
        }

        iniBooks();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_book);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new BookAdapter(mBookList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
        }
        return true;
    }

    public void iniBooks(){
        for(int i=0;i<10;i++){
            Random random = new Random();
            int index = random.nextInt(books.length);
            mBookList.add(books[index]);
        }

    }

}
