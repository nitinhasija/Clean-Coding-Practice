/**
 * Custom exception for account not found
 */

package com.epam.bank.exceptions;

/**
 * The Class AccountNotFoundException.
 *
 * @author Nitin Hasija
 */
public class AccountNotFoundException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new account not found exception.
   *
   * @param exception the exception
   */
  public AccountNotFoundException(String exception) {
    super(exception);
  }
}
