package com.test.file;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.android.outputsteamtest.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BookDetail extends AppCompatActivity {

    private TextView BookText;
    private TextView FileText;

    private String AbsPath = "Book/";
    private String bookname;
    private String chaptername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail);
        Intent getintent = getIntent();
        bookname = getintent.getStringExtra("bookname");
        chaptername = getintent.getStringExtra("directoryname");
        BookText = (TextView) findViewById(R.id.BookInformation);
        FileText = (TextView) findViewById(R.id.filecontent);
        BookText.setText(chaptername);
        FileText.setText(load().replace("\\n","\n"));
    }

//    View.OnClickListener onclick = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.savebutton:
//                    save("HuiL");
//                    Toast.makeText(BookDetail.this,"SAVE",Toast.LENGTH_SHORT).show();
//                    break;
//                case R.id.loadbutton:
//                   FileText.setText(load().replace("\\n","\n"));
////                 FileText.setMovementMethod(ScrollingMovementMethod.getInstance());
//                    break;
//            }
//        }
//    };

//    public void save(String inputText) {
//        FileOutputStream out = null;
//        BufferedWriter writer = null;
//        try {
//            out = openFileOutput("data2B", Context.MODE_PRIVATE);
//            writer = new BufferedWriter(new OutputStreamWriter(out));
//            writer.write(inputText);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (writer != null) {
//                    writer.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public String load() {
        BufferedReader reader = null;
        AssetManager Am = getAssets();
        StringBuilder content = new StringBuilder();
        try {
            InputStream in = Am.open(AbsPath+bookname+"/"+chaptername);
            BufferedReader reader1 = new BufferedReader((new InputStreamReader(in)));
            String line = "";
            while ((line = reader1.readLine()) != null) {
                content.append(line+"\n");
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
        return content.toString();
    }
}
