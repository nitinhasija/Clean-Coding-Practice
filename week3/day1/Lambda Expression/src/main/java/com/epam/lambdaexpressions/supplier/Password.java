/*
 * class to supply a random password 
 */

package com.epam.lambdaexpressions.supplier;

import java.util.Random;

/**
 * The Class Password.
 */
public class Password {

  /** The passkey. */
  private int passkey;

  /** The random number. */
  private Random randomNumber;

  /**
   * Instantiates a new password.
   */
  public Password() {
    randomNumber = new Random(1000);
    passkey = randomNumber.nextInt();
  }

  /**
   * Gets the password.
   *
   * @return password
   */
  public int getPassword() {
    return passkey;
  }
}