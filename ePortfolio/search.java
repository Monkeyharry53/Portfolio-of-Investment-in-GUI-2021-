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
 * This is my Search class Which contains  gui for search Page
 */
public class search {
    /**
     * This method in used to make Jpanel for search JMenuItem
     * This method returns the searchPanel
     * @return JPanel
     */
    public JPanel connect(){
        
        JPanel searchPanel =  new JPanel();                                    //Creating a search panel
        searchPanel.setLayout(new BorderLayout());                             //Setting layout
        JPanel topSearch = new JPanel(new FlowLayout(FlowLayout.LEFT));        // using flow layout to swift everything to left
        JPanel leftSearch = new JPanel(new GridLayout(6,1));                   
        JPanel rightSearch = new JPanel(new GridLayout(2,1));
        JPanel bottomSearch = new JPanel(new GridLayout(2,1));
        
        
        JLabel searchText = new JLabel("Searching investments");   
        leftSearch.add(searchText);
        
        //Creating all the JField's
        JTextField searchSymbol = new JTextField(5);
        JTextField searchName = new JTextField(5);
        JTextField lowPrice = new JTextField(5);
        JTextField highPrice = new JTextField(5);
        leftSearch.add(new JLabel());
        //Adding Fields in LeftSearch panel alomg eith there  JLabel
        leftSearch.add(new JLabel("symbol"));
        leftSearch.add(searchSymbol);
        
        leftSearch.add(new JLabel("<html>Name<br>Keyword</html>"));
        leftSearch.add(searchName);
        
        leftSearch.add(new JLabel("Low price"));
        leftSearch.add(lowPrice);

        leftSearch.add(new JLabel("high price"));
        leftSearch.add(highPrice);
        
        topSearch.add(leftSearch);   //Now adding Left page in topSearch
        
        //Making a TextArea for the results and the error's
        JTextArea searchDisplay = new JTextArea(50,50);
        JLabel msgSearch = new JLabel("Search results");
        JScrollPane scrollSearch = new JScrollPane(searchDisplay);
        scrollSearch.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollSearch.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        bottomSearch.add(msgSearch);
        bottomSearch.add(scrollSearch);
        searchPanel.add(bottomSearch,BorderLayout.CENTER);  //adding bottom in search Panel
        
                
        JButton searchReset = new JButton("Reset");     // resetbutton
        searchReset.addActionListener((ActionEvent e) ->{
            searchSymbol.setText("");
            searchName.setText("");  
            lowPrice.setText("");
            highPrice.setText("");
            searchDisplay.setText("");
            
        });




        JButton searchButton = new JButton("Search");   // search button
        searchButton.addActionListener((ActionEvent e) ->{

            // getting all the values entered in JFields by using getText()
            String tempSymbol = searchSymbol.getText();
            String tempName = searchName.getText();
            String tempLowPrice = lowPrice.getText();
            String tempHighPrice = highPrice.getText();
            searchDisplay.setText("");
            portfolio.searchReasult(tempSymbol, tempName, tempLowPrice,tempHighPrice,  searchDisplay);  //ccalling searchResult function that is in portfolio
        });



        rightSearch.add(searchReset); // adding reset button in rightSearch panel
        rightSearch.add(searchButton); // adding add button in rightSearch panel
        topSearch.add(rightSearch);

        searchPanel.add(topSearch,BorderLayout.NORTH);   //adding topSeach in searchPanel
        return searchPanel;   // returning the searchPanel
    }
    
}
