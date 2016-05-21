package com.salvovidas.salvovidas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    Button gameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameButton = (Button) findViewById(R.id.game_button);
        gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startGame();
            }
        });

        startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               startApp();
            }
        });
    }

    private void startGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void startApp() {
        Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
        startActivity(intent);
    }

}
