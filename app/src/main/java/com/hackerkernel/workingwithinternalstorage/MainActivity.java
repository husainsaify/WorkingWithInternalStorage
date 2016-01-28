package com.hackerkernel.workingwithinternalstorage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        Button save = (Button) findViewById(R.id.save);
        Button gotob = (Button) findViewById(R.id.gotob);

        //Save button is clicked
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        //Go to B
        gotob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    public void saveData(){
        String text = editText.getText().toString();
        byte[] bytes = text.getBytes();

        File file;

        FileOutputStream fos = null;
        try {
            fos = openFileOutput("husain.txt", Context.MODE_PRIVATE);
            fos.write(bytes);

            //File directory
            file = getFilesDir();
            Toast.makeText(getApplicationContext(),"File save "+file,Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //close FileOutputstream
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
