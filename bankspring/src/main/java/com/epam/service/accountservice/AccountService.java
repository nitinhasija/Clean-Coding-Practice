/**
 * 
 */

package com.epam.service.accountservice;

import com.epam.entities.Account;
import com.epam.entities.Customer;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidTransactionException;

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
   * Gets the customer id.
   *
   * @param accountNumber the account number
   * @return the customer id
   * @throws AccountNotFoundException the account not found exception
   */
  int getCustomerId(int accountNumber) throws AccountNotFoundException;

  /**
   * Deposite.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @throws InvalidTransactionException the invalid transaction exception
   * @throws AccountNotFoundException    the account not found exception
   */
  void deposit(int accountNumber, double amount)
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
