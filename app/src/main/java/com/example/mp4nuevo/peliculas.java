package com.example.mp4nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class peliculas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas);
        VideoView videoView=findViewById(R.id.videoView);

        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

//        val uri1 = Uri.parse("");
//        videoView.setMediaController(MediaController(this))
//        videoView.setVideoURI(uri1)
//        videoView.requestFocus()
//        videoView.start()

        String pelis = getIntent().getStringExtra("pelicula").toString();

        // var link:String=getString(this.getResources().getIdentifier(pelis, "string", this.getPackageName()))
        //Creating MediaController
        videoView.setVideoPath(pelis);
        videoView.start();
        android.widget.MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
    }

}