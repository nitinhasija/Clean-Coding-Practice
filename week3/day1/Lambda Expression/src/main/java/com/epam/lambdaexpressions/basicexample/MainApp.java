/*
 * Class to return square of a number using lambda expression
 */

package com.epam.lambdaexpressions.basicexample;

/**
 * The Class MainApp.
 * 
 * @author Nitin_Hasija
 */
class MainApp {

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {
    Square square = number -> number * number;
    System.out.println(square.getSquare(10));
  }
}