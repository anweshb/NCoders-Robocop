package com.lakhu.rob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home_h extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_h);
    }

    public void live(View view) {

        Intent intent = new Intent(this, Live_l.class);

        startActivity(intent);
    }

    public void ondoor(View view) {

        Intent intent = new Intent(this, Ondoor_o.class);

        startActivity(intent);
    }

    public void contacts(View view) {

        Intent intent = new Intent(this, Contact_c.class);

        startActivity(intent);
    }


    public void home(View view) {

        Intent intent = new Intent(this, Home_h.class);

        startActivity(intent);
    }
    public void history(View view) {

        Intent intent = new Intent(this, History_h.class);

        startActivity(intent);
    }
    public void help(View view) {

        Intent intent = new Intent(this, About_a.class);

        startActivity(intent);
    }
    public void exit(View view) {

        Intent intent = new Intent(this, exit.class);

        finish();
        super.onBackPressed();
    }
}
