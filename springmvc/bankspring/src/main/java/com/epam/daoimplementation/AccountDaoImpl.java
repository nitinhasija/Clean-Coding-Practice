/**
* AccountDao implementation
*/

package com.epam.daoimplementation;

import com.epam.daointerface.AccountDao;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.model.Account;
import com.epam.util.ConstantUtils;
import com.epam.util.PersistenceUtils;

import java.util.function.Supplier;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

/**
 * The Class AccountDatabase.
 *
 * @author Nitin_Hasija
 */
@Component
public final class AccountDaoImpl implements AccountDao {

  /** The entity manager. */
  private EntityManager entityManager;

  /** The supplier. */
  private Supplier<AccountNotFoundException> supplier = () -> new AccountNotFoundException(
      ConstantUtils.ACCOUNT_NOT_FOUND);

  /**
   * Instantiates a new account database.
   */
  public AccountDaoImpl() {
    entityManager = PersistenceUtils.getEntityManager();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.dao.AccountDao#saveAccount(com.epam.model.Account)
   */
  @Override
  public void saveAccount(Account account) {
    entityManager.persist(account);
    entityManager.getTransaction().commit();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#deleteAccount(com.epam.model.Account)
   */
  @Override
  public void deleteAccount(final Account account) throws AccountNotFoundException {
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
  public void depositAmount(final int accountNumber, final double amount)
      throws AccountNotFoundException {
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