/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import class_library.Gen;
import class_library.Handler;
import class_library.Question;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
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
    ArrayList <JButton> btns;
    int curQues = -1;
    
    public Exam(){
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("your exam is running");
        setSize(800, 550);
        
        setContentPane(Gen.examPnl(lbl, scrlQues, scrlOpt, btnValidate, btnSubmit, lblScr, lblHint));
    }
    
    public Exam(ArrayList<Question> ques){
        this();
        
        this.ques = ques;
        chks = new ArrayList<>(ques.size());
        cors = new ArrayList<>(ques.size());
        for(Question q : ques)
        {
            ArrayList<JToggleButton> opts = new ArrayList<>(q.opt.size());
            ArrayList<Boolean> cor = new ArrayList<>(q.opt.size());
            
            Gen.createOptions(q, opts, cor);
            
            chks.add( opts );
            cors.add( cor );
        }
        populateQuestions();
    }
    
    void populateOptions(){
        lbl.setText(ques.get(curQues).text);
        curChk = Gen.clone( chks.get(curQues) );
        JPanel pnl = Gen.getPnl( Gen.cast(curChk) );
        scrlOpt.setViewportView(pnl);
    }
    
    void populateQuestions(){
        
        btns = new ArrayList<>(ques.size());
        for(int i=0; i<ques.size(); i++)
        {
            JButton btn = new JButton(String.format("Question %d: %s", i+1, ques.get(i).name));
            btns.add(btn);
            
            final int j = i;
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
        lblScr = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrlOpt.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        btnSubmit.setText("submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        scrlQues.setBorder(javax.swing.BorderFactory.createTitledBorder("Questions"));

        lbl.setText("choose a question to proceed");

        btnValidate.setText("validate");
        btnValidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidateActionPerformed(evt);
            }
        });

        lblScr.setText("submit to see your score, note that once you submit you can't change your answers");

        lblHint.setText("repress a question to see the last validated answer(s) you chose");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addGap(261, 261, 261))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(lblScr))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(lblHint)))
                .addGap(0, 103, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(scrlQues, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(414, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl)
                .addGap(18, 18, 18)
                .addComponent(scrlOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnValidate)
                .addGap(5, 5, 5)
                .addComponent(btnSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblScr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHint)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrlQues, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(116, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        
        double totMark = 0;
        for(Question q : ques){
            totMark += q.mark;
        }
        
        double totScr = 0;
        for(int i=0; i<ques.size(); i++)
        {
            Question q = ques.get(i);
            ArrayList<JToggleButton> chk = chks.get(i);
            ArrayList<Boolean> isCor = cors.get(i);
            
            int corCnt = 0;
            for(Boolean b : isCor){
                corCnt += b? 1 : 0;
            }
            
            double mark = 100*q.mark/totMark;
            double choiceMark = mark/corCnt;
            
            double quesScr = 0;
            for(int j=0; j<chk.size(); j++){
                if(!chk.get(j).isSelected()) continue;
                
                int sign = isCor.get(j)? +1 : -1;
                quesScr += sign * choiceMark;
            }
            
            
            // if q.type == Question.MULTIPLE then we are done
            if(q.type == Question.SINGLE){
                quesScr = Math.max(quesScr, 0);
            }
            
            totScr += quesScr;
        }
        
        totScr = Math.max(totScr, 0);
        lblScr.setText( String.format("your score is: %.2f%%", totScr) );
        
        disableAll();
    }//GEN-LAST:event_btnSubmitActionPerformed

    void disableAll(){
        
        btnValidate.setEnabled(false);
        btnSubmit.setEnabled(false);
        
        for(ArrayList<JToggleButton> arr : chks){
            for(JToggleButton btn : arr){
                btn.setEnabled(false);
            }
        }
        
        populateOptions();
    }
    
    private void btnValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidateActionPerformed
        
        if(curQues == -1){
            Handler.err("choose a question first\ncheck the correct answer(s)\nthen press validate to save your answer(s)");
            return;
        }
        
        chks.set( curQues, Gen.clone(curChk) );
        
        
        if(btns.get(curQues).getBackground() != Color.GREEN)
            btns.get(curQues).setBackground(Color.GREEN);
        else
            Handler.not("your answer(s) are saved");
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
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblScr;
    private javax.swing.JScrollPane scrlOpt;
    private javax.swing.JScrollPane scrlQues;
    // End of variables declaration//GEN-END:variables
}
