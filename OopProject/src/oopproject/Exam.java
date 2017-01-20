/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author linhphan
 */
public class Exam implements Serializable {
    
    private String subject;
    private String subjectID;
    private String semester;
    private String year;
    private String time;
    ArrayList<Question> questionList;

    public Exam(String subject, String subjectID, String semester, String year, String time, ArrayList<Question> questionList) {
        this.subject = subject;
        this.subjectID = subjectID;
        this.semester = semester;
        this.year = year;
        this.time = time;
        this.questionList = questionList;
    }

    public Exam() {
        
    }
    
    public String getSubject() {
        return subject;
    }

    public String getSemester() {
        return semester;
    }

    public String getYear() {
        return year;
    }

    public String getTime() {
        return time;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }
    

    
    public String printExam() {
        String preExam ="MÔN THI: " + this.getSubject() +"\r\nMã học phần: " + this.getSubjectID() + "\r\nHọc Kỳ: " +this.getSemester() + "\r\nNăm học: " + this.getYear() +"\r\nThời gian thi: " + this.getTime() + " phút" +"\r\n\nĐỀ RA:\r\n" ;
        for(int i=0; i< this.getQuestionList().size(); i++) {
            preExam += "\r\nCâu " + (i+1) +" : " + this.getQuestionList().get(i).printQuestion() + "\r\n";
        }
        preExam += "\r\n------------------Hết-------------------------\r\n";
        preExam += "Cán bộ coi thi không giải thích gì thêm!";
        
        return preExam;
    }
    
    
}
