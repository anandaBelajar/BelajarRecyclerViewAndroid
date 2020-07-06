package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    //define the widget taht we used in the activity_second.xml
    ImageView supercarImage;
    TextView supercarName, description;

    String data1, data2;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        supercarImage = findViewById(R.id.supercarImage);
        supercarName = findViewById(R.id.txtSupercarNameDetail);
        description = findViewById(R.id.txtDescriptionDetail);

        getData();
        setData();
    }

    private  void getData(){
        //function get data from the intent

        if(getIntent().hasExtra("images") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            images = getIntent().getIntExtra("images", 1);
        }else{
            Toast.makeText(this, "no data exist", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData(){
        //funxtion set data to the widget
        supercarName.setText(data1);
        description.setText(data2);
        supercarImage.setImageResource(images);
    }
}