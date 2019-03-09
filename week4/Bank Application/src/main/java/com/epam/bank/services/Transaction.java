/**
 * This class performs transactions related activities 
 */

package com.epam.bank.services;

import com.epam.bank.exceptions.InvalidTransactionException;
import com.epam.bank.model.Account;

/**
 * The Class Transaction.
 *
 * @author Nitin_Hasija
 */
public class Transaction {

  /** The account. */
  private Account account;

  /**
   * Instantiates a new transaction.
   *
   * @param account the account
   */
  public Transaction(Account account) {
    this.account = account;
  }

  /**
   * Credit.
   *
   * @param amount to deposite in account
   * @throws InvalidTransactionException the invalid transaction exception
   */
  public void credit(double amount) throws InvalidTransactionException {
    if (amount < 0) {
      throw new InvalidTransactionException("Invalid Transaction Exception");
    } else {
      double previousAmount = account.getBalance();
      account.setBalance(previousAmount + amount);
    }
  }

  /**
   * Debit.
   *
   * @param amount to credit from account
   * @throws InvalidTransactionException the invalid transaction exception
   */
  public void debit(double amount) throws InvalidTransactionException {
    double previousAmount = account.getBalance();

    if (amount < 0 || previousAmount < amount) {
      throw new InvalidTransactionException("low balance");
    } else {
      account.setBalance(previousAmount - amount);
    }
  }
}