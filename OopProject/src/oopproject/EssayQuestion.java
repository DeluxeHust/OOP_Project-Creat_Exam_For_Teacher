/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.io.Serializable;

/**
 *
 * @author linhphan
 */
public class EssayQuestion extends Question implements Serializable{
    
    public EssayQuestion() {
        super();
    }

    public EssayQuestion(String question, String chapter, String level) {
        super(question, chapter, level);
    }

    @Override
    public String showDetailQuestion() {
        String ques = this.printQuestion();
        ques += "\n---------------------\n";
        ques += "\nChương: " + this.getChapter();
        ques += "\nMức độ: " + this.getLevel();
        return ques;
        
    }

    @Override
    public String printQuestion() {
        String ques =this.getQuestion();
        return ques;
    }
    
}
