package com.beckytech.imageslider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ImageSlider.onImageClickListener {

    SliderView sliderView;
    List<SliderModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = findViewById(R.id.imageSlider);

        int[] images = {
                R.drawable.im2,
                R.drawable.im3,
                R.drawable.im4,
                R.drawable.im5,
                R.drawable.im6,
                R.drawable.im3,
                R.drawable.im4,
                R.drawable.im2,
                R.drawable.im6
        };

        String[] text = {
                "Information Technology Grade 8",
                "Herrega Kutaa 8ffaa",
                "Saayinsii Waliigalaa Kutaa 8ffaa",
                "Hawaasa Kutaa 8ffaa",
                "Kitaaba Gadaa Kutaa 8ffaa",
                "Barnoota Lammummaa Kutaa 8ffaa",
                "Og-artiiwwan Kutaa 8ffaa",
                "English Grade 8th",
                "Math Grade 8 Amharic"
        };

        String[] url = {
                "https://play.google.com/store/apps/details?id=com.beckytech.informationtechnologygrade8",
                "https://play.google.com/store/apps/details?id=com.beckytech.Kitaabaherregakutaa8ffaa",
                "https://play.google.com/store/apps/details?id=com.beckytech.saayinsiiwaliigalaakutaa8ffaa",
                "https://play.google.com/store/apps/details?id=com.beckytech.barnootahawaasaakutaa8ffaa",
                "https://play.google.com/store/apps/details?id=com.beckytech.kitaabagadaakutaa8ffaa",
                "https://play.google.com/store/apps/details?id=com.beckytech.lammummaakutaa8ffaa",
                "https://play.google.com/store/apps/details?id=com.beckytech.og_artiiwwankutaa8ffaa",
                "https://play.google.com/store/apps/details?id=com.beckytech.englishgrade8thtextbook",
                "https://play.google.com/store/apps/details?id=com.beckytech.mathsgrade8amharic"
        };

        for (int i = 0; i < images.length; i++) {
            modelList.add(new SliderModel(images[i], text[i], url[i]));
        }

        ImageSlider imageSlider = new ImageSlider(MainActivity.this, modelList, this);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINDEPTHTRANSFORMATION);
        sliderView.setSliderAdapter(imageSlider);
        sliderView.setAutoCycle(true);
        sliderView.setSelected(true);
    }

    @Override
    public void imageClick(SliderModel model) {
//        startActivity(new Intent(MainActivity.this, SecondActivity.class).putExtra("data", model));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(model.getUrl()));
        startActivity(intent);
    }
}