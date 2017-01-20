/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ItemEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import oopproject.Answer;
import oopproject.EssayQuestion;
import oopproject.ListSubject;
import oopproject.MultipleChoiceQuestion;
import oopproject.Question;
import oopproject.Subject;

/**
 *
 * @author linhphan
 */
public class QuestionManager extends javax.swing.JFrame {

    private ListSubject listSubj;
    
    // Mon hoc va cau hoi duoc chon trong model 
    private Subject selectedSubject;
    private Question selectedQuestion;
//    private Subject selectSubjectNoChange; // Dung khi click btn Huy
    
    // Luu cac chi so trong arraylist de tien luu ra file va chinh sua.
    private int indexSelectedSubject; // chi so mon hoc duoc chon
    private int indexSelectedQues;  // chi so cau hoi duoc chon
    private int indexSelectedAnswer; // chi so dap an duoc chon
    
    // listAnswer luu danh sach câu hỏi vừa nhập
    private ArrayList<Answer> listAnswer;
    
    
    private DefaultComboBoxModel modelListSubject; // doi tuong set model cho ComboBox;
    private DefaultComboBoxModel modelListChapter;
    private DefaultListModel modelQuestion;
    private DefaultListModel modelAnwer;
    
    private boolean clickBtnAdd;
    private boolean clickBtnDelete;
    private boolean changeSubject;
    /**
     * Creates new form QuanLiCauHoi
     */
    
    
    public QuestionManager() throws FileNotFoundException {
        initComponents();
        
        listSubj = new ListSubject();
        listAnswer = new ArrayList<Answer>();
        this.modelListSubject = new DefaultComboBoxModel();
        this.clickBtnAdd = false;
        this.clickBtnDelete = false;
        this.changeSubject = false;
        
        // cap nhat danh sach mon hoc
        listSubj.setListSubject(listSubj.readListSubject());
        updateListSubject(listSubj.getListSubject());
        
        // chon mon dau tien
        selectedSubject = this.listSubj.getListSubject().get(0);
        indexSelectedSubject = 0; 
        
        indexSelectedQues = -1; // Chưa chọn câu nào.
        indexSelectedAnswer =-1;
        
        // Cap nhat danh sach cau hoi, chi tiet cau hoi, danh sach chuong
        updateQuestionList();
        updateQuestionDetail();
        updateChapterList();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(215,45);
        
    }
    
    // Update danh Sách môn học
    public void updateListSubject(ArrayList<Subject> listSubject) {
        
        for(int i=0; i<listSubject.size(); i++) {
            this.modelListSubject.addElement(listSubject.get(i).getSubjectName());
            
        } 
        this.JcomListSubject.setModel(modelListSubject);
    }

    
    // Update Danh sách câu hỏi
    public void updateQuestionList() {
        
        this.modelQuestion = new DefaultListModel();
        
        try {
            for(int i=0; i<selectedSubject.getQuestionList().size(); i++) {
                this.modelQuestion.addElement(selectedSubject.getQuestionList().get(i).getQuestion());
            
            }
        } catch (NullPointerException e) {
            this.selectedSubject.setQuestionList(new ArrayList<Question>());
            System.out.println("Khoi tao ArrayList<Question>");
        }
        this.JListQuestion.setModel(this.modelQuestion);
        
    }
    
