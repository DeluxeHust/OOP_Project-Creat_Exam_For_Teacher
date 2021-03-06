/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import oopproject.ListSubject;
import oopproject.Subject;

/**
 *
 * @author linhphan
 */
public class SubjectManager extends javax.swing.JFrame {

    /**
     * Creates new form SubjectManager
     */
    
    private DefaultListModel modelListSubject;
    private ListSubject listSubj;

    private Subject selectedSubject; // mon dang chon
    private int selectedIndex; // chi so duoc chon tren ds mon hoc
    
    private boolean clickAddSubject; // true khi dang chon chuc nang them mon hoc
    private boolean clickEditSubject; // true khi dang chon sua mon hoc
    private boolean notSave; // Kiểm tra trước khi thoát xem đã lưu các thay đổi chưa.
    
    
    public SubjectManager() throws FileNotFoundException {
        initComponents();
        this.setLocation(215,45);
        modelListSubject = new DefaultListModel();
        // đọc danh sách môn học từ file
        listSubj = new ListSubject();
        listSubj.setListSubject(listSubj.readListSubject()); 
        this.initListSubject(listSubj.getListSubject());

        
        this.setResizable(false);
        this.clickAddSubject = false;
        this.clickEditSubject = false;
        this.notSave = false;
        
        if(listSubj.getListSubject().size() >0) {
            
            selectedIndex = 0;
            selectedSubject = listSubj.getListSubject().get(selectedIndex); // lay subject tu arraylist
            JTextSubjectName.setText(selectedSubject.getSubjectName());
            JTextSubjectID.setText(selectedSubject.getSubjectID());
            JNumChapter.setValue(selectedSubject.getNumChapter());
            
        }
        
    }


    
    public void initListSubject(ArrayList<Subject> listSubject) {
        for(int i=0; i< listSubject.size(); i++ ) {
            this.modelListSubject.add(i, listSubject.get(i).getSubjectName() );
            
        }
        this.JListSubject.setModel(modelListSubject);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbQuanLiMonHoc = new javax.swing.JLabel();
        jlbDSMonHoc = new javax.swing.JLabel();
        jlbTenMH = new javax.swing.JLabel();
        jlbMahocphan = new javax.swing.JLabel();
        jlbSoChuong = new javax.swing.JLabel();
        JTextSubjectName = new javax.swing.JTextField();
        JTextSubjectID = new javax.swing.JTextField();
        JbtnAdd = new javax.swing.JButton();
        JbtnEdit = new javax.swing.JButton();
        JbtnDelete = new javax.swing.JButton();
        JbtnSave = new javax.swing.JButton();
        JbtnCancel = new javax.swing.JButton();
        JNumChapter = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListSubject = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlbQuanLiMonHoc.setBackground(new java.awt.Color(254, 50, 146));
        jlbQuanLiMonHoc.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbQuanLiMonHoc.setForeground(new java.awt.Color(74, 74, 74));
        jlbQuanLiMonHoc.setText("Quản Lí  Môn Học");

        jlbDSMonHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbDSMonHoc.setText("Danh Sách Môn Học");

        jlbTenMH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTenMH.setText("Tên Môn Học");

        jlbMahocphan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbMahocphan.setText("Mã Học Phần");

        jlbSoChuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbSoChuong.setText("Số Chương");

        JTextSubjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextSubjectNameActionPerformed(evt);
            }
        });

        JbtnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbtnAdd.setText("Thêm");
        JbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAddActionPerformed(evt);
            }
        });

        JbtnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbtnEdit.setText("Sửa");
        JbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEditActionPerformed(evt);
            }
        });

        JbtnDelete.setBackground(new java.awt.Color(255, 0, 51));
        JbtnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbtnDelete.setText("Xóa");
        JbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnDeleteActionPerformed(evt);
            }
        });

        JbtnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbtnSave.setText("Lưu");
        JbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnSaveActionPerformed(evt);
            }
        });

        JbtnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JbtnCancel.setText("OK");
        JbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnCancelActionPerformed(evt);
            }
        });

        JListSubject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JListSubject.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                JListSubjectPropertyChange(evt);
            }
        });
        JListSubject.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                JListSubjectValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(JListSubject);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbtnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JbtnEdit)
                        .addGap(45, 45, 45)
                        .addComponent(JbtnDelete))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbDSMonHoc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbMahocphan)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbTenMH)
                            .addComponent(jlbSoChuong))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTextSubjectName, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(JTextSubjectID))
                            .addComponent(JNumChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(JbtnSave)
                .addGap(36, 36, 36)
                .addComponent(JbtnCancel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbQuanLiMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jlbDSMonHoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbQuanLiMonHoc)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JTextSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbTenMH))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTextSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbMahocphan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JNumChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbSoChuong))
                        .addGap(51, 51, 51)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JListSubjectPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_JListSubjectPropertyChange

    }//GEN-LAST:event_JListSubjectPropertyChange

    private void JListSubjectValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_JListSubjectValueChanged
        
        clickAddSubject = false;
        clickEditSubject = false;
        if(evt.getValueIsAdjusting()) {
            selectedIndex = this.JListSubject.getSelectedIndex();
            System.out.println("selected index: "+selectedIndex);
            selectedSubject = listSubj.getListSubject().get(selectedIndex);
            System.out.println("selected Subject: " + selectedSubject.getSubjectName());
            
            this.JTextSubjectName.setText(selectedSubject.getSubjectName());
            this.JTextSubjectID.setText(selectedSubject.getSubjectID());
            this.JNumChapter.setValue(selectedSubject.getNumChapter());
 
        }
    }//GEN-LAST:event_JListSubjectValueChanged

    private void JTextSubjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextSubjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextSubjectNameActionPerformed

    private void JbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnSaveActionPerformed
        // TODO add your handling code here:
        
        if(this.clickAddSubject) { // Them mon hoc moi
            
            if(JTextSubjectName.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null,"Chưa điền tên môn học!");
               JTextSubjectName.requestFocus();
               return;
            }
             else if(JTextSubjectID.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null,"Chưa điền mã học phần!");
               JTextSubjectID.requestFocus();
               return;
            }
        
            Subject subject = new Subject();
            subject.setSubjectName(this.JTextSubjectName.getText());
            subject.setSubjectID(this.JTextSubjectID.getText());
            subject.setNumChapter((int) this.JNumChapter.getValue());
            
            listSubj.getListSubject().add(subject);
            this.modelListSubject.addElement(subject.getSubjectName()); // them vao List tren Jframe
            this.JListSubject.setModel(modelListSubject);
            this.clickAddSubject = false;
            JTextSubjectName.requestFocus();
            
        }
        else if(clickEditSubject) { // Luu lai thong tin chinh sua
            
            if(JTextSubjectName.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null,"Chưa điền tên môn học!");
               JTextSubjectName.requestFocus();
               return;
            }
             else if(JTextSubjectID.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null,"Chưa điền mã học phần!");
               JTextSubjectID.requestFocus();
               return;
            }
           
           Subject curSubject = listSubj.getListSubject().get(selectedIndex);
           
           curSubject.setSubjectName(JTextSubjectName.getText());
           curSubject.setSubjectID(this.JTextSubjectID.getText());
           curSubject.setNumChapter((int) this.JNumChapter.getValue());
           modelListSubject.remove(this.selectedIndex);
           modelListSubject.add(this.selectedIndex, this.JTextSubjectName.getText());
           this.JListSubject.setModel(modelListSubject);
        }
        
