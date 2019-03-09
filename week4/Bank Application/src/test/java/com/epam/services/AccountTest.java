/**
 * This class tests the functionality of account service class.
 */

/*TO DO: 
 * 1. Test whether the account is created or not.
 * 2. Test whether account exists or not
 * 3. Test whether account is deleted or not 
 */

package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.bank.exceptions.AccountNotFoundException;
import com.epam.bank.exceptions.InvalidCustomerException;
import com.epam.bank.model.Account;
import com.epam.bank.model.Customer;
import com.epam.bank.services.AccountServices;
import com.epam.daoimplement.AccountDatabase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class AccountTesting.
 * 
 * @author Nitin_Hasija
 */
class AccountTest {

  /** The account services. */
  private static AccountServices accountServices;

  /** The customer. */
  private static Customer customer;

  /** The account DB. */
  private static AccountDatabase accountDB;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    accountDB = new AccountDatabase();
    accountServices = new AccountServices(accountDB);
    customer = new Customer();
    customer.setName("abcd");
    customer.setEmailId("abc@email.com");
    customer.setMobileNumber(9054637182L);
  }

  /*
   * Test account creation for valid customer
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for account creation for a valid customr")
  public void testAccountCreationForValidCustomer() throws InvalidCustomerException {
    String expectedName = "abcd";
    Account account = accountServices.createAccount(customer);
    assertEquals(expectedName, account.getCustomer().getName());

  }

  /*
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
  public void testForValidAccount() throws AccountNotFoundException {
    Account account = accountServices.createAccount(customer);
    assertNotNull(accountServices.getAccountByNumber(account.getAccountNumber()));
  }

  /*
   * Test account deletion for valid account
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("Test for valid account deletion")
  public void testValidAccountDeletion() throws AccountNotFoundException {
    Account account = accountServices.createAccount(customer);
    assertTrue(accountServices.deleteAccount(account));
  }

  /*
   * Test account deletion for invalid account
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("Test for invalid account deletion")
  public void testInValidAccountDeletion() throws AccountNotFoundException {
    Account account = null;
    assertThrows(AccountNotFoundException.class, () -> accountServices.deleteAccount(account));
  }
}
