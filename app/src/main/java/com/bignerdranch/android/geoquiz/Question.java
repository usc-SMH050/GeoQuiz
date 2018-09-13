package com.bignerdranch.android.geoquiz;

import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class Question {

    ArrayList<String> questionList = new ArrayList<>();
    static ArrayList<Boolean> answerList = new ArrayList<>();
    static public int currentQuestion = 0;

    public Question(){
        fillList();
    }

    private void fillList(){
        questionList.add(0, "Q1: Rome is the capital of Italy");
        answerList.add(0, true);

        questionList.add(1, "Q2: Iceland is covered in ice");
        answerList.add(1, false);

        questionList.add(2, "Q3: Russia covers 12 time zones.");
        answerList.add(2, false);

        questionList.add(3, "Q4: Canada has over 39 national parks.");
        answerList.add(3, true);

        questionList.add(4, "Q5: In 1952, Laos declared independence from France.");
        answerList.add(4, false);
    }

    public void setQuestion(Boolean nextQuestion){
        if (nextQuestion){
            if ((questionList.size() - 1) == currentQuestion){
                currentQuestion = 0;
            }
            else {
                currentQuestion++;
            }
        }
        else {
            if (0 == currentQuestion){
                currentQuestion = questionList.size() - 1;
            }
            else {
                currentQuestion--;
            }
        }
    }

    public static Boolean getAnswer(){
        return answerList.get(currentQuestion);
    }

    public String getQuestion(){
        return questionList.get(currentQuestion);
    }
}
