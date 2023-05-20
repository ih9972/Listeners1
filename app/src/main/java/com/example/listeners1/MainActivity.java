package com.example.listeners1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        View.OnLongClickListener {
    Button redbtn, bluebtn, movebtn;
    int bluescore = 0,redscore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redbtn = (Button) findViewById(R.id.button);
        bluebtn = (Button) findViewById(R.id.button3);
        movebtn = (Button) findViewById(R.id.button2);
        bluebtn.setOnClickListener(this);
        movebtn.setOnClickListener(this);
        redbtn.setOnLongClickListener(this);
    }

    public void starts() {
        bluescore = redscore = 0;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            bluescore++;
        } else {
            go();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        redscore += 2;
        return false;
    }

    public void go() {
        Intent si = new Intent(this, score.class);
        si.putExtra("bluescore", bluescore);
        si.putExtra("redscore", redscore);
        startActivity(si);
    }

    protected void onResume() {
        super.onResume();
        starts();
    }
}