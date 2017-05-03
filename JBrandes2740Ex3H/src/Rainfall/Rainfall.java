package Rainfall;

public class Rainfall {
	private double [] rainfallArray;
	
	
	 public Rainfall(double [] rainfall){

	         this.rainfallArray = new double[rainfall.length];
	         for (int i = 0; i < rainfall.length; i++)
	         rainfall[i] = rainfall[i];

	    }	 

	    public Rainfall(String [] rainfall) {

	         this.rainfallArray = new double[rainfall.length];
	         for (int i = 0; i < rainfall.length; i++)
	         this.rainfallArray[i] = Double.parseDouble(rainfall[i]);

	    }
	
	 public double getTotal() {
		 
	      double total = 0.0;   // Accumulator

	      // Add up all the values in the sales array.
	      for (double value : rainfallArray)
	         total += value;

	      // Return the total.
	      return total;
	   }

	   /**
	    * The getAverage method returns the average of the 
	    * elements in the sales array. 
	    */

	   public double getAverage() {
	      return getTotal() / this.rainfallArray.length;
	   }

	   /**
	    * The getHighest method returns the highest value  
	    * stored in the sales array.
	    */

	   public double getHighest()
	   {
	      // Store the first value in the sales array in
	      // the variable highest.
	      double highest = rainfallArray[0];

	      // Search the array for the highest value.
	      for (int index = 1; index < rainfallArray.length; index++)
	      {
	         if (rainfallArray[index] > highest)
	            highest = rainfallArray[index];
	      }

	      // Return the highest value.
	      return highest;
	   }

	   /**
	    * The getLowest method returns the lowest value    
	    * stored in the sales array.
	    */

	   public double getLowest()
	   {
	      // Store the first value in the sales array in
	      // the variable lowest.
	      double lowest = rainfallArray[0];

	      // Search the array for the lowest value.
	      for (int index = 1; index < rainfallArray.length; index++)
	      {
	         if (rainfallArray[index] < lowest)
	            lowest = rainfallArray[index];
	      }

	      // Return the lowest value.
	      return lowest;
	   }
}


