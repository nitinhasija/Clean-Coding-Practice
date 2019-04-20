package com.epam.sumAndAverage;

import java.util.ArrayList;

/**
 * @author Nitin Hasija
 *
 */
public class Calculations {

	private ArrayList<Integer> listOfNumbers;

	/**
	 * Constructor to initialize array list
	 */
	Calculations() {
		listOfNumbers = new ArrayList<Integer>();
	}

	/**
	 * takes integer as parameter and add it to list
	 * 
	 * @param number
	 */
	public void addElement(int number) {
		listOfNumbers.add(number);
	}

	/**
	 * @return the sum of numbers present in the list
	 */
	public int getSum() {
		int sum = 0;
		for (int num : listOfNumbers)
			sum += num;

		return sum;
	}

	/**
	 * @return the average of numbers present in the list
	 */
	public double getAverage() {
		int sum = getSum();
		double avg = (double) sum / listOfNumbers.size();
		return avg;
	}
}
