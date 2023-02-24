/**
 * This class helps create the stock object which consists of the instance variables symbol, name, numShares, and price. 
 * You can buy and sell stocks with this class. This class returns the stock in a formatted manner in the end.
 *
 * @author (Joe Kuriakose)
 * @version (2/16/2023)
 */
public class StockHolding
{
     private String symbol;
     private String name;
     private int numShares;
     private double price;

     /**
      * This method initialzes each instance variables according to the input parameters.
      * 
      * @param symbol represents the symbol or abbreviation used to represent the company.
      * @param name represnets the name of the company.
      * @param numShares represents the number of shares to be dealt with.
      * @param price represents the price of the stock.
      */
     public StockHolding(String symbol, String name, int numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
        }
      
     /**
      * This method helps return the symbol.
      * 
      * @return symbol of the stock to be dealt with.
      */
     public String getSymbol(){
        return symbol;
        }
     
     /**
       * This method returns the name.
       * 
       * @return the name instance variable which is the name of the stock.
       */
     public String name(){
        return name;
        }
      
     /**
      * This method returns the number of shares.
      * 
      * @return the instance variable numShares which is the number of shares of a particular stock.
      */
     public int getNumShares(){
        return numShares;
        }
        
     /**
      * This method returns the price of the stock.
      * 
      * @return the instance variable price which is the price of the stock.
      */
     public double getPrice(){
        return price;
        }
     
     /**
      * This method allows you to buy shares of stock for a certain price.
      * 
      * @param numberOfShares represents the number of shares of a stock to be bought.
      * @param pricePerShare represents the price of a share of stock.
      */
     public void buyShares(double numberOfShares, double pricePerShare){
        this.numShares = numShares;
        this.price = pricePerShare;
        }
     
     /**
      * This method allows you to sell shares of stock.
      * 
      * @param numberOfShares represents the number of shares of stock that will be sold.
      * @return sold which returns a value that is sold based on numberOfShares.
      */
     public double sellShares(int numberOfShares){
        double sold = 0;
        if(numberOfShares <= numShares){
         numShares = numShares - numberOfShares;
         sold = numShares * price;
        }
        else{
          numShares = numShares;
        }
        return sold;
        }
        
     /**
      * This method formats the StockHolding's in the proper way. 
      * 
      * @return a formatted string with symbol, name, numShares and price.
      */
     @Override
     public String toString()
     {
         //DO NOT EDIT THIS METHOD.
         return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
         symbol, name, numShares, price, numShares * price); 
     }
}
