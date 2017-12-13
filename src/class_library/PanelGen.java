/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package class_library;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 *
 * @author Farouk
 */
public class PanelGen {
    
    private PanelGen(){
        
    }
    
    public static JPanel getPnl(ArrayList<Component>... params){
        
        Box ver = Box.createVerticalBox();
        JPanel pnl = new JPanel();
        pnl.setLayout(new BorderLayout());
        pnl.add(ver, BorderLayout.NORTH);
        
        int length = params[0].size();
        for(int i=0; i<length; i++)
        {
            Box hor = Box.createHorizontalBox();
            for(ArrayList<Component> al : params)
            {
                hor.add(al.get(i));
            }
            hor.add(Box.createHorizontalGlue());
            ver.add(hor);
        }
        
        return pnl;
    }
    
    public static JPanel getPnl(Question q, ArrayList<JToggleButton> chk){
        
        // shuffling options
        ArrayList<Integer> idx = new ArrayList<>();
        for(int i=0; i<q.opt.size(); i++) {
            idx.add(i);
        }
        Collections.shuffle(idx);
        
        
        ButtonGroup grp = new ButtonGroup();
        for(int j=0; j<idx.size(); j++)
        {
            int i = idx.get(j);
            
            JToggleButton btn;
            if(q.type == 1){
                btn = new JRadioButton();
                grp.add(btn);
            }
            else{
                btn = new JCheckBox();
            }
            btn.setText(q.opt.get(i));
            
            chk.add(btn);
        }
        
        return getPnl( cast(chk) );
    }
    
    public static <T extends Component> ArrayList<Component> cast(ArrayList<T> lst){
        ArrayList<Component> ret = new ArrayList<>();
        for(T t : lst){
            ret.add(t);
        }
        return ret;
    }
}
