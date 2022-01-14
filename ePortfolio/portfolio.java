package ePortfolio;
import java.util.*;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;


import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;


/**
 * Portfolio class - here my arraylist and HashMap is defined alomg with other functionality that is required in mainfile
 */
public class portfolio {
    static ArrayList<Investment> investment = new ArrayList<Investment>();
    static HashMap<String,ArrayList<Integer>> requiredKey = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    /**
     * To check if symbol exists in the Arraylist
     * @param symbol  String, it should be a unique symbol to identify the Investment
     * @param investmentType String, the type of Investment(stock or mutual fund)
     * @return boolean , true if found ,else false
     */
    public boolean toequals(String symbol, String investmentType){
        for(Investment list: investment){
            if (symbol.equals(list.getsymbol()) && investmentType.equals(list.getinvestmentType())){   
                return true;
            }
        }

        return false;
    }
    /**
     * To check if symbol exists in the Arraylist
     * @param symbol String, it should be a unique symbol to identify the Investment
     * @return boolean , true if symbol is already defined
     */

    public boolean investmentchq(String symbol)
    {
      for(Investment list : investment){
        if(symbol.equals(list.getsymbol()))
        {
          return true;
        }
      }
      return false;
    }
    /**
     * Returns the last investment
     * @return String, returns the last String
     */
    public String printBuy(){
        Investment list = investment.get(investment.size() -1);
        return list.toString();
     }
    /**
     * used to get toString from Super class(Investment) to main
     * @return String, returns the list
     */
    public String print(){
        String temp="";
        for(Investment list : investment){
          temp = temp + list.toString();
          
        }
        return temp;
     }
     /**
      * Updates value when investment is bought
      * @param investmentType String, the type of Investment(stock or mutual fund)
      * @param symbol String, it should be a unique symbol to identify the Investment
      * @param quantity int, the quantity of the Investment
      * @param price double, the price of the Investment
      */
     public void buyInvestment (String investmentType, String symbol,  int quantity, double price){
        
        for(Investment list: investment)
        {
            if (investmentType.equals(list.getinvestmentType())){
                if (symbol.equals(list.getsymbol())){   
                    list.upValue(quantity, price);
                }
            } 
        }
    }
    /**
     * creates 2 lists to seprate stokes from mutual funds
     * @param investmentType String, the type of Investment(stock or mutual fund)
     * @param symbol String, it should be a unique symbol to identify the Investment
     * @param name String, name of the Investment 
     * @param quantity int, the quantity of the Investment
     * @param price double, the price of the Investment
     * @throws Exception , to doing Exceptions by using try catch
     */
    public void buyInvestment (String investmentType, String symbol,String name,  int quantity, double price ) throws Exception{
        
        if (investmentType.equals("stock")){
            stock stockList = new stock(symbol, name, quantity, price);
            investment.add(stockList);
            hashup();
        }
        else if (investmentType.equals("mutual fund")){
            mutualfund fundList = new mutualfund(symbol, name, quantity, price);
            investment.add(fundList);
            hashup();
        }
       
    }
    /**
     * if symbols is in the list
     * @param symbol String, it should be a unique symbol to identify the Investment
     * @return boolean , true if symbol is found ; else false
     */
    public boolean toequals(String symbol){    // for sell
        for(Investment list: investment){
            if (symbol.equals(list.getsymbol())){   
                return true;
            }
        }

        return false;
    }
    /**
     * To find the symbol at that index
     * @param symbol String, it should be a unique symbol to identify the Investment
     * @return  int , returns the index if symbol is found else returns -1
     */
    public  int findIndex(String symbol){
 
        int i = 0;
        for(Investment list: investment){
            if (symbol.equals(list.getsymbol())){   
                return i;
            }
            i++;
        }

        return -1;
    }

    /**
     * gives the payment after investment in sold
     * @param symbol  String, it should be a unique symbol to identify the Investment
     * @param price double, the price of the Investment
     * @param quantity int, the quantity of the Investment
     * @return double , payment after each sell
     */
    public  double payment (String symbol, double price, int quantity){

        double pay = -1;

        int result = findIndex(symbol);

        if (investment.get(result).getquantity() < quantity)
        {
            return -2;
        }

        if (investment.get(result).getquantity() == quantity)
        {
            pay = investment.get(result).reduceValue(quantity, price);
            investment.remove(result);
            hashup();
            return pay;
        }

        pay = investment.get(result).reduceValue(quantity, price);
        System.out.println(investment.get(result).toString());
        return pay;
    }
    /**
     * updates the price and everything that changes with price
     * @param ucheckk double, the pricr enered by user
     * @param index int, the index of list that needs to be changed
     */
    public  void updateVal(String ucheckk, int index)
    {
        
        double ucheck = Double.parseDouble(ucheckk);
        Investment list = investment.get(index);
        

    
        double value = (ucheck * list.getquantity()) + 9.99;  
        list.setbookValue(value);
        list.priceup(ucheck);
    }

