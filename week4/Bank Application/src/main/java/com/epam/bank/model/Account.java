/**
 *  Account model class 
 */

package com.epam.bank.model;

import com.epam.bank.util.AccountNumberGenerator;

/**
 * The Class Account.
 *
 * @author Nitin_Hasija
 */
public class Account {

  /** The customer. */
  private final Customer customer;

  /** The balance. */
  private double balance;

  /** The account number. */
  private final long accountNumber;

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
  public long getAccountNumber() {
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
  public Customer getCustomer() {
    return customer;
  }
}
