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
public abstract class Question implements Serializable{
    private String question;
    private String chapter;
    private String level;
    
    public Question() {
        
    }

    public Question(String question, String chapter, String level) {
        this.question = question;
        this.chapter = chapter;
        this.level = level;
    }

    
    public String getQuestion() {
        return question;
    }

    public String getChapter() {
        return chapter;
    }

    public String getLevel() {
        return level;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public abstract String showDetailQuestion();
    
    public abstract String printQuestion();
    
    
}

