/*
 * Represents a main class to control all functionalities.
 */
package com.epam.sumandaverage;

/**
 * The Class Main.
 * 
 * @author Nitin_Hasija
 */
public class Main {

  /**
   * private method to display menu to the console.
   */
  private static void showMenu() {
    System.out.println("1. Add Elements");
    System.out.println("2. Sum");
    System.out.println("3. Average");
    System.out.println("4. Exit");
  }

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {

    Calculations calculate = new Calculations();

    while (true) {
      showMenu();
      int option = TakeInput.getMenu();

      switch (option) {

      case 1: // take input to add it to the list
        int number = TakeInput.getNumberToAddInList();
        calculate.addElement(number);
        break;

      case 2: // calculates the sum of numbers present in list
        System.out.println("Sum is:" + calculate.getSum());
        break;

      case 3: // calculate average of numbers present in list
        System.out.println("Average is:" + calculate.getAverage());
        break;

      case 4: // exit from the program
        System.exit(0);
        break;

      default: // invalid option
        System.out.println("Please choose valid option");
        break;
      }
    }
  }
}
