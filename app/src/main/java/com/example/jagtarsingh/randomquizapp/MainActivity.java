package com.example.jagtarsingh.randomquizapp;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] questions;
    int[][] answers;
    int queue[]=new int[6];
    int numberofquestioncomplete = 0;
    int answerlog[] = new int[5];
    int anscnt = 0;
    int correct_ans_count;
    int correct_answer[] = new int[10];
    String user_name;

    //function for generating unique number
    private int[] random_number_generator(){
        int question_list[] = new int[6];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<6; i++) {
            question_list[i] = list.get(i);
        }

        //final question list is return
        return question_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Log.d("user_name", user_name);
        //question array is assigned with values
        questions= new String[] {"Identify the logo for R Programming",
                "Identify the logo for Acrobat",
                "Identity the logo for Coca Cola",
                "Identify the logo for Kotlin",
                "Identify the logo of Sun Microsystems",
                "Identify the logo of Windows",
                "Identify the logo of Perl",
                "Identify the logo of IBM",
                "Identify the logo of Cisco Systems",
                "Identify the logo of App Store of Windows"};

        //answer array is asigned with options to be given and last index is of correct answer
        answers= new int[][] {
                {R.drawable.rprogramming, R.drawable.javascript, R.drawable.nodejs, R.drawable.angularjs, R.drawable.rprogramming},
                {R.drawable.adobe, R.drawable.amazon, R.drawable.bing, R.drawable.acrobat, R.drawable.acrobat},
                {R.drawable.cocacola2, R.drawable.cocacola, R.drawable.cocacola1, R.drawable.twitter, R.drawable.cocacola},
                {R.drawable.kotlin, R.drawable.java, R.drawable.oracle, R.drawable.chrome, R.drawable.kotlin},
                {R.drawable.walmart,R.drawable.sun, R.drawable.shell, R.drawable.solaris, R.drawable.sun},
                {R.drawable.microsoft98, R.drawable.windows, R.drawable.microsoft, R.drawable.windows98, R.drawable.windows},
                {R.drawable.python, R.drawable.perl, R.drawable.micron, R.drawable.transcend, R.drawable.perl},
                {R.drawable.ibm2, R.drawable.ibm, R.drawable.seagate, R.drawable.logo, R.drawable.ibm},
                {R.drawable.cisco, R.drawable.skype, R.drawable.intel, R.drawable.swift, R.drawable.cisco},
                {R.drawable.black, R.drawable.appstore, R.drawable.windowsstore, R.drawable.googleapp, R.drawable.windowsstore}
        };
        correct_answer[0] = 0;
        correct_answer[1] = 3;
        correct_answer[2] = 1;
        correct_answer[3] = 0;
        correct_answer[4] = 1;
        correct_answer[5] = 1;
        correct_answer[6] = 1;
        correct_answer[7] = 1;
        correct_answer[8] = 0;
        correct_answer[9] = 2;

        queue = random_number_generator();
        displayquestion();
    }

    //function of displaying question and options in text view and image buttons

    public void displayquestion () {
        if(anscnt <=4) {
            TextView ques = (TextView) findViewById(R.id.lbl_question);
            ImageButton opt1 = (ImageButton) findViewById(R.id.option1);
            ImageButton opt2 = (ImageButton) findViewById(R.id.option2);
            ImageButton opt3 = (ImageButton) findViewById(R.id.option3);
            ImageButton opt4 = (ImageButton) findViewById(R.id.option4);

            ques.setText(questions[queue[numberofquestioncomplete]]);
            opt1.setImageResource(answers[queue[numberofquestioncomplete]][0]);
            opt2.setImageResource(answers[queue[numberofquestioncomplete]][1]);
            opt3.setImageResource(answers[queue[numberofquestioncomplete]][2]);
            opt4.setImageResource(answers[queue[numberofquestioncomplete]][3]);

            //counter for number of completed queation
            numberofquestioncomplete++;}
    }

    // on every selection of option this method is called
    public void onClickCard(View view) {
        anscnt++;
        if (anscnt >= 5) {
            //Toast.makeText(getApplicationContext(),"Quiz is completed. Thankyou", Toast.LENGTH_LONG).show();

            Intent i = getIntent();
            String user_name = i.getStringExtra("name");
            //here i just want to pass array to next activity
            Intent intd = new Intent(getApplicationContext(), DisplayResult.class);
            intd.putExtra("user_name",user_name);
            intd.putExtra("total", Integer.toString(correct_ans_count));
            startActivity(intd);
        }

        ImageButton opt1 = (ImageButton) findViewById(R.id.option1);
        ImageButton opt2 = (ImageButton) findViewById(R.id.option2);
        ImageButton opt3 = (ImageButton) findViewById(R.id.option3);
        ImageButton opt4 = (ImageButton) findViewById(R.id.option4);


        if (anscnt < 5) {
            if (opt1.isPressed() == true) {
                if((correct_answer[queue[numberofquestioncomplete-1]] == 0 )){ correct_ans_count++;}
                //ans
            }
            if (opt2.isPressed() == true) {
                if((correct_answer[queue[numberofquestioncomplete-1]] == 1)){ correct_ans_count++;}
                //anscnt++;

            }
            if (opt3.isPressed() == true) {
                if(correct_answer[queue[numberofquestioncomplete-1]] == 2){correct_ans_count++;}
                // anscnt++;
            }
            if (opt4.isPressed() == true) {
                if(correct_answer[queue[numberofquestioncomplete-1]] == 3){correct_ans_count++;}
                //anscnt++;
            }
        }
        if(anscnt < 5)
        {
            displayquestion();
        }

    }
}
