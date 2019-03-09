/**
 * custom exception
 */

package com.epam.exception;

/**
 * The Class EmptyArrayException.
 *
 * @author Nitin_Hasija
 */
public class EmptyArrayException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new empty array exception.
   *
   * @param exception the exception
   */
  public EmptyArrayException(String exception) {
    super(exception);
  }
}
