/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author linhphan
 */
public class ListSubject implements Serializable {
    private ArrayList<Subject> listSubject;
    
    
    public ListSubject(ArrayList<Subject> listSubject) {
        this.listSubject = listSubject;
    }
    
    public ListSubject() {
        this.listSubject = new ArrayList<Subject>();
    }

    public ArrayList<Subject> getListSubject() {
        return listSubject;
    }

    public void setListSubject(ArrayList<Subject> listSubject) {
        this.listSubject = listSubject;
    }
    
    // đọc danh sách môn học từ file
    public ArrayList<Subject> readListSubject() throws FileNotFoundException {
        ArrayList<Subject> listSubj = new ArrayList<Subject>();
        try {
            FileInputStream file = new FileInputStream("data/listSubject");
            ObjectInputStream read_object = new ObjectInputStream(file);
            Subject subject = new Subject();
            while ((subject = (Subject) read_object.readObject()) != null) {
                listSubj.add(subject);
            }
            read_object.close();
            file.close();
            } catch (FileNotFoundException e) {

                FileOutputStream file = new FileOutputStream("data/listSubject");
                JOptionPane.showMessageDialog(null, "Chưa có dữ liệu!");
            } 
            catch (IOException i) {
            } catch (ClassNotFoundException notfound) {
                JOptionPane.showMessageDialog(null, "Class Not Found");
        }
        return listSubj;
    }
    
    // Lưu danh sách môn học ra file
    public void writeListSubject() {
        try {
            FileOutputStream file = new FileOutputStream("data/listSubject");
            ObjectOutputStream write_object = new ObjectOutputStream(file);
            int i = 0;
            int size = this.getListSubject().size();
            while (i < size) {
                Subject subj = this.getListSubject().get(i);
                write_object.writeObject(subj);
                i++;
            }
            write_object.close();
            file.close();
            JOptionPane.showMessageDialog(null, "Lưu thành công!");
        } catch (IOException o) {
            JOptionPane.showMessageDialog(null, "Error: " + o.getMessage());
        }
    }
    
}
