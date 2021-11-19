package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView title,recipeText;
    String data1,data3;
    int Myimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recipeText=findViewById(R.id.recipeText);
        mainImageView=findViewById(R.id.imageView);
        title=findViewById(R.id.food_1);
        getData();
        setData();
    }
    private void getData(){
        if (getIntent().hasExtra("Myimage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data3")) {
            data1 = getIntent().getStringExtra("data1");
            data3 = getIntent().getStringExtra("data3");
            Myimage= getIntent().getIntExtra("Myimage",1);
        }
        else {
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }
    private  void setData(){
        title.setText(data1);
        recipeText.setText(data3);
        mainImageView.setImageResource(Myimage);}
}