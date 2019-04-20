/**
 * Account Dao implementation
 */

package com.epam.daoimplementation;

import com.epam.daointerface.AccountDao;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The Class AccountDatabase.
 *
 * @author Nitin_Hasija
 */
public class AccountDaoImpl implements AccountDao {

  /** The account list. */
  private static List<Account> accountList;

  /** The obj. */
  private static AccountDaoImpl object;

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
  private Supplier<AccountNotFoundException> supplier = () -> new AccountNotFoundException(
      "Account Not Found Exception");

  /**
   * Instantiates a new account database.
   */
  private AccountDaoImpl() {
  }

  /**
   * Gets the single instance of AccountDatabase.
   *
   * @return single instance of AccountDatabase
   */
  public static AccountDaoImpl getInstance() {
    if (object == null) {
      accountList = new ArrayList<>();
      object = new AccountDaoImpl();
    }
    return object;
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
  public void deleteAccount(Account account) {
    accountList.remove(account);
  }

  /**
   * Gets the account by account number.
   *
   * @param accountNumber the account number
   * @return the account by account number
   * @throws AccountNotFoundException the account not found exception
   */
  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#getAccountByAccountNumber(long)
   */
  @Override
  public Account getAccountByAccountNumber(int accountNumber) throws AccountNotFoundException {
    return accountList.stream().filter(accountExists(accountNumber)).findAny()
        .orElseThrow(supplier);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#creditAmount(int, double)
   */
  @Override
  public void depositeAmount(int accountNumber, double amount) throws AccountNotFoundException {
    Account account = getAccountByAccountNumber(accountNumber);
    double previousAmount = account.getBalance();
    account.setBalance(previousAmount + amount);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#debitAmount(int, double)
   */
  @Override
  public void withdrawAmount(int accountNumber, double amount) throws AccountNotFoundException {
    Account account = getAccountByAccountNumber(accountNumber);
    double previousAmount = account.getBalance();
    account.setBalance(previousAmount - amount);
  }
}