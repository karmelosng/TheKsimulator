/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karmelos.ksimulator.jdialogs;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ables
 */
public class YesNoOption  extends JDialog{
JPanel  panel1;
JPanel panel2;
JButton yesButton;
JButton noButton;
JLabel label;
private String label1;
boolean close;
int one;
ImageIcon icon = new ImageIcon(getClass().getResource("/com/karmelos/ksimulator/2ndbaricon/kicon.png"));
    public YesNoOption(Frame owner, String title) {
        super(owner, title);
        //initialize components
   
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }
    
    class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
        if(event.getActionCommand().equals("YES")){
        one = 1;
            
        YesNoOption.this.dispose();
        }
        else{
        one = 0;
        YesNoOption.this.dispose();
        }
        }
    
    }
//    public static void main(String[] args) {
//        new CloseWindowDialog(null, null);
//    }
    public boolean showDialog(){
    
             panel1 = new JPanel();
        panel2 = new JPanel();
        
        label = new JLabel(getLabel1());
        panel1.add(label);
        
        //instantiates handler
        ButtonHandler handler = new ButtonHandler();
        //creating yesButton
        yesButton = new JButton("YES");
        yesButton.addActionListener(handler);
        
        //creating noButton;
        noButton = new JButton("NO");
        
        noButton.addActionListener(handler);
        
        panel2.add(yesButton);
        panel2.add(noButton);
        //add panels to jdialog
        add(panel1);
        add(panel2,BorderLayout.SOUTH);
                
        setSize(300, 130);
        setModal(true);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        setVisible(true);
        
        if(one == 1){
        close = true;
        }
        else{
        close = false;
        }
        return close;
    }
}
