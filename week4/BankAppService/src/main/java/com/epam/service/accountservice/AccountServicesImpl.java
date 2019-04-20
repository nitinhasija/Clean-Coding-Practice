/**
 * Class to provide services to the account;
 */

package com.epam.service.accountservice;

import com.epam.daoimplementation.AccountDaoImpl;
import com.epam.daointerface.AccountDao;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidTransactionException;
import com.epam.model.Account;
import com.epam.model.Customer;
import com.epam.service.transactionvalidation.TransactionValidation;
import com.epam.service.transactionvalidation.TransactionValidationImpl;
import com.epam.util.ConstantUtils;

import java.util.function.Supplier;

/**
 * The Class AccountServices.
 *
 * @author Nitin_Hasija
 */
public class AccountServicesImpl implements AccountService {

  /** The account db. */
  private AccountDao accountDb;

  /** The validation. */
  private TransactionValidation validation;

  /** The supplier. */
  private Supplier<InvalidTransactionException> supplier = () -> new InvalidTransactionException(
      ConstantUtils.INVALID_AMOUNT);

  /**
   * Instantiates a new account services impl.
   */
  public AccountServicesImpl() {
    accountDb = AccountDaoImpl.getInstance();
    validation = new TransactionValidationImpl();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.accountservice.AccountService#createAccount(com.epam.model.
   * Customer)
   */
  public Account createAccount(Customer customer) {
    Account account = new Account(customer);
    accountDb.saveAccount(account);
    return account;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.accountservice.AccountService#deleteAccount(int)
   */
  public void deleteAccount(int accountNumber) throws AccountNotFoundException {
    Account account = getAccountByNumber(accountNumber);
    accountDb.deleteAccount(account);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.accountservice.AccountService#getAccountByNumber(int)
   */
  public Account getAccountByNumber(int accountNumber) throws AccountNotFoundException {
    return accountDb.getAccountByAccountNumber(accountNumber);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.accountservice.AccountService#deposite(int, double)
   */
  public void deposite(int accountNumber, double amount)
      throws InvalidTransactionException, AccountNotFoundException {
    if (validation.isValidDepositeAmount(amount)) {
      accountDb.depositeAmount(accountNumber, amount);
    } else {
      throw supplier.get();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.accountservice.AccountService#withdraw(int, double)
   */
  public void withdraw(int accountNumber, double amount)
      throws InvalidTransactionException, AccountNotFoundException {
    Account account = getAccountByNumber(accountNumber);
    if (validation.isValidWithdrawAmount(account, amount)) {
      accountDb.withdrawAmount(accountNumber, amount);
    } else {
      throw supplier.get();
    }
  }
}
