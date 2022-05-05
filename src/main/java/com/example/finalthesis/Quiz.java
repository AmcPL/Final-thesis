package com.example.finalthesis;

public class Quiz {

    String name;

    int actualQuestion = 1;
    int numQuestion = 10;
    int correctAnswer;

    void incrementactualQuestion(){

        actualQuestion++;

    }
    void Setname(String name){
        this.name = name;
    }
}
