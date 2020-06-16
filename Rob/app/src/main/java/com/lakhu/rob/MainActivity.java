package com.lakhu.rob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view) {

        Intent intent = new Intent(this, Log_in.class);

        startActivity(intent);
    }
    public void singin(View view) {

        Intent intent = new Intent(this, Sign_in.class);

        startActivity(intent);
    }
}
