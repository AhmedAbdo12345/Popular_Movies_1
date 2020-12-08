package com.example.popularmoviesstage1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    TextView title;
    ImageView Image;
    TextView ReleaseDate;
    TextView voteCount;
    TextView Movieoverview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        title=findViewById(R.id.title);
        Image=findViewById(R.id.Image);
        ReleaseDate=findViewById(R.id.releaseData);
        voteCount=findViewById(R.id.vote_count);
        Movieoverview=findViewById(R.id.overview);


        Intent intent=getIntent();
        if(intent.getExtras()!=null) {

            String poster_path = intent.getStringExtra("poster_path");
            String original_title = intent.getStringExtra("original_title");
            String vote_count = intent.getStringExtra("vote_count");
            String release_date = intent.getStringExtra("release_date");
            String overview = intent.getStringExtra("overview");

            Picasso.get().load("http://image.tmdb.org/t/p/w185//" + poster_path).into(Image);
            title.setText(original_title);
            ReleaseDate.setText(release_date);
            voteCount.setText(vote_count+"/10");
            Movieoverview.setText(overview);



        }
    }
}