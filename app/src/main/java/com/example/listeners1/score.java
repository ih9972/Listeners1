package com.example.listeners1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score extends AppCompatActivity implements View.OnClickListener {
    TextView bluescore,redscore,winner;
    Button returnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        def();
    }

    public void def(){
        bluescore = (TextView)findViewById(R.id.textView);
        redscore = (TextView)findViewById(R.id.textView2);
        winner = (TextView)findViewById(R.id.textView3);
        returnButton = (Button) findViewById(R.id.button7);
        returnButton.setOnClickListener(this);
        Intent gi = getIntent();
        int redScore = gi.getIntExtra("redscore",0);
        int blueScore = gi.getIntExtra("bluescore",0);
        bluescore.setText("Blue Score is: " + blueScore);
        redscore.setText("Red Score is: " + redScore);
        if(redScore > blueScore)
            winner.setText("The winner is: red!" );
        else if(redScore < blueScore)
            winner.setText("The winner is: blue!" );
        else
            winner.setText("Its a tie!!");
    }



    @Override
    public void onClick(View v) {
        finish();
    }
}
