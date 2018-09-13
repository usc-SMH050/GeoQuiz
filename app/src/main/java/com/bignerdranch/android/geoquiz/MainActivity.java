package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    Question question = new Question();

    public void checkIfCorrect(boolean userInput){
        if (userInput == Question.getAnswer()){
            Toast.makeText(MainActivity.this, "You are correct!", LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "You are incorrect", LENGTH_SHORT).show();
        }
        question.setQuestion(Boolean.TRUE);
        updateQuestionText();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            Question.currentQuestion = savedInstanceState.getInt("index", 0);
        }

        updateQuestionText();

        CheatActivity cheatActivity = new CheatActivity();
        if (CheatActivity.getUserCheated()){
            Toast.makeText(MainActivity.this, "Cheating is bad!", LENGTH_SHORT).show();
            cheatActivity.setUserCheated(false);
        }


        Button mTrueButton = findViewById(R.id.trueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                checkIfCorrect(true);
            }
        });

        Button mFalseButton = findViewById(R.id.falseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                checkIfCorrect(false);
            }
        });

        Button mNextQuestion = findViewById(R.id.nextQuestion);
        mNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                question.setQuestion(true);
                updateQuestionText();
            }
        });

        Button mCheatButton = findViewById(R.id.cheatButton);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                startActivity(intent);
            }
        });

        Button mPreviousQuestion = findViewById(R.id.previousQuestion);
        mPreviousQuestion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                question.setQuestion(false);
                updateQuestionText();
            }
        });



    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("index", Question.currentQuestion);
    }

    public void updateQuestionText(){
        TextView mTextView = findViewById(R.id.questionView);
        mTextView.setText(question.getQuestion());
    }
}
