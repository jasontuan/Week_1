package com.example.anhtuan.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.anhtuan.myapplication.R;
import com.example.anhtuan.myapplication.model.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataViewHolder> {

    private OnItemClickListener onItemClickListener;
    private Context context;
    private List<Result> resultList;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecyclerViewAdapter(Context context, List<Result> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Result result = resultList.get(position);
        Glide.with(context).load("http://image.tmdb.org/t/p/w500" + result.getPosterPath()).into(holder.imgMovie);
        holder.tvTitle.setText(result.getTitle());
        holder.tvPopularity.setText(String.valueOf(result.getPopularity()));
        holder.cvMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultList != null ? resultList.size() : 0;
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cv_movie)
        CardView cvMovie;
        @BindView(R.id.img_movie)
        ImageView imgMovie;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_popularity)
        TextView tvPopularity;

        DataViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
