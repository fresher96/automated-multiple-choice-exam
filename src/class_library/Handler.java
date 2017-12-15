/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package class_library;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Farouk
 */
public class Handler {
    
    private Handler(){
        
    }
    
    public static void err(String txt){
        JOptionPane.showMessageDialog(null, txt, "Input Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void not(String txt){
        JOptionPane.showMessageDialog(null, txt, "notification", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void exc(Exception e){
        
        String message = "oops! this shouldn't happen.\n";
        message += "please call the support staff and notify them about this bug.\n";
        message += "take notes of what caused this bug so that they can resolve the problem.\n";
        message += "sorry for any inconvenience.\n";
        
        message += "\nexception message:\n";
        message += e.getMessage();
        
        JOptionPane.showMessageDialog(null, message, "Exception thrown", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    
    public static void debug(Object obj){
        JOptionPane.showMessageDialog(null, "\"" + obj.toString() + "\"");
    }
    
    public static Integer readInt(String input, String name){
        try{
            return Integer.parseInt(input);
        }
        catch(Exception ex){
            err(name + " must hold an integer value");
            return null;
        }
    }
    
}
