package com.example.finalthesis;

public class Quiz {

    String name;

    int actualQuestion = 1;
    int numQuestion = 30;
    int correctAnswer;

    int Test;

void Calculate(){

    Test = this.correctAnswer/this.numQuestion;
}
    void incrementcorrectAnswer(){
        correctAnswer++;
        Calculate();
        System.out.println("Prawidłowa Odpowiedz");
    }
    void Setname(String name){
        this.name = name;
    }
}
