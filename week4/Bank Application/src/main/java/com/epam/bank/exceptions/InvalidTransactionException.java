/**
 * Custom Exception
 */

package com.epam.bank.exceptions;

/**
 * The Class InvalidTransactionException.
 *
 * @author Nitin Hasija
 */
public class InvalidTransactionException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new invalid transaction exception.
   *
   * @param exception the exception
   */
  public InvalidTransactionException(String exception) {
    super(exception);
  }
}
