package ePortfolio;

import javax.swing.JTextArea;

/**
 * This is my super class which handels everything
 */
public abstract class Investment
{
    protected String symbol; //private variables of public class
    protected String name;
    protected int quantity;
    protected double price;
    protected double bookValue=0.0;                                     
    protected String investmentType;           
    protected double sellCom;           
    protected double buyCom;            
    protected double gain; 
    
    /**
     * 
     * @param symbol ,String, it should be a unique symbol to identify the Investment
     * @param name  String, name of the Investment
     * @param quantity int, the quantity of the Investment
     * @param price  double, the price of the Investment
     * @param sellCom  double, sell commision
     * @param buyCom  double, buy commision
     * @param investmentType String, type of investment
     * @throws Exception  , to do Exception using try catch
     */
    public Investment(String symbol, String name,int quantity, double price, double sellCom,double buyCom,String investmentType) throws Exception{
        if(!symbol.isBlank()){
            this.symbol = symbol;
        }
        else{
            throw new Exception("ERROR: Symbol can not be empty");
        }
        if(!symbol.contains(" ")){
            this.symbol = symbol;
        }
        else{
            throw new Exception("ERROR: Symbol should not contains spaces");
        }
        if(!name.isBlank()){
            this.name = name;
        }
        else{
            throw new Exception("ERROR: Name can not be empty");
        }
        if(quantity >= 0){
            this.quantity = quantity;
        }
        else{
            throw new Exception("ERROR: Quantity can not be negative");
        }
              
        if(price >= 0){
            this.price = price;
        } 
        else{
            throw new Exception("ERROR: Price can not be negative");
        }
        
        this.sellCom = sellCom;
        this.buyCom = buyCom; 
        this.investmentType = investmentType;
        this.bookValue = (quantity * price) + buyCom;

        updateG();
    
    }


