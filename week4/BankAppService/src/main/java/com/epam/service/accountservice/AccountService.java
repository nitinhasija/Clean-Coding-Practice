/**
 * 
 */

package com.epam.service.accountservice;

import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidTransactionException;
import com.epam.model.Account;
import com.epam.model.Customer;

/**
 * The Interface AccountServiceInterface.
 *
 * @author Nitin_Hasija
 */
public interface AccountService {

  /**
   * Creates the account.
   *
   * @param customer the customer
   * @return the account
   */
  Account createAccount(Customer customer);

  /**
   * Delete account.
   *
   * @param accountNumber the account number
   * @throws AccountNotFoundException the account not found exception
   */
  void deleteAccount(int accountNumber) throws AccountNotFoundException;

  /**
   * Gets the account by number.
   *
   * @param accountNumber the account number
   * @return the account by number
   * @throws AccountNotFoundException the account not found exception
   */
  Account getAccountByNumber(int accountNumber) throws AccountNotFoundException;

  /**
   * Deposite.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @throws InvalidTransactionException the invalid transaction exception
   * @throws AccountNotFoundException    the account not found exception
   */
  void deposite(int accountNumber, double amount)
      throws InvalidTransactionException, AccountNotFoundException;

  /**
   * Withdraw.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @throws InvalidTransactionException the invalid transaction exception
   * @throws AccountNotFoundException    the account not found exception
   */
  void withdraw(int accountNumber, double amount)
      throws InvalidTransactionException, AccountNotFoundException;
}
