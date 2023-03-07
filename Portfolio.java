import java.util.ArrayList;

/**
 *  This class helps us create the stock portfolio by using the Stockholdings object in an arraylist. 
 *  You can buy and sell shares of stocks with this method. 
 *
 * @author (Joe Kuriakose)
 * @version (2/16/2023)
 */
public class Portfolio
{
    ArrayList<StockHolding> stocks;
    private double lifeTimeInvestment;
    private double lifeTimePayOut;
    /**
     * This is a constructor which initilizes the instance variables lifeTimeInvestment 
     * and lifeTimePortfolio to 0. This constructor also create a new ArrayList<Stockholding> objects.
     */
    public Portfolio(){
        stocks = new ArrayList<StockHolding>();
        lifeTimeInvestment = 0;
        lifeTimePayOut = 0;
    }

    /**
     * This method returns the total number of investments made.
     * 
     * @return the instance variable lifeTimeInvestment. 
     */
    public double getLifeTimeInvestment(){
        return lifeTimeInvestment;
    }

    /**
     * This method returns the total number of stocks in portfolio.
     * 
     * @return the instance variable lifeTimePortfolio
     */
    public double getLifeTimePayOut(){
        return lifeTimePayOut;
    }

    /**
     * This method helps you get the index of a the symbol of the stock you are looking for. It takes in one 
     * input parameter to make this happen. You also could have two types of return statements depending on the
     * situation.
     * 
     * @param symbol, which is the symbol of the stocks
     * @return i which is the index or -1 if it can't find the index of the symbol you are looking for.
     */
    private int getIndex(String symbol){
        int i = 0;
        while(i < stocks.size()){
            if(stocks.get(i).getSymbol().equals(symbol)){
             return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * This method helps an user buys the stock the user likes. The method takes in 4 instance variables and increment 
     * lifeTimeInvestment.
     * 
     * @param symbol, which is the symbol of the stock to be bought. 
     * @param name, the name of the stock.
     * @param numShares, the number of stocks to be bought.
     * @param price, the price of each share of stock.
     * @return numShares * price, which is the value of the stock you bought.
     */
    public double buyStock(String symbol, String name, int numShares, double price){
        int i = getIndex(symbol);
        if(i == -1){
            stocks.add(new StockHolding(symbol, name, numShares, price));
            lifeTimeInvestment += numShares * price;
        }
        else{
            stocks.get(i).buyShares(numShares, price);
            lifeTimeInvestment += numShares * price;
        }
        return numShares * price;
    }

    /**
     * This method helps the user sell his/her stocks. It takes in the symbol of the stock and the number of shares to be sold 
     * as the input parameters. It returns the value of the stock sold.
     * 
     * @param symbol, the symbol of the stock which the user inputs.
     * @param numShares, the number of shares to be sold inputted by the user.
     * @return numShares * price, which is the value of the stock sold.
     */
    public double sellStock(String symbol, int numShares){
        double price = 0.0;
        int i = getIndex(symbol);
        if(i != -1 && stocks.get(i).getSymbol().equals(symbol)){
            //if(stocks.size() == 0){
            //        stocks.remove(stocks.get(i));
            //        lifeTimePayOut += numShares * price;
            //    }

            price = stocks.get(i).sellShares(numShares);
            //price = numShares * stocks.get(i).getPrice();
            lifeTimePayOut += price;
            if(stocks.get(i).getNumShares() == 0){
                stocks.remove(stocks.get(i));
            }
        }
        
        return price;
    }

    /**
     * This method helps get the total value of all the stocks in the portfolio. The number of shares and the price of each
     * shares are multiplied in each stocks. Then it is added with all the other stocks to get the total value.
     * 
     * @return value, which is the value of all the stocks in the portfolio.
     */
    public double getCurrentValue(){
        double value = 0.0;
        for(int i = 0; i < stocks.size(); i++){
            value += stocks.get(i).getNumShares() * stocks.get(i).getPrice();
        }
        return value;
    }

    /**
     * This method helps format the portfolio class entirely just so it doesn't appear messed up. This helps organize each values
     * of the stock according to their names.
     * 
     * @return sb.toString, which takes in the toString to return everything formatted.
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
