/*
 * Main class to start the thread execution
 */

package com.epam.reenterlock;

/**
 * The Class Main.
 * 
 * @author Nitin Hasija
 */

public class Main {

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {

    DisplayNumbers.setLimit(100); // limit to print the counting

    DisplayNumbers firstThread = new DisplayNumbers();
    DisplayNumbers secondThread = new DisplayNumbers();
    DisplayNumbers thirdThread = new DisplayNumbers();

    firstThread.start();
    secondThread.start();
    thirdThread.start();
  }
}
