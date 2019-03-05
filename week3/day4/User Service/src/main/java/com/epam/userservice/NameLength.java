/**
 *  Enum for length of the name
 */

package com.epam.userservice;

/**
 * The Enum NameLength.
 * 
 * @author Nitin_Hasija
 */
public enum NameLength {

  /** The min length. */
  MIN_LENGTH(4),
  /** The max length. */
  MAX_LENGTH(15);

  /** The length. */
  private int length = 0;

  /**
   * Instantiates a new name length.
   *
   * @param length the length
   */
  NameLength(int length) {
    this.length = length;
  }

  /**
   * Gets the length.
   *
   * @return the length
   */
  int getLength() {
    return length;
  }
}
