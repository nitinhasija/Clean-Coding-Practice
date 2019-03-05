/*
 * Main class
 */

package com.epam.services;

import com.epam.exception.OutOfRangeException;

/**
 * This class performs addition of two numbers.
 *
 * @author Nitin_Hasija
 */
public class Services {

  /**
   * Performs addition and returns the sum if it is in range otherwise throws
   * custom exception.
   *
   * @param number1 the number1
   * @param number2 the number2
   * @return sum if it is in range
   * @throws OutOfRangeException if sum is reached out of boundary values
   */
  public int add(int number1, int number2) throws OutOfRangeException {
    int sum = number1 + number2;

    if (isOutOfRange(number1, number2, sum)) {
      throw new OutOfRangeException();
    }
    return sum;
  }

  /**
   * returns true if sum is out of range else false.
   *
   * @param number1 the number1
   * @param number2 the number2
   * @param sum     the sum
   * @return true, if is out of range
   */
  private boolean isOutOfRange(int number1, int number2, int sum) {
    return (number1 > 0 && number2 > 0 && sum < 0) || (number1 < 0 && number2 < 0 && sum >= 0);
  }
}
