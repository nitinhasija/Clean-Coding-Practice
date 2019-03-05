/*
 * Square interface
 */

package com.epam.lambdaexpressions.basicexample;

/**
 * The Interface Square.
 * 
 * @author Nitin_Hasija
 */
@FunctionalInterface
interface Square {

  /**
   * Gets the square.
   *
   * @param a the a
   * @return the square
   */
  public int getSquare(int value);
}
