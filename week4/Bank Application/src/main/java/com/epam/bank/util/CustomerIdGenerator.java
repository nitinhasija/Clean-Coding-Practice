/**
 * CustomerIdGenerator Class.
 */

package com.epam.bank.util;

import java.util.Random;

/**
 * The Class CustomerIdGenerator.
 *
 * @author Nitin_Hasija
 */
public class CustomerIdGenerator {

  /** The customer id. */
  static int customerId;

  static {
    customerId = new Random(10000).nextInt();
  }

  private CustomerIdGenerator() {
  }

  /**
   * Gets the customer id.
   *
   * @return customer_id
   */
  public static int getCustomerId() {
    return customerId++;
  }
}
