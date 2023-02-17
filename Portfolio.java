
/**
 * Write a description of class Portfolio here.
 *
 * @author (Joe Kuriakose)
 * @version (2/16/2023)
 */
public class Portfolio
{
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
