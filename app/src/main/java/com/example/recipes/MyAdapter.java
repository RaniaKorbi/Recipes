package com.example.recipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener{
    String data1[],data2[],data3[];
    int images[];
    Context context;
    private MyViewHolder holder;
    private int position;

    public MyAdapter(String[] data1, String[] data2,String[] data3, int[] images, Context context) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3= data3;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);

        View view=inflater.inflate(R.layout.wordlist_item,parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.food_1.setText(data1[position]);
        holder.description_1.setText(data2[position]);
        holder.recipeT.setText(data3[position]);
        holder.Myimage.setImageResource((images[position]));
    }


    @Override
    public int getItemCount() {
        return data1.length;
    }

    @Override
    public void onClick(View view) {
        Intent intent =new Intent(context, SecondActivity.class);
        intent.putExtra("data1", data1[position]);
        intent.putExtra("data3", data3[position]);
        intent.putExtra("Myimage", images[position]);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView Myimage;
        TextView food_1, description_1,recipeT;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            food_1=itemView.findViewById(R.id.food_1);
            description_1=itemView.findViewById(R.id.description_1);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }

}
