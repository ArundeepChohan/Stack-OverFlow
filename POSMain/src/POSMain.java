
import java.io.*;
import java.util.ArrayList;
import java.util.List;
class CashRegister{
    public CashRegister(List<String> produceNames) {
      
   }
}
class ShoppingCart{
    int [] quantity;
    public ShoppingCart(int size) {
      quantity = new int[size];
    }
    public void addQuatinty(int index)
    {
    	quantity[index]+=1;
    }
}
    
public class POSMain {
    public static void main(String args[]) {
      System.out.println(args[0]+" "+args[1]+" "+args[2]);
      List<String> produceNames = new ArrayList<String>();
      List<Float> producePrices = new ArrayList<Float>();
      //Read in prices and names
      readPrice(args[0],produceNames,producePrices);
	  System.out.println(produceNames);
	  System.out.println(producePrices);
	   
      ShoppingCart cart1 = new ShoppingCart(produceNames.size());
      ShoppingCart cart2 = new ShoppingCart(produceNames.size());
      
      readFile(args[1],cart1,produceNames);
      readFile(args[2],cart2,produceNames);
      CashRegister cashReg = new CashRegister(produceNames);
        
    }
	public static void readPrice(String fileName, List<String> productNames, List<Float> productPrices )
    {
        String line = null;
         try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	String[] parts = line.split("\\s");
            	 for (int i=0; i<parts.length-1; i+=2) {
            	        productNames.add(parts[i]);
            	        productPrices.add(Float.parseFloat(parts[i+1]));
            	    }
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
    
    }
    public static void readFile(String fileName,ShoppingCart cart, List<String> produceNames )
    {
        String line = null;
         try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //use split to form an array to go through the line
                //Add to cart
            	System.out.println(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
    }

}