    // update Cac chi tiết của đáp án
    public void updateQuestionDetail() {
        
        // update đề bài
        if(indexSelectedQues == -1 && clickBtnAdd ==false) { // chưa chọn câu nào
            JRadioMutiQues.setVisible(false);
            JRadioEssayQues.setVisible(false);
            JTextAnswerDetail.setVisible(false);
            JTextQuesDetail.setVisible(false);
            JListAnswer.setVisible(false);
            JbtnDeleteAnswer.setVisible(false);
            JbtnAddAnswer.setVisible(false);
            JbtnEditAnswer.setVisible(false);
            JComboLevel.setVisible(false);
            JNumChapter.setVisible(false);
            System.out.println("Chưa chọn câu nào.");
            return;
        }
        else if(clickBtnAdd) { // click them cau hoi
            
            // Dat mac dinh them cau hoi trac nghiem
            JRadioMutiQues.setSelected(true);
            JRadioEssayQues.setSelected(false);
            JRadioMutiQues.setVisible(true);
            JRadioEssayQues.setVisible(true);

            // reset text
            this.JTextQuesDetail.setText("");
            this.JTextQuesDetail.setVisible(true);
            
            this.JTextAnswerDetail.setText("");
            this.JTextAnswerDetail.setVisible(true);
            
            this.JComboLevel.setSelectedIndex(1);
            
            this.modelAnwer = new DefaultListModel();
            this.JListAnswer.setModel(modelAnwer);
            this.JListAnswer.setVisible(true);
            
            this.listAnswer = new ArrayList<Answer>();
            
            // Hien Cac btn
            JbtnAddAnswer.setVisible(true);
            JbtnDeleteAnswer.setVisible(true);
            JbtnEditAnswer.setVisible(true);
            
            JComboLevel.setVisible(true);
            JNumChapter.setVisible(true);
            
            indexSelectedQues = -1;
            System.out.println("Them cau hoi moi");
        }
        else { // da chon 1 cau hoi nao do trong danh sach
            if(selectedQuestion instanceof MultipleChoiceQuestion) { // Cau hoi duoc chon la cau trac nghiem
                // Chọn radio trắc nghiệm
                System.out.println("Chon cau trac nghiem");
                this.JRadioMutiQues.setSelected(true);
                this.JRadioEssayQues.setSelected(false);
                JRadioMutiQues.setVisible(true);
                JRadioEssayQues.setVisible(true);
            
                this.modelAnwer = new DefaultListModel();
            
                // Hien de bai, danh sach dap an
                JTextQuesDetail.setVisible(true);
                JListAnswer.setVisible(true);
                JTextAnswerDetail.setVisible(true);
            
                // downcasting
                MultipleChoiceQuestion multiQues = (MultipleChoiceQuestion) selectedQuestion;

                // update answer list 
                listAnswer = multiQues.getAnswerList();
                for(int i=0; i< multiQues.getAnswerList().size(); i++) {
                    this.modelAnwer.addElement(listAnswer.get(i).getContent());
                }
                this.JListAnswer.setModel(modelAnwer);
            
                // show btn them, sua, xoa
                JbtnAddAnswer.setVisible(true);
                JbtnDeleteAnswer.setVisible(true);
                JbtnEditAnswer.setVisible(true);
            }
            else {
                System.out.println("chon cau tu luan");
                // Chọn radio tự luận
                JRadioMutiQues.setSelected(false);
                JRadioEssayQues.setSelected(true);
                JRadioMutiQues.setVisible(true);
                JRadioEssayQues.setVisible(true);

                // Hien de bai
                JTextQuesDetail.setVisible(true);
                // Ân đáp án
                JListAnswer.setVisible(false);
                JTextAnswerDetail.setVisible(false);

                // An btn them sua xoa
                JbtnAddAnswer.setVisible(false);
                JbtnDeleteAnswer.setVisible(false);
                JbtnEditAnswer.setVisible(false);
            } 
        
            // update de bai
            this.JTextQuesDetail.setText(selectedQuestion.getQuestion());

            // update độ khó
            String level = selectedQuestion.getLevel();
            if(level.equalsIgnoreCase("dễ")) {
                this.JComboLevel.setSelectedIndex(0);
            }
            else if(level.equalsIgnoreCase("trung bình")) {
                this.JComboLevel.setSelectedIndex(1);
            }
            else {
                this.JComboLevel.setSelectedIndex(2);
            }
            JComboLevel.setVisible(true);

            // update chương
            this.JNumChapter.setSelectedItem(selectedQuestion.getChapter());
            JNumChapter.setVisible(true);
            
            // Update chi tiet cau hoi
            int indexQues = indexSelectedQues +1; // Chỉ số câu hỏi bắt đầu từ 1
            String detail = "Câu số " + indexQues + ":\n ------------------------ \n" + selectedQuestion.showDetailQuestion();
            this.JTextAnswerDetail.setText(detail);
        }
        
    }
    
    
    
