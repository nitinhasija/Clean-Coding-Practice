/*
 * working directory of a file
 */

package com.epam.directory;

import java.io.*;

/**
 * This class displays the current working directory.
 *
 * @author Nitin_Hasija
 */
public class WorkingDirectory {

  /**
   * The main method.
   *
   * @param str the arguments
   */
  public static void main(String[] str) {
    File file = new File("");
    System.out.println(file.getAbsolutePath());
  }
}
