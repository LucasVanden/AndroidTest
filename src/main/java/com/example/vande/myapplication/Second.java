package com.example.vande.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent = getIntent();
       String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_Pickachu);

        TextView t = findViewById(R.id.textView2);
        t.setText(message);

    }
}
