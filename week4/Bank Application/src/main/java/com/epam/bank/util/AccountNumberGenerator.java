/**
 * A util class to generate random account number
 */

package com.epam.bank.util;

import java.util.Random;

/**
 * The Class AccountNumberGenerator.
 *
 * @author Nitin_Hasija
 */
public class AccountNumberGenerator {

  /** The account number. */
  static long accountNumber;

  static {
    accountNumber = new Random(10000).nextLong();
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
  public static long getAccountNumber() {
    return accountNumber++;
  }
}