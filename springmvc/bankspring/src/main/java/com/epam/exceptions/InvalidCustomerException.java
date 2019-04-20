/**
 * A custom exception for invalid user
 */

package com.epam.exceptions;

/**
 * The Class InvalidCustomerException.
 *
 * @author Nitin_Hasija
 */
public class InvalidCustomerException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new invalid customer exception.
   *
   * @param exception the exception
   */
  public InvalidCustomerException(String exception) {
    super(exception);
  }
}
