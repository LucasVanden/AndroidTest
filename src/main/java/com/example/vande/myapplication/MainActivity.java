package com.example.vande.myapplication;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public static final String EXTRA_MESSAGE_Pickachu = "com.example.myfirsy_intent";

    private RecyclerView mRecyclerView;
    ArrayList<Item> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("hola"));
        tabLayout.addTab(tabLayout.newTab().setText("hola2"));
        tabLayout.addTab(tabLayout.newTab().setText("hola"));
        tabLayout.addTab(tabLayout.newTab().setText("hola2"));
        tabLayout.addTab(tabLayout.newTab().setText("hola"));
        tabLayout.addTab(tabLayout.newTab().setText("hola2"));

        RecyclerView a = findViewById(R.id.recycle);
        contacts = Item.createContactsList(20,"left");
        AdaptyHolder adapter = new AdaptyHolder(contacts);
        a.setAdapter(adapter);
        a.setLayoutManager(new LinearLayoutManager(this));

tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        String m = (String) tab.getText();
        Toast.makeText(MainActivity.this, m, Toast.LENGTH_SHORT).show();
        TextView t = findViewById(R.id.textView3);
        t.setText(m);

        llenarLista(m);
    }
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }
    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});
    }
    public void metodo(View view){
        Intent intent = new Intent(this,Second.class);
        EditText editText = (EditText) findViewById(R.id.textView);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_Pickachu,message);
        startActivity(intent);
    }
    public void slatarOtraPantallaconTab(View view){
        Intent intent = new Intent(this,Second.class);
        TextView text = (TextView) findViewById(R.id.contact_name);

        String clave = (String) text.getText();
        intent.putExtra(EXTRA_MESSAGE_Pickachu,clave);
        startActivity(intent);
    }

 public void llenarLista(String selecto){
        RecyclerView a = findViewById(R.id.recycle);
        contacts = Item.createContactsList(20,selecto);
        AdaptyHolder adapter = new AdaptyHolder(contacts);
        a.setAdapter(adapter);
        a.setLayoutManager(new LinearLayoutManager(this));
 }

}
