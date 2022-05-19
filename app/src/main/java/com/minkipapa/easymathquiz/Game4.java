package com.minkipapa.easymathquiz;

import java.util.ArrayList;
import java.util.List;

public class Game4 {

    private List<AddQuestion4> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestions;
    private int score;
    private AddQuestion4 currentQuestion;

    public Game4() {
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestions = 0;
        score = 0;
        currentQuestion = new AddQuestion4(100);
        questions = new ArrayList<AddQuestion4>();
    }

    public void makeNewQuestion() {
        currentQuestion = new AddQuestion4(totalQuestions * 2 + 5);
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
        score = numberCorrect * 10 - numberIncorrect * 30;
        return isCorrect;
    }

    public List<AddQuestion4> getQuestions() {
        return questions;
    }

    public void setQuestions(List<AddQuestion4> questions) {
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

    public AddQuestion4 getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(AddQuestion4 currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

}