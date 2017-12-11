/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package class_library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Farouk
 */
public class IO {
    
    private static String fileName = "src\\database\\question_bank";
    
    private void IO(){
        
    }
    
    public static void writeQuestion(Question q){
        try(PrintStream ps = new PrintStream( new FileOutputStream(fileName, true) ) )
        {
            ps.println("QName: " + q.name);
            ps.println("QDifficulty: " + q.diff);
            ps.println("QType: " + q.type);
            ps.println("QMark: " + q.mark);
            ps.println("QText: " + q.text);
            
            for(int i=0; i<q.opt.length; i++)
            {
                String opt = q.opt[i];
                opt += q.isCor[i]? " (T)" : "";
                ps.println("QOption: " + opt);
            }
            
            ps.println("%%");
        }
        catch(Exception e) {
            Handler.exc(e);
        }
    }
}
