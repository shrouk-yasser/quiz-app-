package com.example.jagtarsingh.randomquizapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class DisplayResult extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finallayout);

        TextView your_name = (TextView) findViewById(R.id.lastd);
        TextView your_score = (TextView) findViewById(R.id.score);



        Intent mint = getIntent();

        String value =  mint.getStringExtra("total");
        String s = mint.getStringExtra("user_name");


        your_name.setText(s);
        your_score.setText("Your Total Score is " + value);
        //Log.d("last",s);

    }
}
