package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //add recycler view object
    RecyclerView recyclerView;

    //intialize variable for string an images that will be displayed in recyclerview
    String s1[], s2[];
    //get the images from drawable
    int images[] = {R.drawable.f8tributo, R.drawable.fordgt, R.drawable.huracanevo, R.drawable.m600, R.drawable.sf90stradalle, R.drawable.svj, R.drawable.valhalla, R.drawable.vanquish};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        //save the value of string in the /res/values/strings.cml into the variable
        s1 = getResources().getStringArray(R.array.supercar_name);
        s2 = getResources().getStringArray(R.array.description);

        //call MyAdpater class and fill the constructor
        MyAdapter myAdapter = new MyAdapter(this, s1, s2  ,images); //this main this MainActivity class as the context
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //set how the row of the recycler view item will be displayed, here we eill choose linear layout


    }
}