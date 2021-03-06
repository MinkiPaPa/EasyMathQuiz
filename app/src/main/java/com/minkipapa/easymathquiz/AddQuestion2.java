// 더하기 응용 퀴즈

package com.minkipapa.easymathquiz;

import java.util.Random;

public class AddQuestion2 {

    private int firstNumber;
    private int secondNumber;
    private int answer;

    // 4 possible choices for the user to pick
    private int [] answerArray;
    // which answer position is correct, 0,1,2 or 3
    private int answerPosition;
    // Maximum number value of first number or second number
    private  int upperLimit;
    // String output of the question. e.g " 5 + ? = 10 "
    private String questionPhrase;

    // Generate a new random question
    public AddQuestion2(int upperLimit) {
        this.upperLimit = upperLimit;
        Random randomNumberMaker = new Random();

        int max_num_value = 50;
        int min_num_value = 1;

        this.firstNumber = randomNumberMaker.nextInt(max_num_value - min_num_value + 1) + min_num_value;
        this.secondNumber = randomNumberMaker.nextInt(max_num_value - min_num_value + 1) + min_num_value;

        this.answer = this.secondNumber;
        this.questionPhrase = firstNumber + " + " + "?" + " = " + (firstNumber+secondNumber);

        this.answerPosition = randomNumberMaker.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};

        this.answerArray[0] = answer + 1;
        this.answerArray[1] = answer + 10;
        this.answerArray[2] = answer - 5;
        this.answerArray[3] = answer - 2;

        this.answerArray = suffleArray(this.answerArray);

        answerArray[answerPosition] = answer;

    }

    private int [] suffleArray(int[] array) {
        int index, temp;
        Random randomNumberGenerator = new Random();

        for (int i = array.length-1; i>0; i--) {
            index = randomNumberGenerator.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
