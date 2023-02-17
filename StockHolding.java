/**
 * Write a description of class Asset here.
 *
 * @author (Joe Kuriakose)
 * @version (2/16/2023)
 */
public class StockHolding
{
     private String symbol;
     private String name;
     private double numShares;
     private double price;
     /**
      * 
      */
     public StockHolding(String symbol, String name, double numShares, double price){
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
        }
      
     /**
      * 
      */
     public String getSymbol(){
        return symbol;
        }
     
     /**
       * 
       */
     public String name(){
        return name;
        }
      
     /**
      * 
      */
     public double getNumShares(){
        return numShares;
        }
        
     /**
      * 
      */
     public double getPrice(){
        return price;
        }
     
     /**
      * 
      */
     public void buyShares(double numberOfShares, double pricePerShare){
        this.numShares = numShares;
        this.price = pricePerShare;
        }
     
     /**
      * 
      */
     public double sellShares(double numberOfShares){
        double sold = 0.0;
        if(numberOfShares <= numShares){
         numShares = numShares - numberOfShares;
         sold = numShares * price;
        }
        return sold;
        }
        
     /**
      * 
      */
     @Override
     public String toString()
     {
         //DO NOT EDIT THIS METHOD.
         return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
         symbol, name, numShares, price, numShares * price); 
     }
}
