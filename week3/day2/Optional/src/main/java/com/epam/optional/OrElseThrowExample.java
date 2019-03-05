/**
 * Return length of string if not null else throw exception
 */

package com.epam.optional;

import java.util.Optional;

/**
 * The Class OrElseThrowExample.
 *
 * @author Nitin_Hasija
 */
public class OrElseThrowExample {

  /**
   * Instantiates a new or else throw example.
   */
  private OrElseThrowExample() {

  }

  /**
   * Gets the string length.
   *
   * @param agr the agr
   * @return the string length
   */
  public static int getStringLength(String agr) {
    Optional<String> opt = Optional.ofNullable(agr);

    String name = opt.orElseThrow(() -> new IllegalArgumentException()); // takes supplier interface

    return name.length();
  }
}