//        this.writeListSubject();
          listSubj.writeListSubject();
          this.notSave = false;
    }//GEN-LAST:event_JbtnSaveActionPerformed

    private void JbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAddActionPerformed
        // TODO add your handling code here:
        
        this.JTextSubjectName.setText("");
        this.JTextSubjectID.setText("");
        this.JNumChapter.setValue(1);
        
        this.clickAddSubject = true;
        this.clickEditSubject = false;
        this.JTextSubjectName.requestFocus();
    }//GEN-LAST:event_JbtnAddActionPerformed

    private void JbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnCancelActionPerformed
        // TODO add your handling code here:
        if(notSave) {
            int exit = JOptionPane.showConfirmDialog(null,"Bạn đã xóa môn học nhưng chưa lưu! Bạn có chắc chắn muốn thoát không?");
            if(exit == JOptionPane.YES_OPTION) {
                this.dispose();
            }
            return;
        }
        this.dispose();
 
    }//GEN-LAST:event_JbtnCancelActionPerformed

    private void JbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnDeleteActionPerformed
        // TODO add your handling code here:
        
        // chọn chức năng xóa thì set chức năng thêm và sửa về false
        this.clickAddSubject = false;
        this.clickEditSubject = false;
        this.notSave = true; // Chưa lưu lại các thao tác xóa.
        
//        for (int i =0; i<listSubj.getListSubject().size(); i++) {
//            Subject sub_i = listSubj.getListSubject().get(i);
            try {
//                if (selectedSubject.equalsIgnoreCase(sub_i.getSubjectName())) {
                    listSubj.getListSubject().remove(selectedIndex);
                   
                    this.modelListSubject.remove(selectedIndex);
                    this.JListSubject.setModel(modelListSubject);
                    this.JTextSubjectName.setText("");
                    this.JTextSubjectID.setText("");
                    this.JNumChapter.setValue(1);
//                    break;
//                }
            }
            catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Chọn môn học trước!");
                return;
            }
//        }
    }//GEN-LAST:event_JbtnDeleteActionPerformed

    private void JbtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnEditActionPerformed
        // TODO add your handling code here:
        this.clickEditSubject = true;
        this.JTextSubjectName.requestFocus();
    }//GEN-LAST:event_JbtnEditActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SubjectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubjectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubjectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SubjectManager().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SubjectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JListSubject;
    private javax.swing.JSpinner JNumChapter;
    private javax.swing.JTextField JTextSubjectID;
    private javax.swing.JTextField JTextSubjectName;
    private javax.swing.JButton JbtnAdd;
    private javax.swing.JButton JbtnCancel;
    private javax.swing.JButton JbtnDelete;
    private javax.swing.JButton JbtnEdit;
    private javax.swing.JButton JbtnSave;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlbDSMonHoc;
    private javax.swing.JLabel jlbMahocphan;
    private javax.swing.JLabel jlbQuanLiMonHoc;
    private javax.swing.JLabel jlbSoChuong;
    private javax.swing.JLabel jlbTenMH;
    // End of variables declaration//GEN-END:variables
}