    /**
     * This method is used for getting the array list
     * @return ArrayList
     * Returns the ArrayList
     */
    public ArrayList<Investment> getList(){
    
        return investment;

    }
    /**
     * updates the getgain whenever price changes
     * @param getgainDisplay JTextArea ,This is used to print in message box in gain panale
     * @return double ,returns getgain 
     */
    public  double gain(JTextArea getgainDisplay)
    {
        double gain = 0;

        for(Investment list: investment)
        {
           

            gain += list.getgain(getgainDisplay,list.symbol);
            
            
        }

        return gain;
    }
    /**
     * This is used for reading the file
     * @param inputFile , the name of the file from where values will be read
     */
    public static void load(String inputFile){

        try{
            BufferedReader likho = new BufferedReader(new FileReader(inputFile));
            String investmentType = likho.readLine();

            while (investmentType != null){
                 
                String symbol = likho.readLine();
                String symbolname = likho.readLine();
                int quantity = Integer.parseInt(likho.readLine());
                double price = Double.parseDouble(likho.readLine());
                double value = Double.parseDouble(likho.readLine());

                if (investmentType.equals("stock")){
                    stock inv = new stock(symbol,symbolname,quantity,price,value);
                    investment.add(inv);
                    hashup();
                }
                else if(investmentType.equals("mutualfund")){
                    mutualfund inv = new mutualfund(symbol,symbolname,quantity,price,value);
                    investment.add(inv);
                    hashup();
                }
                likho.readLine();
                investmentType = likho.readLine();
                likho.close();
            }   
        }
        catch(Exception e)
        {
                System.out.println("Files is not created yet! Or Wrong file input");
        }
    }
    /**
     * Used to write on given file 
     * @param inputFile , the name of the file from where values will be written
     */
    public static void outputFile(String inputFile)
    {
        try{
            PrintWriter output = new PrintWriter(inputFile, "UTF-8");
            for(int i = 0; i < investment.size(); i++){
                output.println(investment.get(i).filePrint());     
            }
            output.close();  
        }
        catch(Exception e){
            System.out.println("write operation failed\n");
        }
    }
    /**
     * This is used to update hashMap after ittration of all the investments
     */
    public static void hashup(){
        requiredKey = new HashMap<String, ArrayList<Integer>>();
        String[] ch;
        for(int i=0;i< investment.size();i++){
          ch = (investment.get(i).getname().toLowerCase()).split("[ ]+",0);      //split and store the requiredKey from name
          for(int j=0; j< ch.length; j++){
            if(requiredKey.get(ch[j])==null) 
            {
                requiredKey.put(ch[j],new ArrayList<Integer>());
            }
                requiredKey.get(ch[j]).add(i);
            }
        } 
    }
    /**
     * This is search function(using hash for name)
     * @param tempSymbol ,converting JField from use to String to pass the parameters :: symbol to perform search
     * @param tempName    ,converting JField from use to String to pass the parameters :: Name to perform search
     * @param tempLowPrice ,converting  JField from use to String to pass the parameters :: lowprice of range to perform search
     * @param tempHighPrice ,converting JField from use to String to pass the parameters :: highprice to perform search
     * @param searchDisplay  , This is my message box used in search
     */
    
    public static void searchReasult(String tempSymbol, String tempName,String tempLowPrice,String tempHighPrice, JTextArea searchDisplay) {
        tempName = tempName.toLowerCase(); 
        


        ArrayList<String> listt  = new ArrayList<String>(); // declaring our result ArrayList
        ArrayList<Integer> iList = new ArrayList<Integer>();

       String []share = tempName.split("[ ]+");
        for (int i = 0; i < share.length; i++){
            if (i == 0){
                iList = requiredKey.get(share[i]);
            }
            else{
                iList.retainAll(requiredKey.get(share[i]));
            }
        }
        if(iList != null){

            for(int counter: iList){
                    if (investment.get(counter).equals(tempSymbol, tempName, tempLowPrice,tempHighPrice)){
                        searchDisplay.append(investment.get(counter).toString());
                    }
            }
        }
        else{   
            for (int i = 0; i < investment.size(); i++) {
               
                if (investment.get(i).equals(tempSymbol, tempName, tempLowPrice,tempHighPrice)) {
                    listt.add(investment.get(i).toString());
                }
            }         
            for (int i = 0; i < listt.size(); i++) {
                searchDisplay.append(listt.get(i));
            }
            if (listt.size() == 0) {
                searchDisplay.setText("Match Not found!\n");
            }
        }
    }
}
