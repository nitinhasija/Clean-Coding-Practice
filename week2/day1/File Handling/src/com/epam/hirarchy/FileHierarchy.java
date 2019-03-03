/**
 * This class represents all files and sub files in a hierarchical structure
 * using recursion
 */
package com.epam.hirarchy;

import java.io.File;

/**
 * The Class FileHierarchy.
 * 
 * @author Nitin_Hasija
 */
public class FileHierarchy {

  /**
   * Adds the space.
   *
   * @param space the space
   */
  public void addSpace(int space) {
    int count = 0;

    while (count++ < space)
      System.out.print("  ");
  }

  /**
   * List files.
   *
   * @param files the files
   * @param level the level
   */
  public void listFiles(File[] files, int level) {

    for (File subFile : files) {
      if (subFile.isDirectory()) { // in case of folder
        addSpace(level);
        System.out.println("+- " + subFile.getName() + "/");
        listFiles(subFile.listFiles(), level + 1); // recursion to include sub files and folders
      }

      else {
        addSpace(level);
        System.out.println("| +- " + subFile.getName()); // when no sub file or sub folder is available
      }
    }
  }
}
