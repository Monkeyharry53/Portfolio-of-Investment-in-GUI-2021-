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
 * This is my gui class that extends JFrame anf inside this i have gui methord that is used to call panels of all the pages in JMenu
 */
public class gui extends JFrame {
    private static final int WIDTH = 500; 
    private static final int HEIGHT = 500;
    private JMenu commands = new JMenu("Commands");    // for all the types of task user can perform 
    private JMenuBar bar = new JMenuBar();

/**
 * this is gui methord in Which I made the welcome page and called all other pages by using Action Listeners
 */
    public gui(){
        super();
        setSize(WIDTH,HEIGHT);   //setting the width and height
        setResizable(false);   //the gui can not be resizable
        setJMenuBar(bar);
        setTitle("ePortfolio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel mainP = new JPanel((new GridLayout(5, 1)));   // panel for my welcome page
        JLabel homepage = new JLabel("Welcome to ePortfolio.");
        JLabel homepageTwo = new JLabel("<html><p>Choose a command from the \"Commands\" menu to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program.</p></html>");
        
         mainP.add(homepage);
         mainP.add(homepageTwo);
         
         //Creating options that User can Work on
        JMenuItem Buy = new JMenuItem("BUY");
        JMenuItem Sell = new JMenuItem("SELL");
        JMenuItem Update = new JMenuItem("UPDATE");
        JMenuItem GetGain = new JMenuItem("GET GAIN");
        JMenuItem Search = new JMenuItem("SEARCH");
        JMenuItem Quit = new JMenuItem("QUIT");
         // Adding all the required options in the Jmenu
        commands.add(Buy);
        commands.add(Sell);
        commands.add(Update);
        commands.add(GetGain);
        commands.add(Search);
        commands.add(Quit);
        bar.add(commands);
  


        // Creating panels for all the JMenuItem's
        JPanel buyPage = new buy().connect();
        JPanel sellPage = new sell().connect();
        update updateM = new update();
        JPanel updatePage = updateM.connect();
        getGain getG= new getGain();
        JPanel getGainPage =getG.connect();
        JPanel searchPage = new search().connect();
        
        //Creating object of portfolio class
        portfolio portal =  new portfolio();
         
        /**
         * Action Listener For Buy JMenuItem
         * In this Visibility of all the panels is false accept for buy page panel
         */
        Buy.addActionListener((ActionEvent e) ->{
            
            mainP.setVisible(false);
            sellPage.setVisible(false);
            updatePage.setVisible(false);
            searchPage.setVisible(false);
            getGainPage.setVisible(false);
            this.add(buyPage);
            buyPage.setVisible(true);
        });

        /**
         * Action Listener For Sell JMenuItem
         * In this Visibility of all the panels is false accept for sell page panel
         */
       
        Sell.addActionListener((ActionEvent e) ->{
        
            mainP.setVisible(false);
            buyPage.setVisible(false);
            updatePage.setVisible(false);
            searchPage.setVisible(false);
            getGainPage.setVisible(false);
            this.add(sellPage);
            sellPage.setVisible(true);
        });

        /**
         * Action Listener For Update JMenuItem
         * In this Visibility of all the panels is false accept for Update page panel
         */
        Update.addActionListener((ActionEvent e) ->{
        
            mainP.setVisible(false);
            buyPage.setVisible(false);
            sellPage.setVisible(false);
            searchPage.setVisible(false);
            getGainPage.setVisible(false);
            this.add(updatePage);
            ArrayList<Investment> list = portal.getList(); 

            updateM.updateSymbol.setText(list.get(0).symbol);
            updateM.updateName.setText(list.get(0).name);
            updateM.updateNext.setEnabled(true);
            updateM.updatePrev.setEnabled(true);
            updateM.updateDisplay.setText("");


            updatePage.setVisible(true);
        });

        /**
         * Action Listener For Buy JMenuItem
         * In this Visibility of all the panels is false accept for GetGain page panel
         */
        GetGain.addActionListener((ActionEvent e) ->{
        
            mainP.setVisible(false);
            buyPage.setVisible(false);
            sellPage.setVisible(false);
            updatePage.setVisible(false);
            searchPage.setVisible(false);
            this.add(getGainPage);
            getGainPage.setVisible(true);
            
            getG.getgainDisplay.setText("");
            double getgain = portal.gain(getG.getgainDisplay);
            String qq= String.valueOf(getgain);
            getG.totalGain.setText(qq);

        });

        /**
         * Action Listener For Buy JMenuItem
         * In this Visibility of all the panels is false accept for Search page panel
         */
        Search.addActionListener((ActionEvent e) ->{
        
            mainP.setVisible(false);
            buyPage.setVisible(false);
            sellPage.setVisible(false);
            updatePage.setVisible(false);
            getGainPage.setVisible(false);
            this.add(searchPage);
            searchPage.setVisible(true);
        });
        
        
        this.add(mainP);
        mainP.setVisible(true);
        sellPage.setVisible(false);
        buyPage.setVisible(false);
        updatePage.setVisible(false);
        getGainPage.setVisible(false);
        searchPage.setVisible(false);


        
        Quit.addActionListener(new quit());
        
    }
    
    /**
    * Action Listener For Quit JMenuItem
    *  When the user click on this the gui will close
    */
    private class quit implements ActionListener{
        public void actionPerformed (ActionEvent e){
            System.exit(0);

        }
    }
    /**
     * Action Listener For Print Menu
     * I created this menu for my personal use To check if things are getting stored in ArrayList But i did not remove it because I Thought This might be Helpful For grading and checking my ArrayList
     */
    private class print implements ActionListener{
        public void actionPerformed (ActionEvent e){
            portfolio portal =  new portfolio();
            
            String a = portal.print();
            System.out.println(a);

        }
    }
    public static void main(String[] args) 
    {
    gui w = new gui();
    w.setVisible(true);
    }

    
}
