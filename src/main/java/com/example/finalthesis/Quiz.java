package com.example.finalthesis;

public class Quiz {

    String name;

    int actualQuestion = 1;
    int numQuestion = 29;
    int correctAnswer;

    void incrementcorrectAnswer(){
        correctAnswer++;

    }
    void Setname(String name){
        this.name = name;
    }
}
