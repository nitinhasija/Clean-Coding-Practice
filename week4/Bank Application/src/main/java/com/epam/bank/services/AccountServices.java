/**
 * Class to provide services to the account;
 */

package com.epam.bank.services;

import com.epam.bank.dao.AccountDao;
import com.epam.bank.exceptions.AccountNotFoundException;
import com.epam.bank.model.Account;
import com.epam.bank.model.Customer;

/**
 * The Class AccountServices.
 *
 * @author Nitin_Hasija
 */
public class AccountServices {

  
  /** The account db. */
  private AccountDao accountDb;

  /**
   * Instantiates a new account services.
   *
   * @param accountDb the account Db
   */
  public AccountServices(AccountDao accountDb) {
    this.accountDb = accountDb;
  }

  /**
   * Creates the account.
   *
   * @param customer the customer
   * @return the account
   */
  public Account createAccount(Customer customer) {
    Account account = new Account(customer);
    accountDb.saveAccount(account);
    return account;
  }

  /**
   * Delete account.
   *
   * @param account the account
   * @return true, if successful
   * @throws AccountNotFoundException the account not found exception
   */
  public boolean deleteAccount(Account account) throws AccountNotFoundException {
    return accountDb.deleteAccount(account);
  }

  /**
   * Gets the account by account number.
   *
   * @param accountNumber the account number
   * @return the account by account number
   * @throws AccountNotFoundException the account not found exception
   */
  public Account getAccountByNumber(long accountNumber) throws AccountNotFoundException {
    return accountDb.getAccountByAccountNumber(accountNumber);
  }
}
