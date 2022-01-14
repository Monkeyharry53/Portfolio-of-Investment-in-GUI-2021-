
package ePortfolio;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class buy {
    /**
     * This method in used to make Jpanel for buy JMenuItem
     * This method returns the buyPanel
     * @return JPanel
     */
    public JPanel connect(){
        portfolio portal =  new portfolio();

        JPanel buyPanel =  new JPanel();//Creating a search panel
        buyPanel.setLayout(new BorderLayout());//Setting layout
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));// using flow layout to swift everything to left
        JPanel left = new JPanel(new GridLayout(6,1));
        JPanel right = new JPanel(new GridLayout(2,1));
        JPanel bottom = new JPanel(new GridLayout(2,1));
        
        
        JLabel buyText = new JLabel("Buying an investment");
        left.add(buyText);
        JComboBox<String> typeInv;       
        String[] types = { "stock", "mutual fund"};
        typeInv = new JComboBox<>(types);
        typeInv.setSelectedIndex(0);
        JTextField symbol = new JTextField(5);
        JTextField name = new JTextField(5);
        JTextField price = new JTextField(5);
        JTextField quantity = new JTextField(5);
        left.add(new JLabel());

        //Creating all the JField's
    
        left.add(new JLabel("type"));
        left.add(typeInv);
    
        left.add(new JLabel("symbol"));
        left.add(symbol);
    
        left.add(new JLabel("name"));
        left.add(name);
    
        left.add(new JLabel("price"));
        left.add(price);
    
        left.add(new JLabel("quantity"));
        left.add(quantity);
        
    
        top.add(left);//Now adding Left page in topSearch
        //Making a TextArea for the results and the error's
        JTextArea msgDisplay = new JTextArea(10,20);
        JLabel msg = new JLabel("message");
        JScrollPane scroll = new JScrollPane(msgDisplay);
        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bottom.add(msg);
        bottom.add(scroll);
        buyPanel.add(bottom,BorderLayout.CENTER);
        
    
        JButton reset = new JButton("Reset");   //Reset button
        //Action Listener for Reset
        reset.addActionListener((ActionEvent e) ->{

            symbol.setText("");
            name.setText("");
            price.setText("");  
            quantity.setText("");
            msgDisplay.setText("");
            
        });
        JButton buyButton = new JButton("Buy");  // buy button
        //Action Listener for Buy button
        buyButton.addActionListener((ActionEvent e) ->{
            
            String tempInv= typeInv.getSelectedItem().toString();
            String tempSymbol = symbol.getText();
            String tempName = name.getText();
            String tempPrice = price.getText();
            String tempQuantity = quantity.getText();
            msgDisplay.setText("");

            
            boolean flag = false;
            if (tempInv == "stock"){
                flag = portal.toequals(tempSymbol, "mutual fund");  // if user choses stock it checks if symbols exists in mutual fund
            }
            else if (tempInv== "mutual fund"){
                flag = portal.toequals(tempSymbol, "stock");   // if user choses mutual fund it checks if symbols exists in stock
            }
            if (flag == true){
                msgDisplay.setText("Symbol already exists, try again\n");
                return;
            
            }

            if(tempPrice.isBlank()){    //IF price in empty
                msgDisplay.setText("ERROR: Price can not be empty");
                return;
            }
            if(tempQuantity.isBlank()){   // if quantity is empty
                msgDisplay.setText("ERROR: quantity can not be empty");
                return;
            }
    
    
    
           try {                                   // try catch to check if Quantity is String or no
                Integer.parseInt(tempQuantity); 
            } catch(NumberFormatException a) { 
                msgDisplay.setText("ERROR: quantity can not be String(must be an integer)"); 
            }
            try {                                 // try catch to check if Price is String or no
                Double.parseDouble(tempPrice); 
            } catch(NumberFormatException a) { 
                msgDisplay.setText("ERROR: Price can not be String(must be an integer)"); 
            }
    
            int Iquantity = Integer.parseInt(tempQuantity);
            double Iprice = Double.parseDouble(tempPrice);
    
            
    
            if (!portal.investmentchq(tempSymbol))
            {
                try {          // Try Catch for possible Expections
                    portal.buyInvestment(tempInv,tempSymbol,tempName, Iquantity, Iprice);
                } catch (Exception e1) {
                    msgDisplay.setText(e1.getMessage());
                    e1.printStackTrace();
                    return;
                }  // stores in ArrayList if its a  new symbol
                
            }
            else{
                portal.buyInvestment(tempInv,tempSymbol,Iquantity, Iprice);   // stores in Arraylist if symbol already exits
                    
            }
    
            String a = portal.printBuy();
            msgDisplay.setText(a);
        });
        right.add(reset);
        right.add(buyButton);
        top.add(right);
    
        buyPanel.add(top,BorderLayout.NORTH);
        return buyPanel;   //returning buyPanel
    }
    
}
