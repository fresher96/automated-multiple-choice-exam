/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package class_library;

/**
 *
 * @author Farouk
 */
public class Question {
//    static final int EASY = 1, MEDIUM = 2, HARD = 3;
    public static final int SINGLE = 1, MULTIPLE = 2;
    
    String name, text;
    int diff, type, mark;
    String[] opt;
    boolean[] isCor;
    
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
    public boolean setOptions(String[] opt, boolean[] isCor){
        
        assert(opt.length == isCor.length);
        
        for(int i=0; i<opt.length; i++)
        {
            if(opt[i].equals("")){
                return false;
            }
        }
        
        this.opt = opt;
        this.isCor = isCor;
        return true;
    }
}
