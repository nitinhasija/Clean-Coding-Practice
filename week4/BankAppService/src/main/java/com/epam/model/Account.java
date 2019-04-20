/**
 *  Account model class 
 */

package com.epam.model;

import com.epam.util.AccountNumberGenerator;

/**
 * The Class Account.
 *
 * @author Nitin_Hasija
 */

public class Account {

  /** The account number. */
  private int accountNumber;
  /** The customer. */
  private Customer customer;

  /** The balance. */
  private double balance;

  /**
   * Instantiates a new account.
   *
   * @param customer the customer
   */
  public Account(Customer customer) {
    this.customer = customer;
    accountNumber = AccountNumberGenerator.getAccountNumber();
    balance = 0.0;
  }

  /**
   * Gets the account number.
   *
   * @return the accountNumber
   */
  public int getAccountNumber() {
    return accountNumber;
  }

  /**
   * Gets the balance.
   *
   * @return the balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Sets the balance.
   *
   * @param currentBalance the currentBalance to set
   */
  public void setBalance(double currentBalance) {
    this.balance = currentBalance;
  }

  /**
   * Gets the customer.
   *
   * @return customer object
   */
  public int getCustomerId() {
    return customer.getId();
  }
}
