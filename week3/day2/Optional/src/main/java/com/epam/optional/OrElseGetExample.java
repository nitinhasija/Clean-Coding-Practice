/**
 * Return string at a particular index else return 0;
 */

package com.epam.optional;

import java.util.Optional;

/**
 * The Class OrElseGetExample.
 *
 * @author Nitin_Hasija
 */
public class OrElseGetExample {

  /**
   * Instantiates a new or else get example.
   */
  private OrElseGetExample() {

  }

  /**
   * Gets the index value.
   *
   * @param args  the args
   * @param index the index
   * @return string
   */
  public static String getIndexValue(String[] args, int index) {

    Optional<String> opt = Optional.ofNullable(args[index]); // to prevent null pointer exception

    return opt.orElseGet(() -> "not defined"); // orElseGet method always takes as a supplier
  }
}
