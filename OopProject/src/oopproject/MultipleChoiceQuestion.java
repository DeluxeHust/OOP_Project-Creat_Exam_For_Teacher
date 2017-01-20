/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author linhphan
 */
public class MultipleChoiceQuestion extends Question implements Serializable{

    private ArrayList<Answer> answerList; 
    private boolean disorder; // Xao tron duoc hay ko.

    public MultipleChoiceQuestion() {
        this.answerList = new ArrayList<Answer>();
    }
    public MultipleChoiceQuestion(String question, String chapter, String level) {
        super(question, chapter, level);
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswer(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }

    public boolean isDisorder() {
        return disorder;
    }

    public void setDisorder(boolean disorder) {
        this.disorder = disorder;
    }
    
   
    
    public void addAnswer(Answer answer) { 
        this.getAnswerList().add(answer);
    }
    
//    public void editAnswer(Question question) {
//        
//    }
    
    public Answer deleteAnswer( Answer answer) {
        this.answerList.remove(answer);
        return answer;
    }
    
    public String getTrueAnswer() {
        String trueAns ="";
        int count =0;
        for(int i=0; i< this.getAnswerList().size(); i++) {
            if(this.getAnswerList().get(i).isTrueAnswer()) {
                trueAns += "\n";
                trueAns += (char)(65+i) +". " + this.getAnswerList().get(i).getContent();
                count ++;
            }
        }
        return "\nCó " + count + " đáp án đúng: " + trueAns;
    }
    @Override
    public String showDetailQuestion() {
        String quesDetail = "Đề bài:\n" ;
        quesDetail += this.printQuestion();
        quesDetail += "\n-------------------------" ;
        quesDetail += "\r\nChương: " + this.getChapter();
        quesDetail += "\r\nMức Độ: " + this.getLevel();
        quesDetail += this.getTrueAnswer();
      return quesDetail;
    }

    @Override
    public String printQuestion() {
        int a= 65;
        String ques = this.getQuestion();
        ques += "\r";
        for(Answer answer : this.getAnswerList()) {
            ques += "\r\n" ;
            ques += (char) a;
            ques += ". " + answer.getContent();
            a++;
        }
    return ques;
    }
    
}
