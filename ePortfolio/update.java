package ePortfolio;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;

/**
 * This is my Update class Which contains  gui for Upadte Page
 */
public class update {
    portfolio portal =  new portfolio();
    JTextField updateSymbol;
    JTextField updateName;
    
    ArrayList<Investment> list; 
    Investment currInvestment;
    JTextArea updateDisplay = new JTextArea(10,20);
    int currInvestmentIndex = 0;
    JButton updatePrev = new JButton("Prev");
    JButton updateNext= new JButton("Next");
    /**
    * This method in used to make Jpanel for update JMenuItem
    * This method returns the updatePanel
    * @return JPanel
    */
    public JPanel connect(){
        JPanel updatePanel =  new JPanel();//Creating a update panel
        updatePanel.setLayout(new BorderLayout());//Creating a search panel
        JPanel topUpdate = new JPanel(new FlowLayout(FlowLayout.LEFT));// using flow layout to swift everything to left
        JPanel leftUpdate = new JPanel(new GridLayout(4,1));
        JPanel rightUpdate = new JPanel(new GridLayout(3,1));
        JPanel bottomUpdate  = new JPanel(new GridLayout(2,1));
    
        list=portal.getList();
        //Creating all the JField's
        updateSymbol = new JTextField(5);        
        updateName = new JTextField(5);
        if (list.size() > 0) {
            currInvestment = list.get(0);
  
        }
        JLabel updateText = new JLabel("updating investment");
        leftUpdate.add(updateText);
        
        
        updateSymbol.setEditable(false);
        updateName.setEditable(false);
        JTextField updatePrice = new JTextField(5);
        leftUpdate.add(new JLabel());

      
        leftUpdate.add(new JLabel("symbol"));

        leftUpdate.add(updateSymbol);
        
        leftUpdate.add(new JLabel("name"));
        leftUpdate.add(updateName);
        
        leftUpdate.add(new JLabel("price"));
        leftUpdate.add(updatePrice);
        
        topUpdate.add(leftUpdate);
        //Making a TextArea for the results and the error's
        JLabel msgUp = new JLabel("message");
        JScrollPane scrollUp = new JScrollPane(updateDisplay);
        scrollUp.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollUp.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bottomUpdate.add(msgUp);
        bottomUpdate.add(scrollUp);
        updatePanel.add(bottomUpdate,BorderLayout.CENTER);
        
        // Setting the Action Listeners for all the buttons(next,prev and save)
        
        updatePrev.addActionListener((ActionEvent e) ->{
            if(currInvestmentIndex <= 0){                               //if it is 1st investment
                updateDisplay.setText("This is first Investment So there can be no Previous ");
                updatePrev.setEnabled(false);
            }
            else{
                updateNext.setEnabled(true);
                updatePrev.setEnabled(true);
                getPrev();    
            }
        });
        
        updateNext.addActionListener((ActionEvent e) ->{
            if(currInvestmentIndex >= (list.size())-1){             //if it is last investment
                updateDisplay.setText("This is Last Investment So there can be no Next ");
                updateNext.setEnabled(false);
            }
            else{
                updateNext.setEnabled(true);
                updatePrev.setEnabled(true);
                getNext();
            }
        });
        
        JButton updateSave = new JButton("Save");
        updateSave.addActionListener((ActionEvent e) ->{
            
            String SupdatePrice = updatePrice.getText();
            if(SupdatePrice.isBlank()){
                updateDisplay.setText("ERROR: Price can not be empty");
                return;
            }
            try { 
                Integer.parseInt(SupdatePrice); 
            } catch(NumberFormatException a) { 
                updateDisplay.setText("ERROR: quantity can not be String(must be an integer)"); 
            }
            portal.updateVal(SupdatePrice,currInvestmentIndex);
            String a = portal.print();
            updateDisplay.setText(a);
        


        });
        
        rightUpdate.add(updatePrev);
        rightUpdate.add(updateNext);
        rightUpdate.add(updateSave);
        topUpdate.add(rightUpdate);

        updatePanel.add(topUpdate,BorderLayout.NORTH);
        return updatePanel;   // returning update panel
    }
    /**
     * using this method for next button to function
     * it increments the index used in getting next arraylist
     */
    private void getNext() {
        list=portal.getList();       // getList is used to get the ArrayList from Portfolio
        currInvestmentIndex++;       //incrementing curent index
        currInvestment = list.get(currInvestmentIndex);
        updateSymbol.setText(currInvestment.symbol);   // displaying current Symbol
        updateName.setText(currInvestment.name);       // displaying Current Name
    }
    /**
     * using this method for prev button to function
     * it decrements the index used in getting prev arraylist
     */
    private void getPrev() {
        list=portal.getList();          // getList is used to get the ArrayList from Portfolio
        currInvestmentIndex--;           //degrementing curent index
        currInvestment = list.get(currInvestmentIndex);
        updateSymbol.setText(currInvestment.symbol);    // displaying current Symbol
        updateName.setText(currInvestment.name);       // displaying Current Name
    }
    
}
