package com.android.udacityprojecttwocourtcounter;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView barcaScoreView;
    private TextView realScoreView;
    private int realScore = 0;
    private int barcaScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barcaScoreView = findViewById(R.id.barca_score_view);
        realScoreView = findViewById(R.id.real_score_view);
        Button barcaWin = findViewById(R.id.barce_win);
        Button barcaLose = findViewById(R.id.barca_lose);
        Button barcaDraw = findViewById(R.id.barca_draw);
        Button realWin = findViewById(R.id.real_win);
        Button realDraw = findViewById(R.id.real_draw);
        Button realLose = findViewById(R.id.real_lose);
        Button reset = findViewById(R.id.reset);

        barcaWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barcaScore += 3;
                barcaView(barcaScore);
            }
        });

        barcaDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barcaScore++;
                barcaView(barcaScore);
            }
        });

        barcaLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "oops, Barcelona has lost!", Toast.LENGTH_SHORT).show();
            }
        });

        realWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realScore += 3;
                realView(realScore);
            }
        });

        realDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realScore++;
                realView(realScore);
            }
        });

        realLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "oops, Real Madrid loose the game!", Toast.LENGTH_SHORT).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                realScore = 0;
                barcaScore = 0;
                realView(realScore);
                barcaView(barcaScore);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("real", realScore);
        outState.putInt("barca", barcaScore);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        realScore = savedInstanceState.getInt("real");
        realScoreView.setText(String.valueOf(realScore));
        barcaScore = savedInstanceState.getInt("barca");
        barcaScoreView.setText(String.valueOf(barcaScore));
    }

    private void barcaView(int score) {
        barcaScoreView.setText(String.valueOf(score));
    }

    private void realView(int score) {
        realScoreView.setText(String.valueOf(score));
    }
}

