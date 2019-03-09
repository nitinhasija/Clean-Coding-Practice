/**
 * Account Dao implementation
 */

package com.epam.daoimplement;

import com.epam.bank.dao.AccountDao;
import com.epam.bank.exceptions.AccountNotFoundException;
import com.epam.bank.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The Class AccountDatabase.
 *
 * @author Nitin_Hasija
 */
public class AccountDatabase implements AccountDao {

  /** The account list. */
  List<Account> accountList;

  /**
   * Account exists.
   *
   * @param id the id
   * @return the predicate
   */
  private Predicate<Account> accountExists(long id) {
    return (account -> account.getAccountNumber() == id);
  }

  /** The supplier. */
  private Supplier<AccountNotFoundException> supplier = () -> {
    return new AccountNotFoundException("Account Not Found Exception");
  };

  /**
   * Instantiates a new account database.
   */
  public AccountDatabase() {
    accountList = new ArrayList<Account>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#saveAccount(com.epam.bank.model.Account)
   */
  @Override
  public void saveAccount(Account account) {
    accountList.add(account);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#deleteAccount(com.epam.bank.model.Account)
   */
  @Override
  public boolean deleteAccount(Account account) throws AccountNotFoundException {
    if (accountList.contains(account)) {
      return accountList.remove(account);
    } else {
      throw new AccountNotFoundException("Account Not Found Exception");
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#getAccountByAccountNumber(long)
   */
  @Override
  public Account getAccountByAccountNumber(long accountNum) throws AccountNotFoundException {
    return accountList.stream().filter(accountExists(accountNum)).findAny().orElseThrow(supplier);
  }
}