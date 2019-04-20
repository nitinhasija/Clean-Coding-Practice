/**
 *  Account model class 
 */

package com.epam.entities;

import com.epam.util.AccountNumberGenerator;
import com.epam.util.ConstantUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class Account.
 *
 * @author Nitin_Hasija
 */

@Entity
@Table
public class Account {

  /** The account number. */
  @Id
  private int accountNumber;
  /** The customer. */
  @ManyToOne
  private Customer customer;

  /** The balance. */
  private double balance;

  /**
   * Instantiates a new account.
   */
  public Account() {
  }

  /**
   * Instantiates a new account.
   *
   * @param customer the customer
   */
  @Autowired
  public Account(Customer customer) {
    this.customer = customer;
    accountNumber = AccountNumberGenerator.getAccountNumber();
    balance = ConstantUtils.OPENING_BALANCE;
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