    // update danh sách Chương
    public void updateChapterList() {
        this.modelListChapter = new DefaultComboBoxModel();
        
        int numChapter = selectedSubject.getNumChapter();
        for(int i = 1; i< numChapter; i++) {
            String chapter_i = "Chương " + i;
            this.modelListChapter.addElement(chapter_i);
        }
        this.JNumChapter.setModel(modelListChapter);

        
        
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
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLbQuanLiCauHoi = new javax.swing.JLabel();
        jLbDSMonHoc = new javax.swing.JLabel();
        JcomListSubject = new javax.swing.JComboBox<>();
        jLbDSCauHoi = new javax.swing.JLabel();
        JbtnAddQues = new javax.swing.JButton();
        JbtnSave = new javax.swing.JButton();
        JbtnCancel = new javax.swing.JButton();
        jLbHinhThuc = new javax.swing.JLabel();
        jLbDebai = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTextQuesDetail = new javax.swing.JTextArea();
        jLbDapAnTN = new javax.swing.JLabel();
        jLbBarem = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTextAnswerDetail = new javax.swing.JTextArea();
        JbtnAddAnswer = new javax.swing.JButton();
        JbtnDeleteAnswer = new javax.swing.JButton();
        JRadioMutiQues = new javax.swing.JRadioButton();
        JRadioEssayQues = new javax.swing.JRadioButton();
        jLbĐoKho = new javax.swing.JLabel();
        JComboLevel = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JNumChapter = new javax.swing.JComboBox<>();
        jBtOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListQuestion = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        JListAnswer = new javax.swing.JList<>();
        JbtnDeleteQues = new javax.swing.JButton();
        JbtnEditAnswer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLbQuanLiCauHoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbQuanLiCauHoi.setText("Quản Lí Câu Hỏi");

        jLbDSMonHoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbDSMonHoc.setText("Danh Sách Môn Học");

        JcomListSubject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JcomListSubject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JcomListSubjectItemStateChanged(evt);
            }
        });
        JcomListSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcomListSubjectActionPerformed(evt);
            }
        });

        jLbDSCauHoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbDSCauHoi.setText("Danh Sách Câu Hỏi");

        JbtnAddQues.setText("Thêm");
        JbtnAddQues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAddQuesActionPerformed(evt);
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
        JbtnCancel.setText("Hủy");
        JbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnCancelActionPerformed(evt);
            }
        });

        jLbHinhThuc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbHinhThuc.setText("Hình Thức");

        jLbDebai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbDebai.setText("Đề Bài");

        JTextQuesDetail.setColumns(20);
        JTextQuesDetail.setRows(5);
        jScrollPane2.setViewportView(JTextQuesDetail);

        jLbDapAnTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbDapAnTN.setText("Đáp Án");

        jLbBarem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbBarem.setText("Chi tiết");

        JTextAnswerDetail.setColumns(20);
        JTextAnswerDetail.setRows(5);
        jScrollPane4.setViewportView(JTextAnswerDetail);

        JbtnAddAnswer.setText("Thêm");
        JbtnAddAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAddAnswerActionPerformed(evt);
            }
        });

        JbtnDeleteAnswer.setText("Xóa");
        JbtnDeleteAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnDeleteAnswerActionPerformed(evt);
            }
        });

        buttonGroup1.add(JRadioMutiQues);
        JRadioMutiQues.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRadioMutiQues.setText("Trắc Nghiệm");
        JRadioMutiQues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRadioMutiQuesActionPerformed(evt);
            }
        });

        buttonGroup1.add(JRadioEssayQues);
        JRadioEssayQues.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JRadioEssayQues.setText("Tự Luận");
        JRadioEssayQues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRadioEssayQuesActionPerformed(evt);
            }
        });

        jLbĐoKho.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLbĐoKho.setText("Độ Khó");

        JComboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dễ", "Trung Bình", "Khó" }));
        JComboLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboLevelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chương");

        jBtOK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtOK.setText("OK");
        jBtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOKActionPerformed(evt);
            }
        });

        JListQuestion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JListQuestion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Câu hỏi 1", "Câu hỏi 2", "Câu hỏi 3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        JListQuestion.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                JListQuestionValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(JListQuestion);

        jScrollPane3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JListAnswer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JListAnswer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JListAnswer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                JListAnswerValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(JListAnswer);

        JbtnDeleteQues.setText("Xóa");
        JbtnDeleteQues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnDeleteQuesActionPerformed(evt);
            }
        });

        JbtnEditAnswer.setText("Sửa");
        JbtnEditAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEditAnswerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLbDSMonHoc)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JbtnSave)
                                    .addGap(34, 34, 34)
                                    .addComponent(JbtnCancel)
                                    .addGap(40, 40, 40)
                                    .addComponent(jBtOK)
                                    .addGap(201, 201, 201))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JcomListSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLbDSCauHoi)
                                        .addGap(51, 51, 51)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(JbtnAddQues)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JbtnDeleteQues)
                                    .addGap(48, 48, 48)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLbĐoKho)
                                    .addGap(28, 28, 28)
                                    .addComponent(JComboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(JNumChapter, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JbtnAddAnswer)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JbtnEditAnswer)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JbtnDeleteAnswer))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLbHinhThuc)
                                                .addComponent(jLbDebai)
                                                .addComponent(jLbDapAnTN))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(84, 84, 84)
                                                    .addComponent(jLbBarem))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(32, 32, 32)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(JRadioMutiQues)
                                                            .addGap(43, 43, 43)
                                                            .addComponent(JRadioEssayQues))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(0, 12, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLbQuanLiCauHoi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLbQuanLiCauHoi)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLbDSMonHoc)
                            .addComponent(JcomListSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLbHinhThuc)
                                        .addComponent(JRadioMutiQues))
                                    .addGap(3, 3, 3)
                                    .addComponent(jLbDebai)
                                    .addGap(78, 78, 78)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLbDapAnTN)
                                        .addComponent(jLbBarem)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(JRadioEssayQues)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLbDSCauHoi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbtnAddQues)
                            .addComponent(JbtnDeleteQues))
                        .addGap(67, 67, 67)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbtnAddAnswer)
                            .addComponent(JbtnDeleteAnswer)
                            .addComponent(JbtnEditAnswer))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLbĐoKho)
                            .addComponent(JComboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(JNumChapter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JbtnCancel)
                            .addComponent(JbtnSave)
                            .addComponent(jBtOK))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JComboLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JComboLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JComboLevelActionPerformed

    private void JListQuestionValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_JListQuestionValueChanged

        clickBtnAdd = false;
        
        this.indexSelectedQues = this.JListQuestion.getSelectedIndex();
        if(indexSelectedQues >=0) {
            this.selectedQuestion = this.selectedSubject.getQuestionList().get(indexSelectedQues);
        }
