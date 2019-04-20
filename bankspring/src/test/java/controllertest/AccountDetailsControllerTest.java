/**
 * 
 */

package controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.epam.controllers.AccountDetailsController;
import com.epam.entities.Account;
import com.epam.entities.Customer;
import com.epam.exceptions.AccountNotFoundException;
import com.epam.service.accountservice.AccountService;
import com.epam.service.customerservice.CustomerService;
import com.epam.util.ConstantUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

/**
 * The Class AccountDetailsControllerTest.
 *
 * @author Nitin_Hasija
 */
public class AccountDetailsControllerTest {
  /** The mock mvc. */
  private MockMvc mockMvc;

  /** The model. */
  @Mock
  private Model model;

  /** The mock view. */
  @Mock
  private View mockView;
  /** The account service. */
  @Mock
  private AccountService accountService;

  /** The customer service. */
  @Mock
  private CustomerService customerService;

  /** The account details controller. */
  @InjectMocks
  private AccountDetailsController accountDetailsController;

  /** The action. */
  private static String action;

  /** The account number. */
  private static String accountNumber;

  /** The expected view name. */
  private static String expectedViewName;

  /**
   * Sets the up before class.
   */
  @BeforeAll
  public static void setUpBeforeClass() {
    action = "/accountDetails";
    accountNumber = "12345";
    expectedViewName = "accountDetails";
  }

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(accountDetailsController).setSingleView(mockView)
        .build();
  }

  /**
   * Try block test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test try block of controller")
  public void tryBlockTest() throws Exception {
    Customer customer = new Customer();
    Account account = new Account(customer);

    when(accountService.getAccountByNumber(any(Integer.class))).thenReturn(account);
    when(customerService.getCustomerById(any(Integer.class))).thenReturn(customer);
    when(model.addAttribute(any(String.class), any(Integer.class))).thenReturn(model);
    when(model.addAttribute(any(String.class), any(String.class))).thenReturn(model);

    mockMvc.perform(post(action).param("accountNumber", accountNumber).flashAttr("model", model))
        .andExpect(status().isOk()).andExpect(view().name(expectedViewName));
  }

  /**
   * Catch block test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test exception in controller")
  public void catchBlockTest() throws Exception {
    doThrow(new AccountNotFoundException(ConstantUtils.ACCOUNT_NOT_FOUND)).when(accountService)
        .getAccountByNumber(any(Integer.class));

    mockMvc.perform(post(action).param("accountNumber", accountNumber).flashAttr("model", model))
        .andExpect(status().isOk())
        .andExpect(model().attribute("doesDetailsExists", ConstantUtils.ACCOUNT_NOT_FOUND))
        .andExpect(view().name(expectedViewName));
  }
}
