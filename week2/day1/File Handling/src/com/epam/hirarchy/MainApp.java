/*
 * Main class
 */

package com.epam.hirarchy;

import java.io.*;

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

    File directory = new File(arg[0]);
    File[] files = directory.listFiles();

    FileHierarchy hierarchy = new FileHierarchy();

    System.out.println("$ " + directory + "/");
    hierarchy.listFiles(files, 0);
  }
}
