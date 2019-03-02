/*
 * Class to perform calculations
 */

package com.epam.sumandaverage;

import java.util.ArrayList;

/**
 * The Class Calculations.
 *
 * @author Nitin_Hasija
 */
public class Calculations {

  /** The list of numbers. */
  private ArrayList<Integer> listOfNumbers;

  /**
   * Constructor to initialize array list.
   */
  Calculations() {
    listOfNumbers = new ArrayList<>();
  }

  /**
   * takes integer as parameter and add it to list.
   *
   * @param number the number
   */
  public void addElement(int number) {
    listOfNumbers.add(number);
  }

  /**
   * Gets the sum.
   *
   * @return the sum of numbers present in the list
   */
  public int getSum() {
    int sum = 0;
    for (int num : listOfNumbers) {
      sum += num;
    }
    return sum;
  }

  /**
   * Gets the average.
   *
   * @return the average
   */
  public double getAverage() {
    int sum = getSum();
    return (double) sum / listOfNumbers.size();
  }
}