//      System.out.println("Selected Question: " + selectedQuestion.getQuestion());
        System.out.println("Selected index: " + indexSelectedQues);
        
        updateQuestionDetail();

    }//GEN-LAST:event_JListQuestionValueChanged

    private void JListAnswerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_JListAnswerValueChanged
       
        indexSelectedAnswer = this.JListAnswer.getSelectedIndex();
        // update chi tiet cau hoi
        int indexQues = indexSelectedQues +1; // Chỉ số câu hỏi bắt đầu từ 1
        String detail = "Câu số " + indexQues + ":\n ------------------------ \n" + selectedQuestion.showDetailQuestion();
        this.JTextAnswerDetail.setText(detail);
       
       
    }//GEN-LAST:event_JListAnswerValueChanged

    private void JcomListSubjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JcomListSubjectItemStateChanged
        // TODO add your handling code here:
        changeSubject = true;
        indexSelectedQues = -1; 
        
        String selectedSubjName;
        if(evt.getStateChange()== ItemEvent.SELECTED) {
            selectedSubjName = (String) this.JcomListSubject.getSelectedItem();
//            System.out.println("selected subject:" + selectedSubjName);
            for(int i=0; i< listSubj.getListSubject().size(); i++) {
                if(selectedSubjName.equalsIgnoreCase(listSubj.getListSubject().get(i).getSubjectName())) {
                    selectedSubject = listSubj.getListSubject().get(i);
                    indexSelectedSubject = i;
                }
            }
            System.out.println("selected subject: " + selectedSubject.getSubjectName());
        }
        updateQuestionList();
        updateChapterList();
        updateQuestionDetail();
        changeSubject = false;
    }//GEN-LAST:event_JcomListSubjectItemStateChanged

    private void JbtnAddQuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAddQuesActionPerformed
        // TODO add your handling code here:
        this.clickBtnAdd = true;
        updateQuestionDetail();
        
        this.JListAnswer.setVisible(true);
        this.JTextAnswerDetail.setVisible(true);
        this.JTextQuesDetail.requestFocus();
    }//GEN-LAST:event_JbtnAddQuesActionPerformed

    private void JbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnSaveActionPerformed
        // TODO add your handling code here:
        
        if(clickBtnAdd) {  // Trường hợp lưu câu hỏi mới
            if(this.JTextQuesDetail.getText().equals("")) {
                JOptionPane.showMessageDialog(null,"Bạn chưa nhập đề bài!");
                return;
            }
            
            if(this.JRadioEssayQues.isSelected()) { // them cau tu luan
                EssayQuestion essay = new EssayQuestion();
                essay.setQuestion(this.JTextQuesDetail.getText());
                essay.setLevel((String) this.JComboLevel.getSelectedItem());
                essay.setChapter((String) this.JNumChapter.getSelectedItem());
                this.selectedSubject.getQuestionList().add(essay);
                // test
                System.out.println("Thêm essay vào selectedSubject");
//                System.out.println("Question List 0: " + selectedSubject.getQuestionList().get(0).getQuestion());
                this.modelQuestion.addElement(essay.getQuestion());
                this.JListQuestion.setModel(this.modelQuestion);
                
//                this.updateQuestionList();
            }
            else { // them cau trac nghiem
                
                // Kiểm tra nhập đáp án chưa?
                if(this.modelAnwer.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập các đáp án");
                    return;
                }
                
                MultipleChoiceQuestion multiQues = new MultipleChoiceQuestion();
                multiQues.setQuestion(this.JTextQuesDetail.getText());
                multiQues.setAnswer(listAnswer);
                // Check true answer
                if(multiQues.getTrueAnswer().equalsIgnoreCase("Chưa có đáp án đúng!")) {
                    JOptionPane.showMessageDialog(null,"Câu hỏi phải có ít nhất 1 đáp án đúng!");
                    return;
                }
                    
//                System.out.println("List Answer: ");
//                for(int i=0; i< listAnswer.size(); i++) {
//                    System.out.println(listAnswer.get(i).getContent());
//                }
                multiQues.setChapter((String) this.JNumChapter.getSelectedItem());
                multiQues.setLevel((String) this.JComboLevel.getSelectedItem());
                
                this.modelQuestion.addElement(multiQues.getQuestion());
                this.JListQuestion.setModel(modelQuestion);
                this.selectedSubject.getQuestionList().add(multiQues);
                System.out.println("MultipleQues: " + this.selectedSubject.getQuestionList().get(0).printQuestion());
//                String answerDetail ="";
//                this.JTextAnswerDetail.setText(answerDetail);
//                this.selectedQuestion = multiQues;
//                this.indexSelectedQues = selectedSubject.getQuestionList().size();
//                int indexQues = indexSelectedQues +1; // Chỉ số câu hỏi bắt đầu từ 1
//                String detail = "Câu số " + indexQues + ": \n ----------------------" + selectedQuestion.printQuestion();
//                this.JTextAnswerDetail.setText(detail);
//                updateQuestionDetail();
            }
            this.clickBtnAdd = false;
            
        }
        
        else if(indexSelectedQues >=0) { // sửa đáp án, luu dap an da sua
            if(selectedQuestion instanceof MultipleChoiceQuestion) {
                //downcasting
                MultipleChoiceQuestion selectedQues = (MultipleChoiceQuestion) selectedQuestion;
                selectedQues.setAnswer(listAnswer);
                // upcasting
                selectedQuestion = selectedQues;
            }
            
            selectedQuestion.setQuestion(this.JTextQuesDetail.getText());
            selectedQuestion.setChapter((String) this.JNumChapter.getSelectedItem());
            selectedQuestion.setLevel((String) this.JComboLevel.getSelectedItem());
            updateQuestionList();
            updateQuestionDetail();
            
        }
        
