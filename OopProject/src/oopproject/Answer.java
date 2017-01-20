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
public class Answer implements  Serializable{
    private boolean trueAnswer;
    private String content;

    public Answer(boolean trueAnswer, String content) {
        this.trueAnswer = trueAnswer;
        this.content = content;
    }

    public Answer() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
