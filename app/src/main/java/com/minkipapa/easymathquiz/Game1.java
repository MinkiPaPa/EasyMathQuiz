package com.minkipapa.easymathquiz;

import java.util.ArrayList;
import java.util.List;

public class Game1 {

    private List<AddQuestion1> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestions;
    private int score;
    private AddQuestion1 currentQuestion;

    public Game1() {
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new AddQuestion1(10);
        questions = new ArrayList<AddQuestion1>();
    }

    public void makeNewQuestion() {
        currentQuestion = new AddQuestion1(totalQuestions * 2 + 5);
        totalQuestions++;
        questions.add(currentQuestion);

    }

    public boolean checkAnswer(int submittedAnswer) {
        boolean isCorrect;
        if(currentQuestion.getAnswer() == submittedAnswer) {
            numberCorrect++;
            isCorrect=true;
        } else {
            numberIncorrect++;
            isCorrect=false;
        }
        score = numberCorrect * 10 - numberIncorrect * 20;
        return isCorrect;
    }

    public List<AddQuestion1> getQuestions() {
        return questions;
    }

    public void setQuestions(List<AddQuestion1> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public AddQuestion1 getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(AddQuestion1 currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

}
