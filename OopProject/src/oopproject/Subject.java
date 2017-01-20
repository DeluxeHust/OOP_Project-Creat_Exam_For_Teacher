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
public class Subject implements Serializable {
    private String subjectName;
    private int numChapter;
    private String subjectID;
    
    private ArrayList<Question> questionList;
    
    
    public Subject(String subjectName, int numChapter, ArrayList<Question> questionList) {
        this.subjectName = subjectName;
        this.numChapter = numChapter;
        this.questionList = questionList;
    }

    public Subject() {
        this.questionList = new ArrayList<Question>();
    }

//    public Subject(int numChapter, ArrayList<Question> questionList) {
//        this.numChapter = numChapter;
//        this.questionList = questionList;
//    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getNumChapter() {
        return numChapter;
    }

    public void setNumChapter(int numChapter) {
        this.numChapter = numChapter;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }
    
    
    
}
