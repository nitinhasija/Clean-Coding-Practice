/**
 * Account Interface
 */

package com.epam.bank.dao;

import com.epam.bank.exceptions.AccountNotFoundException;
import com.epam.bank.model.Account;

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
   * @param account the account
   * @return true, if successful
   * @throws AccountNotFoundException the account not found exception
   */
  boolean deleteAccount(Account account) throws AccountNotFoundException;

  /**
   * Gets the account by account number.
   *
   * @param accountNumber the account number
   * @return the account by account number
   * @throws AccountNotFoundException the account not found exception
   */
  Account getAccountByAccountNumber(long accountNumber) throws AccountNotFoundException;
}
