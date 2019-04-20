
package com.epam.daointerface;

import com.epam.entities.Account;
import com.epam.exceptions.AccountNotFoundException;

/**
 * The Interface AccountDao.
 *
 * @author Nitin_Hasija
 */

public interface AccountDao {

  /**
   * Save account.
   *
   * @param account the account
   */
  void saveAccount(Account account);

  /**
   * Delete account.
   *
   * @param accountNumber the account number
   * @throws AccountNotFoundException the account not found exception
   */
  void deleteAccount(int accountNumber) throws AccountNotFoundException;

  /**
   * Gets the account by account number.
   *
   * @param accountNumber the account number
   * @return the account by account number
   * @throws AccountNotFoundException the account not found exception
   */
  Account getAccountByAccountNumber(int accountNumber) throws AccountNotFoundException;

  /**
   * Credit amount.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @throws AccountNotFoundException the account not found exception
   */
  void depositAmount(int accountNumber, double amount) throws AccountNotFoundException;

  /**
   * Debit amount.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @throws AccountNotFoundException the account not found exception
   */
  void withdrawAmount(int accountNumber, double amount) throws AccountNotFoundException;
}
