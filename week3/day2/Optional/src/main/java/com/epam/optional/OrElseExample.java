/*
 * Return name if its not null else return "EMPTY NAME"
 */

package com.epam.optional;

import java.util.Optional;

/**
 * The Class OrElseExample.
 *
 * @author Nitin_Hasija
 */
public class OrElseExample {

  /**
   * Instantiates a new or else example.
   */
  private OrElseExample() {

  }

  /**
   * Convert to upper case.
   *
   * @param name the name
   * @return string
   */
  public static String convertToUpperCase(String name) {
    Optional<String> opt = Optional.ofNullable(name); // if name is null then also program executes

    String string = opt.orElse("Empty name"); // if opt is empty then "Empty name" is assigned

    return string.toUpperCase();
  }
}