    public String type(){
        return investmentType;
    }
    /**
     * To access symbol in different class
     * @return String, Returns the symbol of investment
     */
    public String getsymbol(){
        return this.symbol;
    }
    /**
     *  To access name in different class
     * @return String , Returns the name of insvestment
     */
    public String getname(){
        return this.name;
    }
    /**
     *  To access quantity in different class
     * @return int, Returns the cureent number of investment
     */
    public int getquantity(){
        return this.quantity;
    }
    /**
     *  To access current price of an investment in different class
     * @return double, Returns thr current price
     */
    public double getprice(){
        return this.price;
    }
    /**
     *  To access bookvalue in different class
     * @return double, Returns the bookVakue after calculation
     */
    public double getbookValue(){
        return this.bookValue;
    }
    /**
     * used To calculate getgain
     * @param g ,JTextArea to print in message box of getgain
     * @param symbol2 ,String to print symbol name
     * @return double, returns total getgain
     */
    public double getgain(JTextArea g,String symbol2){
        
        String a = String.valueOf(this.gain);

        g.append("Get Gain of "+ symbol2 + " investment is :"+a+"\n");
        
        return this.gain;
    }
    /**
     *  To access Type of investment(stock or mutual fund) in different class
     * @return String, Returns the investment type
     */
    public String getinvestmentType(){
        return this.investmentType;
    }
    /**
     * assigning bookvalue
     * @param bookValue , stores new book value
     */
    public void setbookValue(double bookValue){
        //if(bookValue)
        this.bookValue = bookValue;
    }
    /**
     * updates price of a investment
     * @param latestPrice , changes price in list 
     */
    public void updatePrice(double latestPrice){    //latest is new
        this.price = latestPrice;
    }
    /**
     * it is an empty constructor
     */
    public Investment(){

    }
    /**
     * This constructor is used for search
     * @param symbol String, it should be a unique symbol to identify the Investment
     * @param name String, name of the Investment
     * @param quantity int, the quantity of the Investment
     * @param price double, the price of the Investment
     * @param value double,  the total cost of the Investment
     * @param investmentType String, the type of Investment(stock or mutual fund)
     * @throws Exception ,to do Exceptions using try catch
     */
    public Investment(String symbol, String name, int quantity, double price, double value, String investmentType)throws Exception{

        if(!symbol.isBlank()){
            this.symbol = symbol;
        }
        else{
            throw new Exception("ERROR: Symbol can not be empty");
        }
        if(!symbol.contains(" ")){
            this.symbol = symbol;
        }
        else{
            throw new Exception("ERROR: Symbol should not contains spaces");
        }
        if(!name.isBlank()){
            this.name = name;
        }
        else{
            throw new Exception("ERROR: Name can not be empty");
        }
        if(quantity >= 0){
            this.quantity = quantity;
        }
        else{
            throw new Exception("ERROR: Quantity can not be negative");
        }
              
        if(price >= 0){
            this.price = price;
        } 
        else{
            throw new Exception("ERROR: Price can not be negative");
        }

        this.investmentType = investmentType;
        this.bookValue = value;

        updateG();
    }
    /**
     *      * to update value after there is change in price and the quantity
     * @param quantity int, the quantity of the Investment
     * @param price double, the price of the Investment
     */
    public void upValue(int quantity, double price){
        this.quantity += quantity;
        this.price = price;
        this.bookValue += (price * quantity) + buyCom;
        updateG();
        
    }
    /**
     * Reduce the quantity after we sell the mentioned number of investment
     * @param quantity int, the quantity of the Investment
     * @param price double, the price of the Investment
     * @return double , returns the payment
     */
    public double reduceValue(int quantity, double price)
    {
        this.bookValue = this.bookValue * ((this.quantity - quantity) / this.quantity);
        this.price = price;

        double pay = price * quantity - sellCom;
        this.quantity -= quantity;
        updateG();
      
        return pay;
        
    }
    /**
     * This Formula to calculate get gain
     */
    private void updateG() {
        this.gain = ((this.price * this.quantity - sellCom) - this.bookValue);
    }
    /**
     * To change the price when update is called
     * @param price double, the price of the Investment
     */
    public void priceup(double price)
    {
        this.price = price;
        updateG();
        
    }
    /**
     * To display the required output
     * @return String
     */
    public String toString(){
        return "\nInvestment Type " + this.investmentType + "\nsymbol: " + this.symbol + "\nname: " + this.name + "\nquantity: " + this.quantity + "\nprice: " + this.price + "\nbookValue: " + this.bookValue + "\n";

    }
    /**
     * To display the required output
     * @return String , Returns the required output
     */
    public String filePrint(){
        return this.investmentType +  "\n " + this.symbol + "\n" + this.name + "\n" + this.quantity + "\n" + this.price + "\n" + this.bookValue + "\n";

    }
    /**
     * Used in search function
     * @param symbol String, it should be a unique symbol to identify the Investment
     * @param name String, name of the Investment
     * @param tempLowPrice String, have the lower range to search
     * @param tempHighPrice String, have the higher range to search
     * @return boolean , Returns true if symbol name or range is found
     */
    public boolean equals(String symbol, String name, String tempLowPrice, String tempHighPrice) {

        boolean flag = false;
        
        if (name != null && !name.isEmpty()) { // name is given
            String word[] = name.split("( )+");

            for (int i = 0; i < word.length; i++) {   // name not equals
                if (!this.name.toLowerCase().contains(word[i].toLowerCase())) {
                    return false;
                }
            }
            flag = true;
        }      
        // if (range != null && !range.isEmpty()) { // when the price range is provided
        //     String prices[] = range.split("[- ]+");

            double lower = -1;
            double upper = Double.MAX_VALUE;
            if(tempLowPrice!=null && !tempLowPrice.isEmpty()){
                lower = Double.parseDouble(tempLowPrice);
            }
            if(tempHighPrice!=null && !tempHighPrice.isEmpty()){
                upper = Double.parseDouble(tempHighPrice);
            }
           
            // if (prices.length == 1) {  // when one limit is given
            //     lower = Double.parseDouble(prices[0]);
            //     if (!range.contains("-")) {
            //         upper = lower;
            //     }
            // }

            // else if (prices[0] == null || prices[0].isEmpty()) {
            //     upper = Double.parseDouble(prices[1]);
            // }

            // both limits are provided
            // else {
            //     lower = Double.parseDouble(prices[0]);
            //     upper = Double.parseDouble(prices[1]);
            // }
            
            if (this.price < lower || this.price > upper) {  // if price is outside the upper and lower bounds
                return false;
            }
            flag = true;
      //  }

        // when symbol was entered
        if (symbol != null && !symbol.isEmpty()) {
            if (!this.symbol.equalsIgnoreCase(symbol)) {
                return false;
            }
            flag = true;
        }

        if (flag) {
            return true;    //if match found and every operation is success
        } else {
            return false;
        }
    }
}