//        JOptionPane.showMessageDialog(null, "Đã lưu câu hỏi!");
         this.listSubj.getListSubject().remove(indexSelectedSubject);
         this.listSubj.getListSubject().add(indexSelectedSubject, selectedSubject);
         this.listSubj.writeListSubject();
         
                
    }//GEN-LAST:event_JbtnSaveActionPerformed

    private void JbtnAddAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAddAnswerActionPerformed
        // TODO add your handling code here:
        try {
            // OVERLOAD GOI CONTRUCTOR THEM DAP AN
            ThemDapAn themDapAn = new ThemDapAn(this.listAnswer, this.modelAnwer, this.JListAnswer);
            themDapAn.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_JbtnAddAnswerActionPerformed

    private void JbtnDeleteAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnDeleteAnswerActionPerformed
        // TODO add your handling code here:
        if(indexSelectedAnswer <0) {
            JOptionPane.showMessageDialog(null, "Chưa chọn đáp án!");
            return;
        }
        else {
            System.out.println("selected Ans: " + indexSelectedAnswer);
        }
        
        
        int indexTemp = indexSelectedAnswer;
        this.modelAnwer.remove(indexTemp);
        this.JListAnswer.setModel(modelAnwer);
        
        // upcasting
        MultipleChoiceQuestion selectedQues = (MultipleChoiceQuestion) selectedQuestion;
//        System.out.println("selected Mul size:"+ selectedQues.getAnswerList().size());
        
        selectedQues.getAnswerList().remove(indexTemp);
        selectedQuestion = selectedQues;
        
        // update chi tiet cau hoi
        int indexQues = indexSelectedQues +1; // Chỉ số câu hỏi bắt đầu từ 1
        String detail = "Câu số " + indexQues + ":\n ------------------------ \n" + selectedQuestion.showDetailQuestion();
        this.JTextAnswerDetail.setText(detail);
    }//GEN-LAST:event_JbtnDeleteAnswerActionPerformed

    private void JRadioMutiQuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRadioMutiQuesActionPerformed
        // TODO add your handling code here:
        if(clickBtnAdd) {
            this.JbtnEditAnswer.setVisible(true);
            this.JListAnswer.setEnabled(true);
            this.JListAnswer.setVisible(true);
            this.JbtnAddAnswer.setVisible(true);
            this.JbtnDeleteAnswer.setVisible(true);
            this.JRadioEssayQues.setSelected(false);
            this.JRadioMutiQues.setSelected(true);
            this.JTextAnswerDetail.setEnabled(true);
            this.JTextAnswerDetail.setVisible(true);
        }
    }//GEN-LAST:event_JRadioMutiQuesActionPerformed

    private void JRadioEssayQuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRadioEssayQuesActionPerformed
        // TODO add your handling code here:
        if(clickBtnAdd) {
            this.JbtnEditAnswer.setVisible(false);
            this.JTextAnswerDetail.setVisible(false);
            this.JTextAnswerDetail.setEnabled(false);
            this.JRadioEssayQues.setSelected(true);
            this.JRadioMutiQues.setSelected(false);
            this.JListAnswer.setVisible(false);
            this.JListAnswer.setEnabled(false); 
            this.JbtnAddAnswer.setVisible(false);           
            this.JbtnDeleteAnswer.setVisible(false);
        }
    }//GEN-LAST:event_JRadioEssayQuesActionPerformed

    private void JbtnEditAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnEditAnswerActionPerformed
        // TODO add your handling code here:
        if(indexSelectedAnswer <0) {
            JOptionPane.showMessageDialog(null, "Chưa chọn đáp án!");
            return;
        }
        try {
            // OVERLOAD, GỌI CONTRUCTOR SUA DAP AN
            ThemDapAn themDapAn = new ThemDapAn(this.indexSelectedAnswer, listAnswer, this.modelAnwer, this.JListAnswer);
            themDapAn.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_JbtnEditAnswerActionPerformed

    private void JbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnCancelActionPerformed
        // TODO add your handling code here:
        ListSubject listSubjectOld = new ListSubject();
        try {
            listSubjectOld.setListSubject(listSubj.readListSubject());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(QuestionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.selectedSubject = listSubjectOld.getListSubject().get(indexSelectedSubject);
        updateQuestionList();
        updateQuestionDetail();
        JOptionPane.showMessageDialog(null,"Đã khôi phục lại các câu hỏi của môn học!");
                
        
    }//GEN-LAST:event_JbtnCancelActionPerformed

    private void JbtnDeleteQuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnDeleteQuesActionPerformed
        // TODO add your handling code here:
        clickBtnDelete = true;
        
        if(indexSelectedQues == -1 && clickBtnAdd == false) { // Chưa chọn câu nào 
            JOptionPane.showMessageDialog(null, "Chọn câu hỏi để xóa trước!");
           
        }
        else if(clickBtnAdd) { // đang thêm câu hỏi
            JOptionPane.showMessageDialog(null, "Bạn đang chọn chức năng thêm câu hỏi!");
        } else {
            selectedSubject.getQuestionList().remove(indexSelectedQues);
            updateQuestionList();
            indexSelectedQues = -1;
            selectedQuestion = null;
            JOptionPane.showMessageDialog(null, "Đã xóa khỏi danh sách! Bấm lưu để xác nhận!");
        }
        clickBtnDelete = false;
    }//GEN-LAST:event_JbtnDeleteQuesActionPerformed

    private void JcomListSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcomListSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JcomListSubjectActionPerformed

    private void jBtOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtOKActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBtOKActionPerformed

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
            java.util.logging.Logger.getLogger(QuestionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuestionManager().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(QuestionManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboLevel;
    private javax.swing.JList<String> JListAnswer;
    private javax.swing.JList<String> JListQuestion;
    private javax.swing.JComboBox<String> JNumChapter;
    private javax.swing.JRadioButton JRadioEssayQues;
    private javax.swing.JRadioButton JRadioMutiQues;
    private javax.swing.JTextArea JTextAnswerDetail;
    private javax.swing.JTextArea JTextQuesDetail;
    private javax.swing.JButton JbtnAddAnswer;
    private javax.swing.JButton JbtnAddQues;
    private javax.swing.JButton JbtnCancel;
    private javax.swing.JButton JbtnDeleteAnswer;
    private javax.swing.JButton JbtnDeleteQues;
    private javax.swing.JButton JbtnEditAnswer;
    private javax.swing.JButton JbtnSave;
    private javax.swing.JComboBox<String> JcomListSubject;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jBtOK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLbBarem;
    private javax.swing.JLabel jLbDSCauHoi;
    private javax.swing.JLabel jLbDSMonHoc;
    private javax.swing.JLabel jLbDapAnTN;
    private javax.swing.JLabel jLbDebai;
    private javax.swing.JLabel jLbHinhThuc;
    private javax.swing.JLabel jLbQuanLiCauHoi;
    private javax.swing.JLabel jLbĐoKho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
