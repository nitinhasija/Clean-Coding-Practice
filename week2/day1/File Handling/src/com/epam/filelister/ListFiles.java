/*
 * List all .java files
 */

package com.epam.filelister;

import java.io.*;

/**
 * The Class ListFiles.
 * 
 * @author Nitin_Hasija
 */
public class ListFiles {

  /**
   * Prints the file names.
   *
   * @param directory the directory
   */
  private static void printFileNames(File directory) {
    String[] filePaths = directory.list();

    for (String fileName : filePaths)
      if (fileName.endsWith(".java"))
        System.out.println(fileName);
  }

  /**
   * The main method.
   *
   * @param str the arguments
   */
  public static void main(String[] str) {
    String path = str[0];
    File directory = new File(path);
    printFileNames(directory);
  }
}
