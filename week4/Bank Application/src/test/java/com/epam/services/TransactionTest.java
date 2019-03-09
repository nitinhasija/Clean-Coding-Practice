/**
 * Test the transactions performed in the account
 */

//TO DO 1.check whether account exists or not
// 2. credit the amount when account exists
// 3. Debt the amount more than balance
// 4. Debt amount less than or equal to balance

package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.bank.exceptions.InvalidCustomerException;
import com.epam.bank.exceptions.InvalidTransactionException;
import com.epam.bank.model.Account;
import com.epam.bank.model.Customer;
import com.epam.bank.services.Transaction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class TransactionTest.
 *
 * @author Nitin_Hasija
 */
class TransactionTest {

  /** The customer. */
  private static Customer customer;

  /** The account. */
  private static Account account;

  /** The transaction. */
  private static Transaction transaction;

  /** The amount. */
  private double amount;

  /**
   * initialize data members.
   */
  @BeforeAll
  public static void init() {
    customer = new Customer();
    customer.setName("abcd");
    customer.setEmailId("abc@email.com");
    customer.setMobileNumber(9054637182L);
    account = new Account(customer);
    transaction = new Transaction(account);
  }

  /**
   * In valid credit.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid credit amount")
  public void inValidCredit() throws InvalidCustomerException {
    amount = -1.0;
    assertThrows(InvalidTransactionException.class, () -> transaction.credit(amount));
  }

  /**
   * Invalid debit.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid debit amount")
  public void invalidDebit() throws InvalidCustomerException {
    amount = -1.0;
    assertThrows(InvalidTransactionException.class, () -> transaction.debit(amount));
  }

  /**
   * Valid credit.
   *
   * @throws InvalidCustomerException    the invalid customer exception
   * @throws InvalidTransactionException the invalid transaction exception
   */
  @Test
  @DisplayName("Test for valid credit amount")
  public void validCredit() throws InvalidCustomerException, InvalidTransactionException {
    amount = 10;
    double prevAmount = account.getBalance();
    transaction.credit(amount);
    double actualAmount = account.getBalance();
    double expextedAmount = prevAmount + amount;
    assertEquals(expextedAmount, actualAmount);
  }

  /**
   * Valid debit.
   *
   * @throws InvalidCustomerException    the invalid customer exception
   * @throws InvalidTransactionException the invalid transaction exception
   */
  @Test
  @DisplayName("Test for valid debit amount")
  public void validDebit() throws InvalidCustomerException, InvalidTransactionException {
    double amount = 10;
    account.setBalance(100);
    double prevAmount = account.getBalance();
    transaction.debit(amount);
    double actualAmount = account.getBalance();
    double expextedAmount = prevAmount - amount;
    assertEquals(expextedAmount, actualAmount);
  }
}
