import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program creates a portfolio by reading the transactions in
 * the file transactions.txt and buying and selling stock shares
 * accordingly.  Then, this program prints the portfolio report
 * as described in the problem set 2 instructions.
 *
 * @author Joe Kuriakose
 * @version 2/16/2023
 */
public class PortfolioReport
{
    /**
     * This program creates a portfolio by reading the transactions in
     * the file transactions.txt and buying and selling stock shares
     * accordingly.  Then, this program prints the portfolio report
     * as described in the problem set 2 instructions.
     * 
     * @param args No command line arguments required.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("transactions.txt"));        
        Portfolio p = new Portfolio();

        while(file.hasNext()){
            String line = file.nextLine();
            String[] data = line.split(",");
            
            if(data[0].equals("B")){
                //Buy the stock for the portfolio.
                //YOUR CODE HERE.
                int numShares = Integer.parseInt(data[3].trim());
                double price = Double.parseDouble(data[4].trim());
                p.buyStock(data[1], data[2], numShares, price);
                //p.buyStock("DIS", "Walt Disney", 315, 113.23);
                //p.buyStock("AMZN", "Amazon", 30, 112.27);
            } else {
                //Sell the stock from the portfolio.
                //YOUR CODE HERE.
                int numShares = Integer.parseInt(data[2].trim());
                p.sellStock(data[1], numShares);
            }
        }

        System.out.print(p);
        System.out.println();
        
        // Uncomment the lines of code below and complete the print statements to work as intended.
         System.out.println(String.format("      Current Value:  $%,15.2f", p.getCurrentValue()));
         System.out.println(String.format("Lifetime Investment:  $%,15.2f", p.getLifeTimeInvestment()));
         System.out.println(String.format("    Lifetime Payout:  $%,15.2f", p.getLifeTimePayOut()));
    }
}

