package Rainfall;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		double [] dblRainfall = {
				2.2, 4.2, 1.8, 5.1, 6.1, 2.8, 1.2, 3.5, 5.5, 2.7, 1.4, 6.9};

				String [] strRainfall = {
				"2.2", "4.2", "1.8", "5.1", "6.1", "2.8", "1.2", "3.5", "5.5", "2.7", "1.4", "6.9"};


				DecimalFormat fmt = new DecimalFormat ("#0.0");

				Rainfall rainfall1 = new Rainfall(dblRainfall);
				System.out.println("Rainfall1 total:   " + fmt.format(rainfall1.getTotal()));
				System.out.println("Rainfall1 average:   " + fmt.format(rainfall1.getAverage()));
				System.out.println("Rainfall1 highest:   " + fmt.format(rainfall1.getHighest()));
				System.out.println("Rainfall1 lowest:   " + fmt.format(rainfall1.getLowest()));
				System.out.println();


	}

}
