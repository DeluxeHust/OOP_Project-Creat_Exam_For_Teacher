/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import oopproject.EssayQuestion;
import oopproject.Exam;
import oopproject.MultipleChoiceQuestion;
import oopproject.Question;
import oopproject.Subject;

/**
 *
 * @author linhphan
 */
public class AutoCreatExam extends javax.swing.JFrame {
    
    private Subject selectedSubject;
    private Exam exam;
    
    private DefaultComboBoxModel modelListChapter;
    
    // set danh sach cau hoi trong de
    private DefaultListModel modelListQuesExam;
    private DefaultListModel modelListQuestion;
    
    // Truyền từ bên Exam Manager sang để update các thuộc tính này cho Exam manager
    private javax.swing.JList<String> JListQuesExam;
    private javax.swing.JList<String> JListQuestion;
    private javax.swing.JTextArea JtextExam;
    
    private ArrayList<MultipleChoiceQuestion> listMultiQues;
    private ArrayList<EssayQuestion> listEssayQues;
    
   
    private String selectedLevel; // do kho
    private int indexChapter; // chi so chuong
    private String selectedChapter; // chương được chọn
    
    // luu so cau trac nghiem, tu luan sinh tu dong cua moi chuong
    private int[] ChapterQuesMulti;
    private int[] ChapterQuesEssay;
    
    
    /**
     * Creates new form TaoDeThi
     */
    public AutoCreatExam() {
        initComponents();
    }

   public AutoCreatExam(Subject subject, Exam exam,DefaultListModel modelListQuesExam, javax.swing.JList<String> JListQuesExam,DefaultListModel modelListQuestion, javax.swing.JList<String> JListQuestion, javax.swing.JTextArea JtextExam) {
       initComponents();
       this.selectedSubject = subject;
       this.exam = exam;
       this.modelListQuesExam = modelListQuesExam;
       this.JListQuesExam = JListQuesExam;
       this.JtextExam = JtextExam;
       this.modelListQuesExam = modelListQuestion;
       this.JListQuestion = JListQuestion;
       
       modelListChapter = new DefaultComboBoxModel();
       updateChapterList();
       
       // chia ra hai arraylist MultiQues va EssayQues. Xoa tron cau hoi trong do.
       this.divideArrayList(this.selectedSubject.getQuestionList());
       
       
       this.JComBoxLevel.setSelectedIndex(0);
       selectedLevel = "Bất kỳ";
       ChapterQuesEssay = new int[selectedSubject.getNumChapter()];
       ChapterQuesMulti = new int[selectedSubject.getNumChapter()];
       
        this.JSpinnerMulti.setEnabled(false);
        this.JSpinnerEssay.setEnabled(false);
        this.JSpinnerNumQues.setEnabled(true);
        this.JNumChapter.setEnabled(false);
        this.setLocation(215, 45);
       
   }

   // Cập nhật danh sách chương
   public void updateChapterList() {
        this.modelListChapter = new DefaultComboBoxModel();
        
        int numChapter = selectedSubject.getNumChapter();
        for(int i = 1; i< numChapter; i++) {
            String chapter_i = "Chương " + i;
            this.modelListChapter.addElement(chapter_i);
        }
        this.JNumChapter.setModel(modelListChapter);
        //this.JNumChapter.setVisible(true);
    
    }
   
   // Cập nhật danh sách câu hỏi trong đề
   public void updateQuestionExam() {
        this.modelListQuesExam = new DefaultListModel();
        for(int i=0; i<exam.getQuestionList().size(); i++) {
            this.modelListQuesExam.addElement(exam.getQuestionList().get(i).getQuestion());
        }
        
        this.JListQuesExam.setModel(modelListQuesExam);
   }
   
