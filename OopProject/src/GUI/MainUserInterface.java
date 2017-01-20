/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author linhphan
 */
public class MainUserInterface extends javax.swing.JFrame {

    /**
     * Creates new form MainUserInterface
     */
    public MainUserInterface() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbtnSubjectManager = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        JbtnQuestionManager = new javax.swing.JButton();
        JbtnExamManager = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JbtnSubjectManager.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JbtnSubjectManager.setText("Quản Lý Môn Học");
        JbtnSubjectManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnSubjectManagerActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(255, 51, 51));
        Exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Exit.setText("Thoát");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        JbtnQuestionManager.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JbtnQuestionManager.setText("Quản Lý Câu Hỏi");
        JbtnQuestionManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnQuestionManagerActionPerformed(evt);
            }
        });

        JbtnExamManager.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JbtnExamManager.setText("Quản Lý Đề Thi");
        JbtnExamManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnExamManagerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHƯƠNG TRÌNH QUẢN LÝ ĐỀ THI");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/main.jpg"))); // NOI18N
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JbtnSubjectManager, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JbtnQuestionManager, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(JbtnExamManager, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbtnSubjectManager, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnQuestionManager, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnExamManager, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtnSubjectManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnSubjectManagerActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == JbtnSubjectManager) {
            SubjectManager m = null;
            try {
                m = new SubjectManager();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
            
            m.setVisible(true);
        }
    }//GEN-LAST:event_JbtnSubjectManagerActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
                
    }//GEN-LAST:event_ExitActionPerformed

    private void JbtnQuestionManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnQuestionManagerActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == JbtnQuestionManager) {
            QuestionManager m = null;
            try {
                m = new QuestionManager();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
            m.setVisible(true);
        }
        
    }//GEN-LAST:event_JbtnQuestionManagerActionPerformed

    private void JbtnExamManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnExamManagerActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == JbtnExamManager) {
            ExamManager m = null;
            try {
                m = new ExamManager();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
            }
            m.setVisible(true);
        }
    }//GEN-LAST:event_JbtnExamManagerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton JbtnExamManager;
    private javax.swing.JButton JbtnQuestionManager;
    private javax.swing.JButton JbtnSubjectManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
