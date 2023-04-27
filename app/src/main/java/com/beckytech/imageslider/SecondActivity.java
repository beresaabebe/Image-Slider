package com.beckytech.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        SliderModel model = (SliderModel) intent.getSerializableExtra("data");
        ImageView imageView = findViewById(R.id.imageSecond);
        imageView.setImageResource(model.getImage());
        TextView textView = findViewById(R.id.textSecond);
        textView.setText(model.getTextTitle());
    }
}