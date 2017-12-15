/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import class_library.Handler;
import class_library.Gen;
import class_library.Question;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Farouk
 */
public class Exam extends javax.swing.JFrame {

    ArrayList<Question> ques;
    ArrayList< ArrayList<JToggleButton> > chks;
    ArrayList<JToggleButton> curChk;
    ArrayList< ArrayList<Boolean> > cors;
    int curQues = -1;
    
    public Exam() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("your exam is running");
        
        // todostuff
        setContentPane(Gen.examPnl(lbl, scrlQues, scrlOpt, btnValidate, btnSubmit));
    }
    
    public Exam(ArrayList<Question> ques) {
        this();
        
        this.ques = ques;
        chks = new ArrayList<>();
        cors = new ArrayList<>();
        for(Question q : ques)
        {
            ArrayList<JToggleButton> opts = new ArrayList<>();
            ArrayList<Boolean> cor = new ArrayList<>();
            
            Gen.getChk(q, opts, cor);
            
            chks.add( opts );
            cors.add(cor);
        }
        populateQuestions();
    }
    
    ArrayList <JToggleButton> clone(ArrayList <JToggleButton> chk)
    {
        curChk = new ArrayList<>(chks.get(curQues).size());
        for(JToggleButton btn : chks.get(curQues))
        {
            JToggleButton clone = new JToggleButton(btn.getText(), btn.isSelected());
            curChk.add( clone );
        }
        return null;
    }
    
    void populateOptions(){
        lbl.setText(ques.get(curQues).text);
//        curChk = clone(chks.get(curQues));
        curChk = chks.get(curQues);
        JPanel pnl = Gen.getPnl( Gen.cast(curChk) );
        scrlOpt.setViewportView(pnl);
    }
    
    void reCheck(){
        if(curQues == -1) return;
//        chks.set(curQues, valChk);
    }
    
    void populateQuestions(){
        ArrayList <JButton> btns = new ArrayList<>();
        for(int i=0; i<ques.size(); i++)
        {
            JButton btn = new JButton(String.format("Question %d: %s", i+1, ques.get(i).name));
            btns.add(btn);
            
            final int j = i;
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    reCheck();
                    curQues = j;
                    populateOptions();
                }
            });
        }
        
        JPanel pnl = Gen.getPnl( Gen.cast(btns) );
        scrlQues.setViewportView(pnl);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrlOpt = new javax.swing.JScrollPane();
        btnSubmit = new javax.swing.JButton();
        scrlQues = new javax.swing.JScrollPane();
        lbl = new javax.swing.JLabel();
        btnValidate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrlOpt.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        btnSubmit.setText("submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        scrlQues.setBorder(javax.swing.BorderFactory.createTitledBorder("Questions"));

        lbl.setText("choose question to proceed");

        btnValidate.setText("validate");
        btnValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrlOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnValidate)
                        .addGap(87, 87, 87))))
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(btnSubmit)
                .addGap(0, 251, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(scrlQues, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(352, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl)
                .addGap(18, 18, 18)
                .addComponent(scrlOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnValidate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrlQues, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(144, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        double score = 0;
        String res = String.format("your score is: %.2f%%", score);
        Handler.not(res);
        //dispose();
        btnValidate.setEnabled(false);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidateActionPerformed
        
        if(curQues == -1){
            Handler.err("choose a question first\ncheck the correct answer(s)\nthen press validate to save your answer(s)");
            return;
        }
        
        ArrayList <Boolean> isCor = cors.get(curQues);
        ArrayList <JToggleButton> chk = chks.get(curQues);
        Question q = ques.get(curQues);
        
//        chks.set(curQues, curChk);
    }//GEN-LAST:event_btnValidateActionPerformed

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
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnValidate;
    private javax.swing.JLabel lbl;
    private javax.swing.JScrollPane scrlOpt;
    private javax.swing.JScrollPane scrlQues;
    // End of variables declaration//GEN-END:variables
}
