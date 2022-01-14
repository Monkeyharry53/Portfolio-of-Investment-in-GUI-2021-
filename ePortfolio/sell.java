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
 * This is my Sell class Which contains  gui for Sell Page
 */
public class sell {
    /**
     * This method in used to make Jpanel for sell JMenuItem
     * This method returns the sellPanel
     * @return JPanel
     */
    public JPanel connect(){
        portfolio portal =  new portfolio();
        JPanel sellPanel =  new JPanel();//Creating a search panel
        sellPanel.setLayout(new BorderLayout());//Setting layout
        JPanel topSell = new JPanel(new FlowLayout(FlowLayout.LEFT));// using flow layout to swift everything to left
        JPanel leftSell = new JPanel(new GridLayout(4,1));
        JPanel rightSell = new JPanel(new GridLayout(2,1));
        JPanel bottomSell = new JPanel(new GridLayout(2,1));
        
        
        JLabel sellText = new JLabel("Selling an investment");
        leftSell.add(sellText);
        
        
        JTextField sellSymbol = new JTextField(5);
        JTextField sellPrice = new JTextField(5);
        JTextField sellQuantity = new JTextField(5);
        leftSell.add(new JLabel());
        //Creating all the JField's
        leftSell.add(new JLabel("symbol"));
        leftSell.add(sellSymbol);
        
        leftSell.add(new JLabel("price"));
        leftSell.add(sellPrice);
        
        leftSell.add(new JLabel("quantity"));
        leftSell.add(sellQuantity);
        
        //Adding Fields in LeftSearch panel alomg eith there  JLabel
        topSell.add(leftSell);

        //Making a TextArea for the results and the error's
        JTextArea sellDisplay = new JTextArea(10,20);
        JLabel msgS = new JLabel("message");
        JScrollPane scrollS = new JScrollPane(sellDisplay);
        scrollS.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollS.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bottomSell.add(msgS);
        bottomSell.add(scrollS);
        sellPanel.add(bottomSell,BorderLayout.CENTER);
        
                
        JButton sellReset = new JButton("Reset");// resetbutton
        sellReset.addActionListener((ActionEvent e) ->{
            sellSymbol.setText("");
            sellPrice.setText("");  
            sellQuantity.setText("");
            sellDisplay.setText("");
            
        });
        JButton sellButton = new JButton("Sell");  // sell button
        sellButton.addActionListener((ActionEvent e) ->{
            
            String tempSymbol = sellSymbol.getText();
            String tempPrice = sellPrice.getText();
            String tempQuantity = sellQuantity.getText();
        
            if(tempPrice.isBlank()){                //if price is null
                sellDisplay.setText("ERROR: Price can not be empty");
                return;
            }
            if(tempQuantity.isBlank()){       //if quantity is null
                sellDisplay.setText("ERROR: quantity can not be empty");
                return;
            }
    
            if(!portal.toequals(tempSymbol)){         
                sellDisplay.setText("Investment of such Symbol doesn't exist. Try Again");
            }
           


            try {                   //try catch to check is quantity is not string
                Integer.parseInt(tempQuantity); 
            } catch(NumberFormatException a) { 
                sellDisplay.setText("ERROR: quantity can not be String(must be an integer)"); 
            }
            try {                        //try catch to check is price is not string
                Double.parseDouble(tempPrice); 
            } catch(NumberFormatException a) { 
                sellDisplay.setText("ERROR: Price can not be String(must be an integer/double)"); 
            }
            
            int Iquantity = Integer.parseInt(tempQuantity);
            double Iprice = Double.parseDouble(tempPrice);
 
            double pay = portal.payment(tempSymbol, Iprice, Iquantity);
            try {           
                portal.payment(tempSymbol, Iprice, Iquantity);
            } catch (Exception e1) {
                sellDisplay.setText(e1.getMessage());
                e1.printStackTrace();
                return;
            } 
            if (pay == -1)
            {
                sellDisplay.setText("Wrong input");
            }
            else if(pay == -2)
            {
                sellDisplay.setText("Not enough quantity present. Try less quantity\n");
            }
            else{
                sellDisplay.setText("Information Saved.\nPayment of  "+tempSymbol +" = " + pay + "\n");
            }
                    


        });
        rightSell.add(sellReset);
        rightSell.add(sellButton);
        topSell.add(rightSell);

        sellPanel.add(topSell,BorderLayout.NORTH);
        return sellPanel;   //returns sell panel

    }
    
}
