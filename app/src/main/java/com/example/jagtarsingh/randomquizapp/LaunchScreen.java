package com.example.jagtarsingh.randomquizapp;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);
    }
    public void onStartClicked(View view) {
        final EditText name = (EditText) findViewById(R.id.txtname);
        if(name.length() == 0)
        {
            Toast.makeText(getApplicationContext(),"Please enter youe name!!",Toast.LENGTH_LONG).show();
        } else {
            Intent intd = new Intent(getApplicationContext(), MainActivity.class);
            intd.putExtra("name", name.getText().toString());
            startActivity(intd);
        }
    }

}
