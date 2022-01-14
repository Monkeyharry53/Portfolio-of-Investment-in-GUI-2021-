package ePortfolio;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This is my getGain class Which contains  gui for getgain Page
 */
public class getGain {
    JTextArea getgainDisplay = new JTextArea(10,20);
    JTextField totalGain = new JTextField();
    /**
     * This method in used to make Jpanel for get Gain JMenuItem
     * This method returns the getGainPanel
     * @return JPanel
     */
    public JPanel connect(){
        JPanel getgainPanel =  new JPanel();                                 //Creating a search panel
        getgainPanel.setLayout(new BorderLayout());//Creating a search panel
        JPanel topGetgain = new JPanel(new FlowLayout(FlowLayout.LEFT)); // using flow layout to swift everything to left
        JPanel leftGetgain = new JPanel(new GridLayout(2,1));
        //JPanel rightUpdate = new JPanel(new GridLayout(3,1));
        JPanel bottomGetgain  = new JPanel(new GridLayout(2,1));
        
        JLabel getgainText = new JLabel("Getting total gain");
        //Creating all the JField's
        leftGetgain.add(getgainText);
        
        
        leftGetgain.add(new JLabel());
 
       
        leftGetgain.add(new JLabel("Total gain"));
        leftGetgain.add(totalGain);

        
        topGetgain.add(leftGetgain);
        
        //Making a TextArea for the results and the error's
        JLabel msgGg = new JLabel("Individual gains");
        JScrollPane scrollGg = new JScrollPane(getgainDisplay);
        scrollGg.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollGg.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bottomGetgain.add(msgGg);
        bottomGetgain.add(scrollGg);
        
        getgainPanel.add(bottomGetgain,BorderLayout.CENTER);
        
        getgainPanel.add(topGetgain,BorderLayout.NORTH);
        return getgainPanel;  // returning the searchPanel
    }
    
}
