package com.example.anhtuan.myapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.anhtuan.myapplication.R;
import com.example.anhtuan.myapplication.api.MovieApi;
import com.example.anhtuan.myapplication.contract.IView;
import com.example.anhtuan.myapplication.model.Result;
import com.example.anhtuan.myapplication.presenter.PresenterVideoImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DetailActivity extends AppCompatActivity implements IView {

    Result result;
    PresenterVideoImpl presenterVideoImpl;

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
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create(MovieApi.class);
        presenterVideoImpl = new PresenterVideoImpl(this);
        presenterVideoImpl.getDataVideo(movieApi, result.getId());


        btnWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenterVideoImpl.getVideoList().size() > 0) {
                    Intent intent = new Intent(DetailActivity.this, VideoActivity.class);
                    intent.putExtra("ID_VIDEO", presenterVideoImpl.getVideoList().get(0).getKey());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void showDataMovieSuccess() {
    }

    @Override
    public void showDataMovieFail() {
    }

}
