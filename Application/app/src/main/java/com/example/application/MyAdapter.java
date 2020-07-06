package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    //data holder
    String data1[], data2[];
    int images[];
    Context context;

    //constructor
    public MyAdapter(Context ct, String s1[], String s2[]  ,int img[]){
            context = ct;
            data1 = s1;
            data2 = s2;
            images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.txtSupercarName.setText(data1[position]);
        holder.txtDescription.setText(data2[position]);
        holder.imgSupercar.setImageResource(images[position]);

        //on click listener (action when item in recycler view clicked go to new activity)
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //make itent
                //intent also called as a destination, so we can say that we use intent to reach new activity as our destination
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("data1", data1[position]);
                intent.putExtra("data2", data2[position]);
                intent.putExtra("images", images[position]);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        //return images.length;//data length that will be recycled in recyclerb view
        //in this project we can choose between imgaes, supercarname, or description to count
        //but  this time we will choose iamges
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtSupercarName, txtDescription;
        ImageView imgSupercar;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            txtSupercarName = itemView.findViewById(R.id.txtSupercarName);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgSupercar = itemView.findViewById(R.id.imgSupercar);
            mainLayout  = itemView.findViewById(R.id.mainLayout);
        }
    }
}
