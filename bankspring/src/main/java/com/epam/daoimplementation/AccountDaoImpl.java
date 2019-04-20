/**
* AccountDao implementation
*/

package com.epam.daoimplementation;

import com.epam.daointerface.AccountDao;
import com.epam.entities.Account;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.repository.AccountRepository;
import com.epam.util.ConstantUtils;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class AccountDatabase.
 *
 * @author Nitin_Hasija
 */
@Component
public class AccountDaoImpl implements AccountDao {

  @Autowired
  public AccountRepository accountRepo;

  /** The supplier. */
  private Supplier<AccountNotFoundException> supplier = () -> new AccountNotFoundException(
      ConstantUtils.ACCOUNT_NOT_FOUND);

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.dao.AccountDao#saveAccount(com.epam.model.Account)
   */
  @Override
  public void saveAccount(Account account) {
    accountRepo.save(account);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#deleteAccount(com.epam.model.Account)
   */
  @Override
  public void deleteAccount(int accountNumber) throws AccountNotFoundException {
    Account account = getAccountByAccountNumber(accountNumber);
    accountRepo.delete(account);

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.AccountDao#getAccountByAccountNumber(int)
   */
  @Override
  public Account getAccountByAccountNumber(int accountNumber) throws AccountNotFoundException {
    Optional<Account> account = accountRepo.findById(accountNumber);
    if (account.isPresent()) {
      return account.get();
    } else {
      throw supplier.get();
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
    Account account = getAccountByAccountNumber(accountNumber);
    double previousAmount = account.getBalance();
    account.setBalance(previousAmount + amount);
    accountRepo.save(account);
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
    accountRepo.save(account);
  }
}
