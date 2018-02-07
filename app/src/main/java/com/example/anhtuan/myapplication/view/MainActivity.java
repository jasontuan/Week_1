package com.example.anhtuan.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.anhtuan.myapplication.R;
import com.example.anhtuan.myapplication.adapter.OnItemClickListener;
import com.example.anhtuan.myapplication.adapter.RecyclerViewAdapter;
import com.example.anhtuan.myapplication.api.MovieApi;
import com.example.anhtuan.myapplication.contract.IView;
import com.example.anhtuan.myapplication.presenter.PresenterMovieImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.rcv_movie)
    RecyclerView rcvMovie;
    private RecyclerViewAdapter recyclerViewAdapter;
    private PresenterMovieImpl presenterMovieImpl;
    private int totalItemCount, lastVisibleItem, firstVisible;
    private GridLayoutManager gridLayoutManager;
    private int curPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MovieApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final MovieApi movieApi = retrofit.create(MovieApi.class);


        presenterMovieImpl = new PresenterMovieImpl(this);
        recyclerViewAdapter = new RecyclerViewAdapter(this, presenterMovieImpl.getResultList());
        gridLayoutManager = new GridLayoutManager(this, 3);
        rcvMovie.setLayoutManager(gridLayoutManager);
        rcvMovie.setAdapter(recyclerViewAdapter);

        presenterMovieImpl.getDataMovie(movieApi, curPage);

        recyclerViewAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Detail", presenterMovieImpl.getResultList().get(position));
                startActivity(intent);
            }
        });

        rcvMovie.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisible = gridLayoutManager.findFirstVisibleItemPosition();
                totalItemCount = gridLayoutManager.getItemCount();
                lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();
                if (firstVisible + lastVisibleItem >= totalItemCount) {
                    curPage++;
                    presenterMovieImpl.getDataMovie(movieApi, curPage);
                }
            }
        });
    }

    @Override
    public void showDataMovieSuccess() {
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showDataMovieFail() {
        Toast.makeText(this, "Show not Success", Toast.LENGTH_SHORT).show();
    }
}
