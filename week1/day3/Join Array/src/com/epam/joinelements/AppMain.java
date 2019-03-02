/*
 * MainApp
 */

package com.epam.joinelements;

import java.util.Scanner;

/**
 * The Class MainApp.
 * 
 * @author Nitin_Hasija
 */
public class AppMain {

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter size of array:");
    int size = scanner.nextInt();

    System.out.println("Enter " + size + " elements:");

    int[] array = new int[size];

    for (int index = 0; index < array.length; index++)
      array[index] = scanner.nextInt();

    JoinElements join = new JoinElements();

    System.out.println(join.joinElementsIntoString(array, ','));
    System.out.println(join.joinElementsIntoString(array, ';'));

    scanner.close();
  }
}
