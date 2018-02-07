package com.example.anhtuan.myapplication.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anhtuan.myapplication.R;
import com.example.anhtuan.myapplication.model.Result;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {

    Result result;

    @BindView(R.id.img_backdrop_detail)
    ImageView imgBackdrop;
    @BindView(R.id.img_movie_detail)
    ImageView imgMovie;
    @BindView(R.id.tv_title_detail)
    TextView tvTitle;
    @BindView(R.id.tv_ratings_detail)
    TextView tvRatings;
    @BindView(R.id.rb_grade)
    RatingBar rbGrade;
    @BindView(R.id.tv_store_detail)
    TextView tvStore;
    @BindView(R.id.btn_watch)
    Button btnWatch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        ButterKnife.bind(this);

        result = new Result();

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        result = (Result) bundle.getSerializable("Detail");

        Glide.with(this).load("http://image.tmdb.org/t/p/w500" + result.getBackdropPath()).into(imgBackdrop);
        Glide.with(this).load("http://image.tmdb.org/t/p/w500" + result.getPosterPath()).into(imgMovie);
        tvTitle.setText(result.getTitle());
        tvRatings.setText(String.valueOf(result.getVoteAverage()));
        tvStore.setText(result.getOverview());
        rbGrade.setRating(result.getVoteAverage() / 2);

    }
}
