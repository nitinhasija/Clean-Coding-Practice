/*
 * This class performs mathematical calculations
 */

package com.epam.calculator;

/**
 * The Class Calculation.
 *
 * @author Nitin_Hasija
 */
class Calculation {

  /**
   * A method to perform addition.
   *
   * @param firstNumber  the first number
   * @param secondNumber the second number
   * @return integer value
   */
  public int add(int firstNumber, int secondNumber) {
    return (firstNumber + secondNumber);
  }

  /**
   * A method to perform subtraction.
   *
   * @param firstNumber  the first number
   * @param secondNumber the second number
   * @return integer value
   */
  public int subtract(int firstNumber, int secondNumber) {
    return (firstNumber - secondNumber);
  }

  /**
   * A method to perform multiplication.
   *
   * @param firstNumber  the first number
   * @param secondNumber the second number
   * @return integer value
   */
  public int multiply(int firstNumber, int secondNumber) {
    return (firstNumber * secondNumber);
  }

  /**
   * A method to perform division.
   *
   * @param firstNumber  the first number
   * @param secondNumber the second number
   * @return integer value
   */
  public int divide(int firstNumber, int secondNumber) {
    return (firstNumber / secondNumber);
  }

  /**
   * A method to exit from the program.
   */
  public void exit() {
    System.exit(0);
  }
}
