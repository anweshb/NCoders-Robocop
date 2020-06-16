package com.lakhu.rob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class About_a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_a);
    }
    public void home(View view) {

        Intent intent = new Intent(this, Home_h.class);

        startActivity(intent);
    }
    public void history(View view) {

        Intent intent = new Intent(this, History_h.class);

        startActivity(intent);
    }

    public void exit(View view) {

        Intent intent = new Intent(this, exit.class);

        startActivity(intent);
    }
}
