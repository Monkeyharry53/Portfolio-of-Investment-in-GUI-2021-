package ePortfolio;

/**
 * This is extension of Investment super class (for stock)
 */
public class stock extends Investment{
    stock(String symbol, String name, int quantity, double price) throws Exception {
        super(symbol, name, quantity, price, 9.99, 9.99, "stock");
    }
    stock(String symbol, String name, int quantity, double price,double value) throws Exception{
        super(symbol,name,quantity,price,value, "stock");
    }
}