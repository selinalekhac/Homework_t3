package com.example.homeworkt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CatDetails extends AppCompatActivity {

    public TextView breed;
    public TextView description;
    public TextView weight;
    public TextView temperament;
    public TextView origin;
    public TextView lifespan;
    public TextView wikipedia;
    public TextView dogfriendlinesslevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_details);
// not working
//        Intent intent = getIntent();
//        String breed1  = intent.getStringExtra("breed","desciption", 0);
//
//        breed = findViewById(R.id.CatBreed_id1);
//        description = findViewById(R.id.CatDescription_id1);
//        weight = findViewById(R.id.CatWeight_id1);
//        temperament = findViewById(R.id.CatTemp_id1);
//        origin = findViewById(R.id.CatOrigin_id1);
//        lifespan = findViewById(R.id.CatLifeSpan_id1);
//        wikipedia = findViewById(R.id.CatWiki_id1);
//        dogfriendlinesslevel = findViewById(R.id.CatDogFriendliness_id1);
//
//        breed.setText(Cats.getBreed());
//        description.setText(Cats.getDescription());
//        weight.setText(Cats.setWeight());
//        temperament.setText(Cats.getTemperament());
//        origin.setText(Cats.getOrigin());
//        lifespan.setText(Cats.getLifespan());
//        wikipedia.setText(Cats.getWikipedia());
//        dogfriendlinesslevel.setText(Cats.getDogfriendlinesslevel());
    }
}
