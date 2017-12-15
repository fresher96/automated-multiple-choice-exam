/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package class_library;

import java.util.ArrayList;

/**
 *
 * @author Farouk
 */
public class Question {
    
    static final int EASY = 1, MEDIUM = 2, HARD = 3;
    public static final int SINGLE = 1, MULTIPLE = 2;
    
    public String name, text;
    public int diff, type, mark;
    public ArrayList<String> opt;
    public ArrayList<Boolean> isCor;
    
    public boolean setOptions(ArrayList<String> opt, ArrayList<Boolean> isCor){
        
        assert(opt.size() == isCor.size());
        
        for(int i=0; i<opt.size(); i++)
        {
            if(opt.get(i).equals("")){
                return false;
            }
        }
        
        this.opt = opt;
        this.isCor = isCor;
        return true;
    }
    
    public boolean setName(String name){
        if(name.equals("")) {
            return false;
        }
        
        this.name = name;
        return true;
    }
    public boolean setText(String text){
        if(text.equals("")) {
            return false;
        }
        
        this.text = text;
        return true;
    }
    public boolean setDiff(int diff){
        if( !(1 <= diff && diff <= 3) ) {
            return false;
        }
        
        this.diff = diff;
        return true;
    }
    public boolean setType(int type){
        if( !(1 <= type && type <= 2) ) {
            return false;
        }
        
        this.type = type;
        return true;
    }
    public boolean setMark(int mark){
        if(mark <= 0) {
            return false;
        }
        
        // note that mark can be > 100
        this.mark = mark;
        return true;
    }
    
}
