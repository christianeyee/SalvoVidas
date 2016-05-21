package com.salvovidas.salvovidas;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setUpVideo();
    }

    private void setUpVideo() {
        VideoView vv = (VideoView)this.findViewById(R.id.video);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.vid;
        vv.setVideoURI(Uri.parse(uri));
        vv.start();
    }
}
