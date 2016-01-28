package com.hackerkernel.workingwithinternalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = (TextView) findViewById(R.id.textView);
        Button load = (Button) findViewById(R.id.load);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }

    private void loadData() {
        FileInputStream fis = null;
        try {
            fis = openFileInput("husain.txt");
            int read;
            StringBuilder sb = new StringBuilder();
            while ((read = fis.read()) != -1){
                sb.append((char)read);
            }

            textView.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
