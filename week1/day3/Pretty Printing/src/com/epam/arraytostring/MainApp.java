/*
 * Main class to take input from user and to display the desired string
 */

package com.epam.arraytostring;

import java.util.Scanner;

/**
 * The Class MainApp.
 * 
 * @author Nitin_Hasija
 */
public class MainApp {

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter rows and columns:");

    int rows = scanner.nextInt();
    int columns = scanner.nextInt();

    double[][] array = new double[rows][columns];

    System.out.println("Enter Elements:");

    for (int row = 0; row < array.length; row++)
      for (int column = 0; column < array[0].length; column++)
        array[row][column] = scanner.nextDouble();

    ConvertToString string = new ConvertToString();

    System.out.println(string.asMatrix(array));

    scanner.close();
  }
}
