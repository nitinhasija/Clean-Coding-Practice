/*
 * Main class
 */

package com.epam.console;

import java.util.Scanner;
import com.epam.factory.*;
import com.epam.model.*;

/**
 * Main class to input shape name and to call that class if it exists.
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

    System.out.println("Enter class name:");
    String className = scanner.next();

    Shape shape = new ShapeFactory().getShapeObject(className);// factory method

    try {
      shape.drawShape(); // draw shape method of a particular class is invoked if it exists
    } catch (NullPointerException exception) { // if not class is available

    }
    scanner.close();
  }
}
