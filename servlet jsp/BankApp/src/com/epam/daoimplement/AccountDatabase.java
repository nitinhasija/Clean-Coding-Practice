/**
 * Account Dao implementation
 */

package com.epam.daoimplement;

import com.epam.bank.dao.AccountDao;
import com.epam.bank.exceptions.AccountNotFoundException;
import com.epam.bank.model.Account;
import java.util.function.Supplier;

import javax.persistence.EntityManager;

/**
 * The Class AccountDatabase.
 *
 * @author Nitin_Hasija
 */
public class AccountDatabase implements AccountDao {

  /** The entity manager. */
  private static EntityManager entityManager;
  /** The obj. */
  private static AccountDatabase object;

  /** The supplier. */
  private Supplier<AccountNotFoundException> supplier = () -> new AccountNotFoundException(
      "Sorry!! Account Not Found.");

  /**
   * Instantiates a new account database.
   */
  private AccountDatabase() {
  }

  /**
   * Gets the single instance of AccountDatabase.
   *
   * @return single instance of AccountDatabase
   */
  public static AccountDatabase getInstance() {
    if (object == null) {
      object = new AccountDatabase();
      entityManager = PersistenceUtils.getEntityManager();
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
    entityManager.persist(account);
    entityManager.getTransaction().commit();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#deleteAccount(com.epam.bank.model.Account)
   */
  @Override
  public void deleteAccount(Account account) throws AccountNotFoundException {
    if (entityManager.find(Account.class, account.getAccountNumber()) == null) {
      throw supplier.get();
    }
    entityManager.getTransaction().begin();
    entityManager.remove(account);
    entityManager.getTransaction().commit();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#getAccountByAccountNumber(int)
   */
  @Override
  public Account getAccountByAccountNumber(int accountNumber) throws AccountNotFoundException {
    Account account = entityManager.find(Account.class, accountNumber);
    if (account == null) {
      throw supplier.get();
    } else {
      return account;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#creditAmount(int, double)
   */
  @Override
  public void depositeAmount(int accountNumber, double amount) throws AccountNotFoundException {
    Account account = entityManager.find(Account.class, accountNumber);
    if (account == null) {
      throw supplier.get();
    } else {
      entityManager.getTransaction().begin();
      double previousAmount = account.getBalance();
      account.setBalance(previousAmount + amount);
      entityManager.getTransaction().commit();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#debitAmount(int, double)
   */
  @Override
  public void withdrawAmount(int accountNumber, double amount) throws AccountNotFoundException {
    Account account = entityManager.find(Account.class, accountNumber);
    if (account == null) {
      throw supplier.get();
    } else {
      entityManager.getTransaction().begin();
      double previousAmount = account.getBalance();
      account.setBalance(previousAmount - amount);
      entityManager.getTransaction().commit();
    }
  }
}