/*
 * Return list of strings of length greater than desired length from string array using map in
 * optional class
 */

package com.epam.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Class MapExample.
 *
 * @author Nitin_Hasija
 */
public class MapExample {

  /** The expected length. */
  private static int expectedLength;

  /**
   * Instantiates a new map example.
   */
  private MapExample() {

  }

  /**
   * Checks if is valid string.
   *
   * @param string the string
   * @return true for valid string
   */
  private static boolean isValidString(String string) {
    int actualLength = Optional.ofNullable(string).map(String::length).orElse(0);

    return actualLength > expectedLength;
  }

  /**
   * Gets the valid string list.
   *
   * @param mixedArray the mixed array
   * @param length     the length
   * @return the valid string list
   */
  public static List<String> getValidStrings(String[] mixedArray, int length) {
    expectedLength = length;
    List<String> validStringList = new ArrayList<>();

    for (String string : mixedArray) {
      if (isValidString(string)) { // to get a valid string
        validStringList.add(string);
      }
    }
    return validStringList;
  }
}
