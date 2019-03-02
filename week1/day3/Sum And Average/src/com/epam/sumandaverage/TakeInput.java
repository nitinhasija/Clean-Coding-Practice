/*
 * Represents a class to display menu, and to take input from user
 */

package com.epam.sumandaverage;

import java.util.Scanner;

/**
 * The Class TakeInput.
 * 
 * @author Nitin_Hasija
 */
public class TakeInput {

  /**
   * Instantiates a new take input.
   */
  private TakeInput() {

  }

  /** The scanner. */
  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  /**
   * method to return selected option from menu.
   *
   * @return selected option from menu
   */
  public static int getMenu() {
    System.out.println("Choose Options from menu:");
    return scanner.nextInt();
  }

  /**
   * method to take input from the user to add it to the list.
   *
   * @return integer entered by the user
   */
  public static int getNumberToAddInList() {
    return scanner.nextInt();
  }
}