   // Cập nhật danh sách câu hỏi của môn được chọn sinh đề
    public void updateQuestionList() {
        
        this.modelListQuestion = new DefaultListModel();
        
        try {
            for(int i=0; i<selectedSubject.getQuestionList().size(); i++) {
                this.modelListQuestion.addElement(selectedSubject.getQuestionList().get(i).getQuestion());
            
            }
        } catch (NullPointerException e) {
            this.selectedSubject.setQuestionList(new ArrayList<Question>());
        }
        this.JListQuestion.setModel(this.modelListQuestion);
        
    }
   
    // cập nhật trường xem trước đề thi của Exam manager
   public void updatePreviewExam() {
        
        String preExam = exam.printExam();
        
        JtextExam.setText(preExam);
    }
    
   // chia ra 2 phan tu luan va trac nghiem rieng, dong thoi xao tron cac cau hoi.
    public void divideArrayList(ArrayList<Question> listQues){
        listMultiQues = new ArrayList<MultipleChoiceQuestion>();
        listEssayQues = new ArrayList<EssayQuestion>();
        for(int i = 0; i < listQues.size(); i++){
            if(listQues.get(i) instanceof MultipleChoiceQuestion)
                listMultiQues.add((MultipleChoiceQuestion) listQues.get(i));  // downcasting
            else
                listEssayQues.add((EssayQuestion) listQues.get(i));
        }
        Collections.shuffle(listEssayQues);
        Collections.shuffle(listMultiQues);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLbDang = new javax.swing.JLabel();
        JRadioMultiQues = new javax.swing.JRadioButton();
        JRadioEssay = new javax.swing.JRadioButton();
        JRadioMultiEssay = new javax.swing.JRadioButton();
        jLbHinhThuc = new javax.swing.JLabel();
        JRadioMulEssayChung = new javax.swing.JRadioButton();
        JRadioDivideMulEssay = new javax.swing.JRadioButton();
        JSpinnerNumQues = new javax.swing.JSpinner();
        JComBoxLevel = new javax.swing.JComboBox<>();
        JCheckQuesInChapter = new javax.swing.JCheckBox();
        JNumChapter = new javax.swing.JComboBox<>();
        jLbTN = new javax.swing.JLabel();
        jLbTL = new javax.swing.JLabel();
        JbtnOK = new javax.swing.JButton();
        jLbTaoDeThi = new javax.swing.JLabel();
        JSpinnerMulti = new javax.swing.JSpinner();
        JSpinnerEssay = new javax.swing.JSpinner();
        jLbTaoDeThi1 = new javax.swing.JLabel();
        jLbTaoDeThi2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLbDang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLbDang.setText("Dạng Đề Thi");

        buttonGroup1.add(JRadioMultiQues);
        JRadioMultiQues.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JRadioMultiQues.setText("Trắc Nghiệm");
        JRadioMultiQues.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JRadioMultiQuesItemStateChanged(evt);
            }
        });

        buttonGroup1.add(JRadioEssay);
        JRadioEssay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JRadioEssay.setText("Tự Luận");
        JRadioEssay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JRadioEssayItemStateChanged(evt);
            }
        });

        buttonGroup1.add(JRadioMultiEssay);
        JRadioMultiEssay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JRadioMultiEssay.setSelected(true);
        JRadioMultiEssay.setText("Trắc Nghiệm và Tự Luận");
        JRadioMultiEssay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JRadioMultiEssayItemStateChanged(evt);
            }
        });

        jLbHinhThuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLbHinhThuc.setText("Hình Thức");

        buttonGroup2.add(JRadioMulEssayChung);
        JRadioMulEssayChung.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JRadioMulEssayChung.setSelected(true);
        JRadioMulEssayChung.setText("Trắc Nghiệm và Tự Luận Chung");

        buttonGroup2.add(JRadioDivideMulEssay);
        JRadioDivideMulEssay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JRadioDivideMulEssay.setText("Trắc Nghiệm và Tự luận Riêng");
        JRadioDivideMulEssay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRadioDivideMulEssayActionPerformed(evt);
            }
        });

        JComBoxLevel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JComBoxLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bất kỳ", "Dễ", "Trung Bình", "Khó" }));
        JComBoxLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JComBoxLevelItemStateChanged(evt);
            }
        });

        JCheckQuesInChapter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JCheckQuesInChapter.setText("Chọn số câu hỏi mỗi chương");
        JCheckQuesInChapter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCheckQuesInChapterItemStateChanged(evt);
            }
        });
        JCheckQuesInChapter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCheckQuesInChapterActionPerformed(evt);
            }
        });

        JNumChapter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JNumChapterItemStateChanged(evt);
            }
        });

        jLbTN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLbTN.setText("Trắc Nghiệm");

        jLbTL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLbTL.setText("Tự Luận");

        JbtnOK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JbtnOK.setText("OK");
        JbtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnOKActionPerformed(evt);
            }
        });

        jLbTaoDeThi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbTaoDeThi.setText("Sinh Đề Tự Động");

        JSpinnerMulti.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JSpinnerMultiStateChanged(evt);
            }
        });

        JSpinnerEssay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                JSpinnerEssayStateChanged(evt);
            }
        });

        jLbTaoDeThi1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbTaoDeThi1.setText("Độ khó");

        jLbTaoDeThi2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbTaoDeThi2.setText("Số câu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
                        .addComponent(JbtnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLbTaoDeThi1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLbTaoDeThi2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JComBoxLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(JSpinnerNumQues, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JSpinnerEssay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLbDang, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JRadioMultiQues)
                                        .addGap(18, 18, 18)
                                        .addComponent(JRadioEssay)
                                        .addGap(41, 41, 41)
                                        .addComponent(JRadioMultiEssay))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JRadioMulEssayChung)
                                        .addGap(48, 48, 48)
                                        .addComponent(JRadioDivideMulEssay)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(JCheckQuesInChapter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JNumChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JSpinnerMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLbTN)
                    .addComponent(jLbTL))
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(jLbTaoDeThi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLbTaoDeThi)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLbDang)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JRadioMultiQues)
                        .addComponent(JRadioEssay)
                        .addComponent(JRadioMultiEssay)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbHinhThuc)
                    .addComponent(JRadioMulEssayChung)
                    .addComponent(JRadioDivideMulEssay))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JSpinnerNumQues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCheckQuesInChapter)
                    .addComponent(JNumChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbTN)
                    .addComponent(JSpinnerMulti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbTaoDeThi2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JComBoxLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbTL)
                    .addComponent(JSpinnerEssay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLbTaoDeThi1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(JbtnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRadioMultiQuesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JRadioMultiQuesItemStateChanged
        // TODO add your handling code here:
         if(this.JRadioMultiQues.isSelected()){
            this.JSpinnerMulti.setEnabled(true);
            this.JSpinnerEssay.setEnabled(false);
            this.JRadioMulEssayChung.setEnabled(false);
            this.JRadioDivideMulEssay.setEnabled(false);
            
        }
    }//GEN-LAST:event_JRadioMultiQuesItemStateChanged

    private void JRadioEssayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JRadioEssayItemStateChanged
        // TODO add your handling code here:
        if(this.JRadioEssay.isSelected()){
            this.JSpinnerMulti.setEnabled(false);
            this.JSpinnerEssay.setEnabled(true);
            this.JRadioMulEssayChung.setEnabled(false);
            this.JRadioDivideMulEssay.setEnabled(false);
            
        }
    }//GEN-LAST:event_JRadioEssayItemStateChanged

    private void JCheckQuesInChapterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCheckQuesInChapterActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JCheckQuesInChapterActionPerformed

    private void JRadioDivideMulEssayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRadioDivideMulEssayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRadioDivideMulEssayActionPerformed

    private void JCheckQuesInChapterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCheckQuesInChapterItemStateChanged
        // TODO add your handling code here:
        
        
        if(this.JCheckQuesInChapter.isSelected()){
            this.JNumChapter.setEnabled(true);

//            this.JComBoxLevel.setEnabled(false);
            this.JSpinnerNumQues.setEnabled(false);
            
            if(this.JRadioMultiQues.isSelected()){
                this.JSpinnerMulti.setEnabled(true);
                this.JSpinnerEssay.setEnabled(false);
            }else if(this.JRadioEssay.isSelected()){
                this.JSpinnerMulti.setEnabled(false);
                this.JSpinnerEssay.setEnabled(true);
            }else{
                this.JSpinnerMulti.setEnabled(true);
                this.JSpinnerEssay.setEnabled(true);
            }
        } 
        else {
            this.JSpinnerMulti.setEnabled(false);
            this.JSpinnerEssay.setEnabled(false);
            this.JSpinnerNumQues.setEnabled(true);
            this.JNumChapter.setEnabled(false);
        }
    }//GEN-LAST:event_JCheckQuesInChapterItemStateChanged

    private void JRadioMultiEssayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JRadioMultiEssayItemStateChanged
        // TODO add your handling code here:
        if(this.JRadioMultiEssay.isSelected()){
            this.JRadioMulEssayChung.setEnabled(true);
            this.JRadioDivideMulEssay.setEnabled(true);
            this.JSpinnerMulti.setEnabled(true);
            this.JSpinnerEssay.setEnabled(true);
        }
    }//GEN-LAST:event_JRadioMultiEssayItemStateChanged

    private void JComBoxLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JComBoxLevelItemStateChanged
        // TODO add your handling code here:
        int indexLevel = this.JComBoxLevel.getSelectedIndex();
        switch(indexLevel) {
            case 0: 
                selectedLevel = "Bất kỳ";
                break;
            case 1:
                selectedLevel = "Dễ";
                break;
            case 2:
                selectedLevel = "Trung bình";
                break;
            case 3:
                selectedLevel = "Khó";
                break;
        }
    }//GEN-LAST:event_JComBoxLevelItemStateChanged

    private void JbtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnOKActionPerformed
        // TODO add your handling code here:
        
        //Sinh de ngau nhieu tu so cau cho truoc
        if(this.JCheckQuesInChapter.isSelected() ==false) {
            int numQues = Integer.parseInt(this.JSpinnerNumQues.getValue().toString()) ;
            if(numQues <0) {
                JOptionPane.showMessageDialog(null,"Nhập số câu lớn hơn 0");
            }
            // Sinh de trac nghiem
            if(this.JRadioMultiQues.isSelected()) {
                ArrayList<MultipleChoiceQuestion> tempListMulti = new ArrayList<MultipleChoiceQuestion>();
                
                if(numQues > this.listMultiQues.size()) {
                    JOptionPane.showMessageDialog(null,"Ngân hàng câu hỏi không đủ!");
                    return;
                }
                // De trac nghiem do kho bat ki
                if(selectedLevel.equals("Bất kỳ")) {
                    // them cau hoi trac nghiem vao de thi
                    // danh sach cau trac nghiem da duoc tao va xao tron tu ham divideArrayList();
                    for(int i=0; i<numQues ;i++) {
                        this.exam.getQuestionList().add(listMultiQues.get(i));
                    }
                   // System.out.println("Exam Ques:" + this.exam.getQuestionList().size());
                
                }
                // de trac nghiem do kho xac dinh
                else {
                    for(int i=0; i< listMultiQues.size(); i++) {
                        if(listMultiQues.get(i).getLevel().equalsIgnoreCase(selectedLevel)) {
                            tempListMulti.add(listMultiQues.get(i));
                        }
                    }
                    
                    if(numQues > tempListMulti.size()) {
                        JOptionPane.showMessageDialog(null,"Không đủ câu trắc nghiệm với độ khó: "+selectedLevel);
                        return;
                    }
                    Collections.shuffle(tempListMulti);
                    
                    for(int i=0; i<numQues; i++) {
                        this.exam.getQuestionList().add(tempListMulti.get(i));
                    }
                }
            }
            // sinh de tu luan
            else if(JRadioEssay.isSelected()) {
               
                
                if(numQues > this.listEssayQues.size()) {
                    JOptionPane.showMessageDialog(null,"Không đủ câu hỏi tự luận!");
                    return;
                }
                
                // de tu luan do kho bat ki
                if(selectedLevel.equals("Bất Kỳ")) {
                    // thêm câu hỏi tự luận vào đề thi. Câu hỏi đã được xáo trộn ở divideÁrraylist();
                    for(int i =0; i<numQues; i++) {
                        this.exam.getQuestionList().add(listEssayQues.get(i));
                        
                    }
                    
                }
                // sinh de tu luan do kho xac dinh
                else {
                    ArrayList<EssayQuestion> tempListEssay = new ArrayList<EssayQuestion>();
                     
                    for(int i=0; i<listEssayQues.size(); i++ ) {
                         if(listEssayQues.get(i).getLevel().equals(selectedLevel)) {
                             tempListEssay.add(listEssayQues.get(i));
                         }
                    }
                     
                    if(numQues > tempListEssay.size()) {
                         JOptionPane.showMessageDialog(null,"Không đủ câu hỏi tự luận với độ khó: "+selectedLevel);
                         return;
                    }
                    Collections.shuffle(tempListEssay);
                    
                    for(int i=0; i<numQues; i++) {
                        this.exam.getQuestionList().add(tempListEssay.get(i));
                    }
                    
                }
            }
            
            // sinh de ca trac nghiem va tu luan
            else {
                    
                if(numQues > selectedSubject.getQuestionList().size()) {
                    JOptionPane.showMessageDialog(null,"Không đủ số lượng câu hỏi cho đề");
                    return;
                }
                
                Collections.shuffle(selectedSubject.getQuestionList());
                
                // trac nghiem va tu luan chung
                if(JRadioMulEssayChung.isSelected()) {
                    
                    for(int i=0; i< numQues; i++) {
                        exam.getQuestionList().add(selectedSubject.getQuestionList().get(i));
                    }
                    
                }
                // trac nghiem va tu luan rieng
                else {
                    
                    for(int i=0; i< numQues; i++) {
                        
                        // trac nghiem thi them vao dau danh sach cau hoi trong de
                        if(selectedSubject.getQuestionList().get(i) instanceof MultipleChoiceQuestion) {
                            this.exam.getQuestionList().add(0,selectedSubject.getQuestionList().get(i));
                        }
                        else { // cau tu luan thi them cuoi danh sach
                            this.exam.getQuestionList().add(selectedSubject.getQuestionList().get(i));
                        }
                    }
                    
                }
                
            }
        }
        // Chọn số câu mỗi chương đem vào đề thi
        else {
            
            if(selectedLevel.equalsIgnoreCase("Bất Kỳ")) {
                
                // Sinh đề chỉ có trắc nghiệm
                if(JRadioMultiQues.isSelected()) {
                    

                    ArrayList<Question> tempQues = new ArrayList<>();
                    for(int i=0; i< selectedSubject.getNumChapter(); i++) {
                     
                        int count =0;
                        // so luong cau tim cho chuong i
                        for(int k=0; k<listMultiQues.size() ; k++) {
                            
                            // neu chon du so cau cua chuong i
                            if(count == ChapterQuesMulti[i]) {
                                k= listMultiQues.size(); // thoat vong lap
                            }
                            else if(listMultiQues.get(k).getChapter().equalsIgnoreCase("Chương " +(i+1))) {
                                tempQues.add(listMultiQues.get(k));
                                count ++;
                            }
                            
                        }
                        
                        if(count < ChapterQuesMulti[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ số câu trắc nghiệm của chương "+(i+1));
                            return;
                        }
                    }
                    
                    exam.setQuestionList(tempQues);
                    
                }
                // sinh de tu luan
                else if (JRadioEssay.isSelected()) {
                    
                    ArrayList<Question> tempQues = new ArrayList<>();
                    
                    for(int i=0; i< selectedSubject.getNumChapter(); i++) {
                     
                        int count =0;
                        // so luong cau tim cho chuong i
                        for(int k=0; k<listEssayQues.size() ; k++) {
                            
                            // neu chon du so cau cua chuong i
                            if(count == ChapterQuesEssay[i]) {
                                k= listEssayQues.size(); // thoat vong lap
                            }
                            else if(listEssayQues.get(k).getChapter().equalsIgnoreCase("Chương " +(i+1))) {
                                tempQues.add(listEssayQues.get(k));
                                count ++;
                            }
                            
                        }
                        
                        if(count < ChapterQuesEssay[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ số câu tự luận của chương "+(i+1));
                            return;
                        }
                    }
                    
                    exam.setQuestionList(tempQues);
                }
                // sinh de ca trac nghiem lan tu luan
                else {
                    // sinh de thi trac nghiem va tu luan rieng
                    ArrayList<Question> tempQues = new ArrayList<>();
                    
                    for(int i=0; i<selectedSubject.getNumChapter(); i++) {
                        
                        int countEssay = 0;
                        int countMulti = 0;
                        // lay cau tu luan
                        for(int j =0; j< listEssayQues.size(); j++) {
                            
                            // nếu đã lấy đủ số câu tự luận của chương i thì nhảy sang chương i+1
                            if(countEssay == ChapterQuesEssay[i]) {
                                j = listEssayQues.size(); // thoát khỏi vòng lặp chương i
                            }
                            // nếu chưa đủ câu, kiểm tra câu đó có đúng chươnng k, nếu đúng thì thêm vào
                            else if(listEssayQues.get(j).getChapter().equalsIgnoreCase("Chương " +(i+1) )) {
                                tempQues.add(listEssayQues.get(j));

                                countEssay ++;
                            }
                            
                            
                            
                        }
                        // Lấy câu trắc nghiệm của chương đó
                        for(int j =0; j< listMultiQues.size(); j++) {
                            
                            // Nếu đã lấy đủ câu trắc nghiệm của chương thì tìm sang chương kế tiếp.
                            if(countMulti == ChapterQuesMulti[i]) {
    //                            System.out.println("Count Multi Chapter " +(i+1) +": "+ countMulti);
                                j = listMultiQues.size(); // Thoát vòng lặp
                            }
                            
                            else if(listMultiQues.get(j).getChapter().equalsIgnoreCase("Chương " +(i+1) )) {
                                tempQues.add(0,listMultiQues.get(j));
    //                            System.out.println("Multi chapter: "+(i+1) +" , j= " +j);
    //                            System.out.println("Multi Chapter: " + listMultiQues.get(j).getChapter());
                                countMulti ++;
                            }
                            
                            
                        }
                        // kiểm tra xem số câu trong ngân hàng có đủ không.
                        if(countEssay < ChapterQuesEssay[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ câu tự luận chương " +(i+1));
                            return;
                        }
                        
                        if(countMulti < ChapterQuesMulti[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ câu trắc nghiệm chương " +(i+1));
                            return;
                        }
                    }
                    // -------------------------TEST --------------------------
    //                System.out.println("temques Size: "+tempQues.size());
    //                System.out.println("Array Chapter: ");
    //                for(int i=0; i<ChapterQuesEssay.length; i++) {
    //                    System.out.println("ChapterEsay["+i+"]"+ "=" +ChapterQuesEssay[i]);
    //                }
    //                for(int i=0; i<ChapterQuesMulti.length; i++) {
    //                    System.out.println("ChapterMulti["+i+"]"+ "=" +ChapterQuesMulti[i]);
    //                }
                    // -------------------------TEST --------------------------
                    
                    
                    exam.setQuestionList(tempQues);
                    
                    // Nếu chọn sinh trắc nghiệm và tự luận lẫn lộn, thì trộn các câu hỏi lại
                    if(JRadioMulEssayChung.isSelected()) {
                        Collections.shuffle(tempQues);
                        exam.setQuestionList(tempQues);
                    }
                    
                }
            }
            
            // Sinh đề với độ khó cho trước
            else {
                
                 // Sinh đề chỉ có trắc nghiệm
                if(JRadioMultiQues.isSelected()) {

                    ArrayList<Question> tempQues = new ArrayList<>();
                    for(int i=0; i< selectedSubject.getNumChapter(); i++) {
                     
                        int count =0;
                        // so luong cau tim cho chuong i
                        for(int k=0; k<listMultiQues.size() ; k++) {
                            
                            // neu chon du so cau cua chuong i
                            if(count == ChapterQuesMulti[i]) {
                                k= listMultiQues.size(); // thoat vong lap
                            }
                            else if(listMultiQues.get(k).getChapter().equalsIgnoreCase("Chương " +(i+1)) && listMultiQues.get(k).getLevel().equalsIgnoreCase(selectedLevel)) {
                                tempQues.add(listMultiQues.get(k));
                                count ++;
                            }
                            
                        }
                        
                        if(count < ChapterQuesMulti[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ số câu trắc nghiệm "+selectedLevel+" của chương "+(i+1));
                            return;
                        }
                    }
                    
                    exam.setQuestionList(tempQues);
                    
                }
                // sinh đề tự luận
                else if (JRadioEssay.isSelected()) {
                    
                    ArrayList<Question> tempQues = new ArrayList<>();
                    
                    for(int i=0; i< selectedSubject.getNumChapter(); i++) {
                     
                        int count =0;
                        // so luong cau tim cho chuong i
                        for(int k=0; k<listEssayQues.size() ; k++) {
                           
                            if(count == ChapterQuesEssay[i]) {
                                k= listEssayQues.size(); // thoat vong lap
                            }
                            else if(listEssayQues.get(k).getChapter().equalsIgnoreCase("Chương " +(i+1)) && listEssayQues.get(k).getLevel().equalsIgnoreCase(selectedLevel)) {
                                tempQues.add(listEssayQues.get(k));
                                count ++;
                            }
                            
                        }
                        
                        if(count < ChapterQuesEssay[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ số câu tự luận "+selectedLevel+" của chương "+(i+1));
                            return;
                        }
                    }
                    
                    exam.setQuestionList(tempQues);
                }
                // sinh đề thi có cả trắc nghiệm và tự luận
                else {
                    // sinh đề thi trắc nghiệm và tự luận riêng
                    ArrayList<Question> tempQues = new ArrayList<>();
                    
                    for(int i=0; i<selectedSubject.getNumChapter(); i++) {
                        
                        int countEssay = 0;
                        int countMulti = 0;
                        // lay cau tu luan
                        for(int j =0; j< listEssayQues.size(); j++) {
                            
                            // nếu đã lấy đủ số câu tự luận của chương i thì nhảy sang chương i+1
                            if(countEssay == ChapterQuesEssay[i]) {
                                j = listEssayQues.size(); // thoát khỏi vòng lặp chương i
                            }
                            // nếu chưa đủ câu, kiểm tra câu đó có đúng chươnng k, độ khó cho trước. nếu đúng thì thêm vào
                            else if(listEssayQues.get(j).getChapter().equalsIgnoreCase("Chương " +(i+1) ) && listEssayQues.get(j).getLevel().equalsIgnoreCase(selectedLevel)) {
                                tempQues.add(listEssayQues.get(j));

                                countEssay ++;
                            }
                            
                            
                            
                        }
                        // Lấy câu trắc nghiệm của chương đó
                        for(int j =0; j< listMultiQues.size(); j++) {
                            
                            // Nếu đã lấy đủ câu trắc nghiệm của chương thì tìm sang chương kế tiếp.
                            if(countMulti == ChapterQuesMulti[i]) {
    //                            System.out.println("Count Multi Chapter " +(i+1) +": "+ countMulti);
                                j = listMultiQues.size(); // Thoát vòng lặp
                            }
                            
                            else if(listMultiQues.get(j).getChapter().equalsIgnoreCase("Chương " +(i+1) )&& listEssayQues.get(j).getLevel().equalsIgnoreCase(selectedLevel)) {
                                tempQues.add(0,listMultiQues.get(j));
    //                            System.out.println("Multi chapter: "+(i+1) +" , j= " +j);
    //                            System.out.println("Multi Chapter: " + listMultiQues.get(j).getChapter());
                                countMulti ++;
                            }
                            
                            
                        }
                        // kiểm tra xem số câu trong ngân hàng có đủ không.
                        if(countEssay < ChapterQuesEssay[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ câu tự luận chương " +(i+1));
                            return;
                        }
                        
                        if(countMulti < ChapterQuesMulti[i]) {
                            JOptionPane.showMessageDialog(null,"Không đủ câu trắc nghiệm chương " +(i+1));
                            return;
                        }
                    }
                    exam.setQuestionList(tempQues);
                    
                    // Nếu chọn sinh trắc nghiệm và tự luận lẫn lộn, thì trộn các câu hỏi lại
                    if(JRadioMulEssayChung.isSelected()) {
                        Collections.shuffle(tempQues);
                        exam.setQuestionList(tempQues);
                    }
                    
                }
                
            }
            
            
        }
        this.dispose();
        updateQuestionList();
        updateQuestionExam();
        updatePreviewExam();
        
    }//GEN-LAST:event_JbtnOKActionPerformed

    private void JNumChapterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JNumChapterItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            indexChapter = this.JNumChapter.getSelectedIndex();
            this.JSpinnerMulti.setValue(ChapterQuesMulti[indexChapter]);
            this.JSpinnerEssay.setValue(ChapterQuesEssay[indexChapter]);
            
        }
        System.out.println("index multi: " + ChapterQuesMulti[indexChapter]);
        System.out.println("index ess: " + ChapterQuesEssay[indexChapter]);
        
    }//GEN-LAST:event_JNumChapterItemStateChanged

    private void JSpinnerMultiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JSpinnerMultiStateChanged
        // TODO add your handling code here:
        indexChapter = this.JNumChapter.getSelectedIndex();
        ChapterQuesMulti[indexChapter] = (int) JSpinnerMulti.getValue();
        
        int totalQues = (int) JSpinnerEssay.getValue() + ChapterQuesMulti[indexChapter];
        JSpinnerNumQues.setValue(totalQues);
        
    }//GEN-LAST:event_JSpinnerMultiStateChanged

    private void JSpinnerEssayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_JSpinnerEssayStateChanged
        // TODO add your handling code here:
        indexChapter = this.JNumChapter.getSelectedIndex();
        ChapterQuesEssay[indexChapter] = (int) JSpinnerEssay.getValue();
        
        int totalQues = (int) JSpinnerMulti.getValue() + ChapterQuesEssay[indexChapter];
        JSpinnerNumQues.setValue(totalQues);
    }//GEN-LAST:event_JSpinnerEssayStateChanged

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
            java.util.logging.Logger.getLogger(AutoCreatExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutoCreatExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutoCreatExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutoCreatExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutoCreatExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox JCheckQuesInChapter;
    private javax.swing.JComboBox<String> JComBoxLevel;
    private javax.swing.JComboBox<String> JNumChapter;
    private javax.swing.JRadioButton JRadioDivideMulEssay;
    private javax.swing.JRadioButton JRadioEssay;
    private javax.swing.JRadioButton JRadioMulEssayChung;
    private javax.swing.JRadioButton JRadioMultiEssay;
    private javax.swing.JRadioButton JRadioMultiQues;
    private javax.swing.JSpinner JSpinnerEssay;
    private javax.swing.JSpinner JSpinnerMulti;
    private javax.swing.JSpinner JSpinnerNumQues;
    private javax.swing.JButton JbtnOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLbDang;
    private javax.swing.JLabel jLbHinhThuc;
    private javax.swing.JLabel jLbTL;
    private javax.swing.JLabel jLbTN;
    private javax.swing.JLabel jLbTaoDeThi;
    private javax.swing.JLabel jLbTaoDeThi1;
    private javax.swing.JLabel jLbTaoDeThi2;
    // End of variables declaration//GEN-END:variables
}
