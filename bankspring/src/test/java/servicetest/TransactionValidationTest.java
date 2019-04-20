/**
 * 
 */

package servicetest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.entities.Account;
import com.epam.service.transactionvalidation.TransactionValidation;
import com.epam.service.transactionvalidation.TransactionValidationImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class TransactionValidationTest.
 *
 * @author Nitin_Hasija
 */
public class TransactionValidationTest {

  /** The account. */
  private static Account account;

  /** The validation. */
  private static TransactionValidation validation;

  private static double amount;

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  public static void setUp() throws Exception {
    validation = new TransactionValidationImpl();
    account = new Account();
    account.setBalance(100.0);
  }

  /**
   * Test invalid deposit amount.
   */
  @Test
  @DisplayName("test for invalid deposit amount")
  public void testInvalidDepositAmount() {
    amount = -10.0;
    assertFalse(validation.isValidDepositAmount(amount));
  }

  /**
   * Test valid deposit amount.
   */
  @Test
  @DisplayName("test for deposite amount")
  public void testValidDepositAmount() {
    amount = 10.0;
    assertTrue(validation.isValidDepositAmount(amount));
  }

  /**
   * Test invalid withdraw amount.
   */
  @Test
  @DisplayName("test for invalid Withdraw amount")
  public void testInvalidWithdrawAmount() {
    amount = -10.0;
    assertFalse(validation.isValidWithdrawAmount(account, amount));
  }

  /**
   * Test insufficient withdraw amount.
   */
  @Test
  @DisplayName("test withdraw for low balance")
  public void testInsufficientWithdrawAmount() {
    amount = 500.0;
    assertFalse(validation.isValidWithdrawAmount(account, amount));
  }

  /**
   * Test valid withdraw amount.
   */
  @Test
  @DisplayName("test for valid Withdraw amount")
  public void testValidWithdrawAmount() {
    amount = 10.0;
    assertTrue(validation.isValidWithdrawAmount(account, amount));
  }
}
