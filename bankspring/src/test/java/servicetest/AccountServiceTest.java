package servicetest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import com.epam.daointerface.AccountDao;
import com.epam.entities.Account;
import com.epam.entities.Customer;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidTransactionException;
import com.epam.service.accountservice.AccountServicesImpl;
import com.epam.service.transactionvalidation.TransactionValidation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * The Class AccountServiceTest.
 *
 * @author Nitin_Hasija
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AccountServiceTest {

  /** The mock dao. */
  @Mock
  private AccountDao mockDao;

  /** The mock validation. */
  @Mock
  private TransactionValidation mockValidation;

  /** The account service. */
  @InjectMocks
  private AccountServicesImpl accountService;

  /** The account. */
  private Account account;

  /** The customer. */
  private Customer customer;

  /** The account number. */
  private static int accountNumber;

  /** The amount. */
  private static double amount;

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  public static void setUp() throws Exception {
    MockitoAnnotations.initMocks(AccountServiceTest.class);
    accountNumber = 7965;
    amount = 100.0;
  }

  /**
   * Test create account.
   */
  @Test
  @DisplayName("test for account creation")
  public void testCreateAccount() {
    doNothing().when(mockDao).saveAccount(any(Account.class));
    assertDoesNotThrow(() -> accountService.createAccount(customer));
  }

  /**
   * Test account details.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test for account details")
  public void testAccountDetails() throws AccountNotFoundException {
    int accountNumber = 101;
    account = new Account();
    when(mockDao.getAccountByAccountNumber(any(Integer.class))).thenReturn(account);
    assertNotNull(accountService.getAccountByNumber(accountNumber));
  }

  /**
   * Test account deletion.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test for account deletion")
  public void testAccountDeletion() throws AccountNotFoundException {
    doNothing().when(mockDao).deleteAccount(any(Integer.class));
    assertDoesNotThrow(() -> accountService.deleteAccount(any(Integer.class)));
  }

  /**
   * Test invalid account deletion.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test for invalid account deletion")
  public void testInvalidAccountDeletion() throws AccountNotFoundException {
    doThrow(AccountNotFoundException.class).when(mockDao).deleteAccount(any(Integer.class));
    assertThrows(AccountNotFoundException.class,
        () -> accountService.deleteAccount(any(Integer.class)));
  }

  /**
   * Test valid deposit amount.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test valid amount to deposite")
  public void testValidDepositAmount() throws AccountNotFoundException {
    doNothing().when(mockDao).depositAmount(any(Integer.class), any(Double.class));
    when(mockValidation.isValidDepositAmount(any(Double.class))).thenReturn(true);

    assertDoesNotThrow(() -> accountService.deposit(accountNumber, amount));
  }

  /**
   * Test in valid deposit amount.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test inValid amount to deposite")
  public void testInValidDepositAmount() throws AccountNotFoundException {
    when(mockValidation.isValidDepositAmount(any(Double.class))).thenReturn(false);

    assertThrows(InvalidTransactionException.class,
        () -> accountService.deposit(accountNumber, amount));
  }

  /**
   * Test valid withdraw amount.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test valid amount to withdraw")
  public void testValidWithdrawAmount() throws AccountNotFoundException {
    account = new Account();
    when(accountService.getAccountByNumber(any(Integer.class))).thenReturn(account);
    doNothing().when(mockDao).withdrawAmount(any(Integer.class), any(Double.class));
    when(mockValidation.isValidWithdrawAmount(any(Account.class), any(Double.class)))
        .thenReturn(true);

    assertDoesNotThrow(() -> accountService.withdraw(accountNumber, amount));
  }

  /**
   * Test invalid withdraw amount.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test Invalid amount to withdraw")
  public void testInvalidWithdrawAmount() throws AccountNotFoundException {
    account = new Account();
    when(mockValidation.isValidWithdrawAmount(any(Account.class), any(Double.class)))
        .thenReturn(false);
    assertThrows(InvalidTransactionException.class,
        () -> accountService.withdraw(accountNumber, amount));
  }

  /**
   * Test id for invalid account.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test customer Id for invalid account")
  public void testIdForInvalidAccount() throws AccountNotFoundException {
    doThrow(AccountNotFoundException.class).when(mockDao)
        .getAccountByAccountNumber(any(Integer.class));
    assertThrows(AccountNotFoundException.class, () -> accountService.getCustomerId(accountNumber));
  }

  /**
   * Test id for valid account.
   *
   * @throws AccountNotFoundException the account not found exception
   */
  @Test
  @DisplayName("test customer id for valid account")
  public void testIdForValidAccount() throws AccountNotFoundException {
    customer = new Customer();
    account = new Account(customer);
    when(mockDao.getAccountByAccountNumber(any(Integer.class))).thenReturn(account);
    assertDoesNotThrow(() -> accountService.getCustomerId(accountNumber));
  }
}
