package com.bignerdranch.android.geoquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class CheatActivity extends AppCompatActivity {

    static Boolean userCheated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Button mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                setUserCheated(true);
                TextView mTextView = (TextView) findViewById(R.id.showAnswerTextView);
                mTextView.setText(answerText());
            }
        });

        Button mBackButton = (Button) findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CheatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private String answerText(){
        if(Question.getAnswer()){
            return "True";
        }
        else {
            return "False";
        }
    }

    public void setUserCheated(Boolean didUserCheat){
        userCheated = didUserCheat;
    }

    public static Boolean getUserCheated() {
        return userCheated;
    }
}
