/**
 * This class tests the functionality of account service class.
 */

/*TO DO: 
 * 1. Test whether the account is created or not.
 * 2. Test whether account exists or not
 * 3. Test whether account is deleted or not 
 */

package com.epam.servicestests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.exceptions.InvalidTransactionException;
import com.epam.model.Account;
import com.epam.model.Customer;
import com.epam.service.accountservice.AccountService;
import com.epam.service.accountservice.AccountServicesImpl;
import com.epam.service.customerservice.CustomerService;
import com.epam.service.customerservice.CustomerServicesImpl;

/**
 * The Class AccountTesting.
 * 
 * @author Nitin_Hasija
 */
class AccountTest {

  /** The account services. */
  private static AccountService accountServices;

  /** The customer. */
  private static Customer customer;

  /** The amount. */
  private double amount;

  /** The account. */
  static Account account;

  /** The customer services. */
  private static CustomerService customerServices;

  /**
   * Inits the.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @BeforeAll
  public static void init() throws InvalidCustomerException {
    accountServices = new AccountServicesImpl();
    customerServices = new CustomerServicesImpl();
    customer = customerServices.createCustomer("Abc Sharma", "abc@gmail.com", 9034681811L);
  }

  /**
   * Test account creation for valid customer.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for account creation for a valid customr")
  public void testAccountCreationForValidCustomer() throws InvalidCustomerException {
    account = accountServices.createAccount(customer);
    int expectedCustomerId = customer.getId();
    assertEquals(expectedCustomerId, account.getCustomerId());

  }

  /**
   * Test for invalid account.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("Test if invalid account number exists")
  public void testForInvalidAccount() throws AccountNotFoundException {
    assertThrows(AccountNotFoundException.class, () -> accountServices.getAccountByNumber(-1));
  }

  /**
   * Test for valid account.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("Test if valid account number exists")
  public void testForValidAccountExists() throws AccountNotFoundException {
    account = accountServices.createAccount(customer);
    assertNotNull(accountServices.getAccountByNumber(account.getAccountNumber()));
  }

  /**
   * Test valid account deletion.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("Test for valid account deletion")
  public void testValidAccountDeletion() throws AccountNotFoundException {
    account = accountServices.createAccount(customer);
    assertDoesNotThrow(() -> accountServices.deleteAccount(account.getAccountNumber()));
  }

  /**
   * Test in valid account deletion.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("Test for invalid account deletion")
  public void testInValidAccountDeletion() throws AccountNotFoundException {
    assertThrows(AccountNotFoundException.class, () -> accountServices.deleteAccount(-1));
  }

  /**
   * In valid deposite.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid deposite amount")
  public void inValidDeposite() throws InvalidCustomerException {
    account = accountServices.createAccount(customer);
    amount = -1.0;
    assertThrows(InvalidTransactionException.class,
        () -> accountServices.deposite(account.getAccountNumber(), amount));
  }

  /**
   * Valid deposite.
   *
   * @throws InvalidTransactionException the invalid transaction exception
   * @throws AccountNotFoundException    the account not found exception
   */
  @Test
  @DisplayName("Test for valid deposite amount")
  public void validDeposite() throws InvalidTransactionException, AccountNotFoundException {
    account = accountServices.createAccount(customer);
    amount = 10;
    double prevAmount = account.getBalance();
    accountServices.deposite(account.getAccountNumber(), amount);

    double actualAmount = account.getBalance();
    double expextedAmount = prevAmount + amount;
    assertEquals(expextedAmount, actualAmount);
  }

  /**
   * Invalid withdraw.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid withdraw amount")
  public void invalidWithdraw() throws InvalidCustomerException, AccountNotFoundException {
    account = accountServices.createAccount(customer);
    amount = -1.0;
    assertThrows(InvalidTransactionException.class,
        () -> accountServices.withdraw(account.getAccountNumber(), amount));
  }

  /**
   * Low withdraw amount.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for low withdraw amount")
  public void lowWithdrawAmount() throws InvalidCustomerException, AccountNotFoundException {
    account = accountServices.createAccount(customer);
    account.setBalance(100.0);
    amount = 200.0;
    assertThrows(InvalidTransactionException.class,
        () -> accountServices.withdraw(account.getAccountNumber(), amount));
  }

  /**
   * Valid withdraw.
   *
   * @throws InvalidTransactionException the invalid transaction exception
   * @throws AccountNotFoundException    the account not found exception
   */
  @Test
  @DisplayName("Test for valid withdraw amount")
  public void validWithdraw() throws InvalidTransactionException, AccountNotFoundException {
    account = accountServices.createAccount(customer);
    double amount = 10;
    account.setBalance(100);
    double prevAmount = account.getBalance();
    accountServices.withdraw(account.getAccountNumber(), amount);

    double actualAmount = account.getBalance();
    double expextedAmount = prevAmount - amount;
    assertEquals(expextedAmount, actualAmount);
  }
}
