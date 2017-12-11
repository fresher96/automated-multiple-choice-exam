/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package class_library;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
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
        try( PrintStream ps = new PrintStream( new FileOutputStream(fileName, true) ) )
        {
            ps.println("QName: " + q.name);
            ps.println("QDifficulty: " + q.diff);
            ps.println("QType: " + q.type);
            ps.println("QMark: " + q.mark);
            ps.println("QText: " + q.text);
            
            for(int i=0; i<q.opt.size(); i++)
            {
                String opt = q.opt.get(i);
                opt += q.isCor.get(i)? " (T)" : "";
                ps.println("QOption: " + opt);
            }
            
            ps.println("%%");
        }
        catch(Exception e) {
            Handler.exc(e);
        }
    }
    
    private static Question readNextQuestion(DataInputStream input) throws IOException{
        Question q = new Question();
        String line;
        
        line = input.readLine();
        line = line.replaceFirst("QName:", "").trim();
        q.name = line;
        
        line = input.readLine();
        line = line.replaceFirst("QDifficulty:", "").trim();
        q.diff = Integer.parseInt(line);
        
        line = input.readLine();
        line = line.replaceFirst("QType:", "").trim();
        q.type = Integer.parseInt(line);
        
        line = input.readLine();
        line = line.replaceFirst("QMark:", "").trim();
        q.mark = Integer.parseInt(line);
        
        line = input.readLine();
        line = line.replaceFirst("QText:", "").trim();
        q.text = line;
        
        ArrayList<String> opt = new ArrayList();
        ArrayList<Boolean> isCor = new ArrayList();
        while(true)
        {
            line = input.readLine();
            if(line.equals("%%")) break;
            line = line.replaceFirst("QOption:", "").trim();
            
            boolean b = false;
            if(line.endsWith("(T)")){
                b = true;
                line = line.substring(0, line.length()-3);
                line = line.trim();
            }
            
            opt.add(line);
            isCor.add(b);
        }
        q.opt = opt;
        q.isCor = isCor;
        
        return q;
    }
    
    public static ArrayList<Question> readQuestions(int difficulty){
        
        try( DataInputStream input = new DataInputStream( new FileInputStream(fileName) ) )
        {
            ArrayList<Question> list = new ArrayList();
            while(input.available() > 0)
            {
                Question q = readNextQuestion(input);
                if(q.diff != difficulty && difficulty != -1) continue;
                list.add(q);
            }
            return list;
        }
        catch(Exception e) {
            Handler.exc(e);
            return null;
        }
    }
    
    public static Question readLastQuestion(){
        ArrayList<Question> list = readQuestions(-1);
        if(list.isEmpty()) return null;
        return list.get(list.size()-1);
    }
    
}
