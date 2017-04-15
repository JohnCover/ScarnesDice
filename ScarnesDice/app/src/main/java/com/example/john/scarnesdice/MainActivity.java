package com.example.john.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int _playerTurnScore;
    public int _playerScore;
    public int _computerTurnScore;
    public int _computerScore;

    Button rollButton = (Button)findViewById(R.id.roll);
    Button holdButton = (Button)findViewById(R.id.hold);
    Button resetButton = (Button)findViewById(R.id.reset);
    final ImageView dieImage = (ImageView)findViewById(R.id.dieView);
    TextView score = (TextView)findViewById(R.id.score);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rollTheDie();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            //When ResetButton is clicked, reset the 4 global variables to 0 and update the label text
            public void onClick(View v) {
                _playerScore = 0;
                _playerTurnScore = 0;
                _computerTurnScore = 0;
                _computerScore = 0;
            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //When HoldButton is clicked, updating the user's overall score, reset the user round score and update the label.
                _playerScore += _playerTurnScore;
                _playerTurnScore = 0;
                updateScoreText();
            }
        });
    }

    public void rollTheDie() {
        Random die = new Random();
        int roll = die.nextInt(6) + 1;
        switch (roll) {
            case 1:
                //dieImage.setImageResource(R.drawable.dice1);  //setImageResource does Bitmap reading and decoding on the UI thread, which can cause a latency hiccup.
                dieImage.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                _playerTurnScore = 0;
                updateScoreText();
                break;
            case 2:
                dieImage.setImageDrawable(getResources().getDrawable(R.drawable.dice2));
                _playerTurnScore += 2;
                updateScoreText();
                break;
            case 3:
                dieImage.setImageDrawable(getResources().getDrawable(R.drawable.dice3));
                _playerTurnScore += 3;
                updateScoreText();
                break;
            case 4:
                dieImage.setImageDrawable(getResources().getDrawable(R.drawable.dice4));
                _playerTurnScore += 4;
                updateScoreText();
                break;
            case 5:
                dieImage.setImageDrawable(getResources().getDrawable(R.drawable.dice5));
                _playerTurnScore += 5;
                updateScoreText();
                break;
            case 6:
                dieImage.setImageDrawable(getResources().getDrawable(R.drawable.dice6));
                _playerTurnScore += 6;
                updateScoreText();
                break;
        }
    }

    public void updateScoreText() {
        score.setText("Your score: "+_playerScore+" computer score: "+_computerScore+" your turn score: " + _playerTurnScore);
    }

    public void computerTurn() {

    }
}
