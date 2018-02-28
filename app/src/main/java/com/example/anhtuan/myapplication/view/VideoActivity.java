package com.example.anhtuan.myapplication.view;

import android.os.Bundle;
import android.widget.Toast;

import com.example.anhtuan.myapplication.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    String API_KEY = "AIzaSyATk2mWy-AO5Zoj-FM7thFxovuOgDEfPVQ";
    private String id_key;

    @BindView(R.id.player)
    YouTubePlayerView ytb_player;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.player);
        ButterKnife.bind(this);

        bundle = getIntent().getExtras();
        assert bundle != null;
        id_key = bundle.getString("ID_VIDEO");
        Toast.makeText(this, id_key, Toast.LENGTH_SHORT).show();

        ytb_player.initialize(API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (null == youTubePlayer) return;
        if (!b) {
            youTubePlayer.cueVideo(id_key);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }
}
