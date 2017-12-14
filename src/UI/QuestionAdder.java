package UI;

import class_library.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class QuestionAdder extends javax.swing.JFrame {
    
    // options variables
    ArrayList<JTextField> txtOpt = new ArrayList();
    ArrayList<JCheckBox> chkOpt = new ArrayList();
    ArrayList<JButton> btnOpt = new ArrayList();
    
    void updateOptions(){
        
        ArrayList<JLabel> lblOpt = new ArrayList<>();
        for(int i=0; i<txtOpt.size(); i++){
            lblOpt.add(new JLabel("opt" + (i+1)));
        }
        
        JPanel pnl = PanelGen.getPnl(PanelGen.cast(lblOpt), PanelGen.cast(txtOpt),
                                     PanelGen.cast(chkOpt), PanelGen.cast(btnOpt));
        
        scrl.setViewportView(pnl);
    }
    
    public QuestionAdder() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // add two default options
        btnAddOptActionPerformed(null);
        btnAddOptActionPerformed(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMark = new javax.swing.JTextField();
        txtDiff = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAddOpt = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtType = new javax.swing.JTextField();
        txtText = new javax.swing.JTextField();
        scrl = new javax.swing.JScrollPane();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAddQues = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QName:");

        jLabel6.setText("QDifficulty:");

        btnAddOpt.setText("add an option");
        btnAddOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOptActionPerformed(evt);
            }
        });

        jLabel8.setText("QType:");

        scrl.setBorder(javax.swing.BorderFactory.createTitledBorder("options"));

        jLabel9.setText("QMark:");

        jLabel10.setText("QText:");

        btnAddQues.setText("add the question");
        btnAddQues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuesActionPerformed(evt);
            }
        });

        jLabel2.setText("(check the correct answers, don't add the suffix '(T)' )");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtName))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiff, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                            .addComponent(txtType)
                            .addComponent(txtMark)
                            .addComponent(txtText)))
                    .addComponent(scrl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddOpt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddQues)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddQues))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrl, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOptActionPerformed
        txtOpt.add(new JTextField());
        chkOpt.add(new JCheckBox());
        final JButton btn = new JButton("X");
        btnOpt.add(btn);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteOption(btn);
            }
        });
        
        updateOptions();
    }//GEN-LAST:event_btnAddOptActionPerformed

    private void btnAddQuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuesActionPerformed
        
        Question q = new Question();
        
        if(!q.setName(txtName.getText()))
        {
            Handler.err("QName must not be empty");
            return;
        }
        
        if(!q.setText(txtText.getText()))
        {
            Handler.err("QText must not be empty");
            return;
        }
        
        Integer diff = Handler.readInt(txtDiff.getText(), "QDifficulty");
        if(diff == null) return;
        if(!q.setDiff(diff))
        {
            Handler.err("QDifficulty must have one of the values {1, 2, 3}\n1 for easy, 2 for medium, 3 for hard");
            return;
        }
        
        Integer type = Handler.readInt(txtType.getText(), "QType");
        if(type == null) return;
        if(!q.setType(type))
        {
            Handler.err("QType must have one of the values {1, 2}\n1 for single answer, 2 for multiple answer");
            return;
        }
        
        Integer mark = Handler.readInt(txtMark.getText(), "QMark");
        if(mark == null) return;
        if(!q.setMark(mark))
        {
            Handler.err("QMark must be a positive integer\n(not necessarily less than 100)");
            return;
        }
        
        // handling options
        ArrayList<String> opt = new ArrayList();
        ArrayList<Boolean> isCor = new ArrayList();
        int corrCount = 0;
        for(int i=0; i<txtOpt.size(); i++){
            opt.add( txtOpt.get(i).getText() );
            isCor.add( chkOpt.get(i).isSelected() );
            corrCount += isCor.get(i)? 1 : 0;
        }
        
        if(!q.setOptions(opt, isCor))
        {
            Handler.err("options must not be empty");
            return;
        }
        
        if(txtOpt.size() < 2)
        {
            Handler.err("you have to add at least two options");
            return;
        }

        if(type == Question.SINGLE && corrCount != 1)
        {
            Handler.err("there should be exactly one correct answer for this question");
            return;
        }
        
        IO.writeQuestion(q);
        Handler.not("question added successfuly");
        dispose();
    }//GEN-LAST:event_btnAddQuesActionPerformed

    void deleteOption(JButton btn){
        int idx = btnOpt.indexOf(btn);
        txtOpt.remove(idx);
        chkOpt.remove(idx);
        btnOpt.remove(idx);
        
        updateOptions();
    }
    
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
            java.util.logging.Logger.getLogger(QuestionAdder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuestionAdder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuestionAdder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuestionAdder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionAdder().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOpt;
    private javax.swing.JButton btnAddQues;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane scrl;
    private javax.swing.JTextField txtDiff;
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtText;
    private javax.swing.JTextField txtType;
    // End of variables declaration//GEN-END:variables
}
