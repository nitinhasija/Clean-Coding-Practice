/**
 * A util class to generate random account number
 */

package com.epam.util;

import java.util.Random;

/**
 * The Class AccountNumberGenerator.
 *
 * @author Nitin_Hasija
 */
public class AccountNumberGenerator {

  /** The account number. */
  static int accountNumber;

  static {
    accountNumber = new Random().nextInt(10000);
  }

  /**
   * Instantiates a new account number generator.
   */
  private AccountNumberGenerator() {
  }

  /**
   * Gets the account number.
   *
   * @return account number
   */
  public static int getAccountNumber() {
    return accountNumber++;
  }
}