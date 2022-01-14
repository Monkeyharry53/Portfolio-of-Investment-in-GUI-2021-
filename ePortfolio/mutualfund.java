package ePortfolio;

/**
 * This is extension of Investment super class (for mutual funds)
 */
public class mutualfund extends Investment{

    mutualfund(String symbol, String name, int quantity, double price) throws Exception {
        super(symbol, name, quantity, price, 45, 0, "mutual fund");
        
    }
    mutualfund(String symbol, String name, int quantity, double price,double value) throws Exception{
        super(symbol,name,quantity,price,value, "mutualfund");
    }
}