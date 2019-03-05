/*
 * Returns list of  strings from string array using filters in optional class
 */

package com.epam.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Class FilterExample.
 *
 * @author Nitin_Hasija
 */
public class FilterExample {

  /**
   * Instantiates a new filter example.
   */
  private FilterExample() {

  }

  /**
   * Checks if is string.
   *
   * @param string the string
   * @return boolean value
   */
  private static boolean isString(String string) {
    return Optional.ofNullable(string).filter(s -> !s.isEmpty()).isPresent();
  }

  /**
   * Gets the non empty string list.
   *
   * @param mixedArray the mixed array
   * @return list of
   */
  public static List<String> getNonEmptyStringList(String[] mixedArray) {
    List<String> validStringList = new ArrayList<>();

    for (String string : mixedArray) {
      if (isString(string)) {
        validStringList.add(string);
      }
    }
    return validStringList;
  }
}
