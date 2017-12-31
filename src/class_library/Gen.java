/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package class_library;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

/**
 *
 * @author Farouk
 */
public class Gen {

    private Gen(){
        
    }
    
    private static void addCentered(Box tmph, Component cpt) {
        tmph.add(Box.createHorizontalGlue());
        tmph.add(cpt);
        tmph.add(Box.createHorizontalGlue());
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
    
    public static <T extends Component> ArrayList<Component> cast(ArrayList<T> lst){
        ArrayList<Component> ret = new ArrayList<>(lst.size());
        for(T t : lst){
            ret.add(t);
        }
        return ret;
    }
    
    public static JPanel examPnl(JLabel lbl, JScrollPane scrlQues, JScrollPane scrlOpt,
                                 JButton btnValidate, JButton btnSubmit, JLabel lblScr, JLabel lblHint) {
        
        // create options stuff
        Box tmpv = Box.createVerticalBox();
        Box tmph;
        
        tmph = Box.createHorizontalBox();
        addCentered(tmph, lbl);
        tmpv.add(tmph);
        
        tmpv.add(scrlOpt);
        
        tmph = Box.createHorizontalBox();
        addCentered(tmph, btnValidate);
        tmpv.add(tmph);
        // end
        
        // creating the whole panel
        Box ver = Box.createVerticalBox();
        Box hor;
        
        hor = Box.createHorizontalBox();
        hor.add(scrlQues);
        hor.add(tmpv);
        ver.add(hor);
        
        hor = Box.createHorizontalBox();
        addCentered(hor, btnSubmit);
        ver.add(Box.createVerticalStrut(25));
        ver.add(hor);
        
        hor = Box.createHorizontalBox();
        addCentered(hor, lblScr);
        ver.add(hor);
        
        hor = Box.createHorizontalBox();
        addCentered(hor, lblHint);
        ver.add(hor);
        ver.add(Box.createVerticalStrut(10));
        // end
        
        JPanel pnl = new JPanel();
        pnl.setLayout(new BorderLayout());
        pnl.add(ver, BorderLayout.CENTER);
        return pnl;
    }
    
    
    public static void group(ArrayList<JToggleButton> chk){
        ButtonGroup grp = new ButtonGroup();
        for(JToggleButton btn : chk){
            grp.add(btn);
        }
    }
    
    public static void createOptions(Question q, ArrayList<JToggleButton> chk, ArrayList<Boolean> isCor){
        
        // shuffling options
        ArrayList<Integer> idx = new ArrayList<>(q.opt.size());
        for(int i=0; i<q.opt.size(); i++) {
            idx.add(i);
        }
        Collections.shuffle(idx);
        
        
        boolean isRadio = q.type == Question.SINGLE;
        for(int j=0; j<idx.size(); j++)
        {
            int i = idx.get(j);
            
            JToggleButton btn = isRadio? new JRadioButton() : new JCheckBox();
            btn.setText(q.opt.get(i));
            
            chk.add(btn);
            isCor.add(q.isCor.get(i));
        }
        
        if(isRadio) {
            group(chk);
        }
    }
    
    public static ArrayList <JToggleButton> clone(ArrayList <JToggleButton> chk){
        
        ArrayList <JToggleButton> ret = new ArrayList<>(chk.size());
        boolean isRadio = chk.get(0) instanceof JRadioButton;
        
        for(JToggleButton btn : chk)
        {
            JToggleButton clone = isRadio? new JRadioButton() : new JCheckBox();
            
            clone.setText(btn.getText());
            clone.setSelected(btn.isSelected());
            clone.setEnabled(btn.isEnabled());
            
            ret.add( clone );
        }
        
        if(isRadio){
            group(ret);
        }
        
        return ret;
    }
    
}
