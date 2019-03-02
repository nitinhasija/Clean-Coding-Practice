/*
 * Main class for calculator 
 */

package com.epam.calculator;

import java.util.Scanner;

/**
 * The Class Main.
 *
 * @author Nitin_Hasija
 */
public class Main {

  /** The num two. */
  private static int numOne;

  /** The num two. */
  private static int numTwo;

  /** The scanner. */
  private static Scanner scanner;

  static {
    scanner = new Scanner(System.in);
  }

  /**
   * This method displays menu in the console.
   */
  private static void showMenu() {
    System.out.println("1. ADDITION");
    System.out.println("2. SUBTRACTION");
    System.out.println("3. MULTIPLICATION");
    System.out.println("4. DIVISION");
    System.out.println("5. EXIT");
  }

  /**
   * Gets the menu.
   *
   * @return the menu
   */
  private static int getMenu() {
    System.out.println("Choose Options from above:");
    return scanner.nextInt();
  }

  /**
   * Input numbers.
   */
  private static void inputNumbers() {
    numOne = scanner.nextInt();
    numTwo = scanner.nextInt();
  }

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {

    Calculation calculation = new Calculation();
    showMenu();

    while (true) {

      int choice = getMenu();
      int result = 0;
      switch (choice) {
      case 1:
        inputNumbers();
        result = calculation.add(numOne, numTwo);
        System.out.println(result);
        break;

      case 2:
        inputNumbers();
        result = calculation.subtract(numOne, numTwo);
        System.out.println(result);
        break;

      case 3:
        inputNumbers();
        result = calculation.multiply(numOne, numTwo);
        System.out.println(result);
        break;

      case 4:
        inputNumbers();
        result = calculation.divide(numOne, numTwo);
        System.out.println(result);
        break;

      case 5:
        calculation.exit();
        break;

      default:
        System.out.println("Invalid Option");
        break;
      }
    }
  }
}