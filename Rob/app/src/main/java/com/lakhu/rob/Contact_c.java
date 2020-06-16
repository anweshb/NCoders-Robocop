package com.lakhu.rob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact_c extends AppCompatActivity {
     Button pre,next;
     ImageView pic;
     TextView text;
     int currentimage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_c);
    }
    public void previous(View view) {
    String idx="pic"+ currentimage;
    int x=this.getResources().getIdentifier("idx","id",getPackageName());
    pic = findViewById(x);
    pic.setAlpha(0f);
    currentimage=(6+currentimage-1)%6;
    String idy="pic"+ currentimage;
    int y=this.getResources().getIdentifier("idy","id",getPackageName());
    pic = findViewById(y);
    pic.setAlpha(1f);

    }
    public void next(View view) {
        String idx="pic"+ currentimage;
        int x=this.getResources().getIdentifier("idx","id",getPackageName());
        pic = findViewById(x);
        pic.setAlpha(0f);
        currentimage=(6+currentimage+1)%6;
        String idy="pic"+ currentimage;
        int y=this.getResources().getIdentifier("idy","id",getPackageName());
        pic = findViewById(y);
        pic.setAlpha(1f);
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

        startActivity(intent);
    }
}
