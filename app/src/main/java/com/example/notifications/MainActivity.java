package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_start;
    Button btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_cancel);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btn_start){
            Intent intent = new Intent(this, PlayMusic_Service.class);
            startService(intent);
        }
        if(view == btn_stop){
            Intent intent = new Intent(this, PlayMusic_Service.class);
            intent.putExtra("stop", "stop");
            startService(intent);
        }
    }
}