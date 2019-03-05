/*
 *  Calculates sum and count of even and odd numbers from the array list
 */

package com.epam.stream.oddeven;

import java.util.List;

/**
 * The Class NumbersUtil.
 *
 * @author Nitin_Hasija
 */
public class NumbersUtil {

  /** The list of numbers. */
  private List<Integer> listOfNumbers;

  /**
   * Instantiates a new numbers util.
   *
   * @param listOfNumbers the list of numbers
   */
  public NumbersUtil(List<Integer> listOfNumbers) {
    this.listOfNumbers = listOfNumbers;
  }

  /**
   * compute the count of even numbers.
   *
   * @return count of even numbers
   */
  public int getEvenCount() {
    return (int) listOfNumbers.stream().filter(number -> number % 2 == 0).count();
  }

  /**
   * compute the count of odd numbers.
   *
   * @return count of odd numbers
   */
  public int getOddCount() {
    return (int) listOfNumbers.stream().filter(number -> number % 2 != 0).count();
  }

  /**
   * compute the sum of even numbers.
   *
   * @return sum of even numbers
   */
  public int getEvenNumberSum() {
    return listOfNumbers.stream().filter(number -> number % 2 == 0).mapToInt(num -> num).sum();
  }

  /**
   * compute the sum of odd numbers.
   *
   * @return sum of odd numbers
   */
  public int getOddNumberSum() {
    return listOfNumbers.stream().filter(number -> number % 2 != 0).mapToInt(num -> num).sum();
  }
}
