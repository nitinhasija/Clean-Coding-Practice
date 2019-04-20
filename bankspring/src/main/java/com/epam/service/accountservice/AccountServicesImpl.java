/**
 * Class to provide services to the account;
 */

package com.epam.service.accountservice;

import com.epam.daointerface.AccountDao;
import com.epam.entities.Account;
import com.epam.entities.Customer;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidTransactionException;
import com.epam.service.transactionvalidation.TransactionValidation;
import com.epam.util.ConstantUtils;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class AccountServices.
 *
 * @author Nitin_Hasija
 */
@Service
public class AccountServicesImpl implements AccountService {

  /** The account db. */
  @Autowired
  private AccountDao accountDb;

  /** The validation. */
  @Autowired
  private TransactionValidation validation;

  /** The supplier. */
  private Supplier<InvalidTransactionException> supplier = () -> new InvalidTransactionException(
      ConstantUtils.INVALID_TRANSACTION_AMOUNT);

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.accountservice.AccountService#createAccount(com.epam.model.
   * Customer)
   */
  @Override
  public Account createAccount(Customer customer) {
    Account account = new Account(customer);
    accountDb.saveAccount(account);
    return account;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.accountservice.AccountServiceInterface#deleteAccount(int)
   */
  public void deleteAccount(int accountNumber) throws AccountNotFoundException {
    accountDb.deleteAccount(accountNumber);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.accountservice.AccountServiceInterface#getAccountByNumber(
   * int)
   */
  public Account getAccountByNumber(int accountNumber) throws AccountNotFoundException {
    return accountDb.getAccountByAccountNumber(accountNumber);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.accountservice.AccountServiceInterface#deposite(int,
   * double)
   */
  @Override
  public void deposit(int accountNumber, double amount)
      throws InvalidTransactionException, AccountNotFoundException {
    if (validation.isValidDepositAmount(amount)) {
      accountDb.depositAmount(accountNumber, amount);
    } else {
      throw supplier.get();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.accountservice.AccountServiceInterface#withdraw(int,
   * double)
   */
  @Override
  public void withdraw(int accountNumber, double amount)
      throws InvalidTransactionException, AccountNotFoundException {
    Account account = getAccountByNumber(accountNumber);
    if (validation.isValidWithdrawAmount(account, amount)) {
      accountDb.withdrawAmount(accountNumber, amount);
    } else {
      throw supplier.get();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.accountservice.AccountService#getCustomerId(int)
   */
  @Override
  public int getCustomerId(int accountNumber) throws AccountNotFoundException {
    return accountDb.getAccountByAccountNumber(accountNumber).getCustomerId();
  }
}
