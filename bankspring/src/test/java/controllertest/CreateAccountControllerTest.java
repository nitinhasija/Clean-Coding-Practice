/**
 * 
 */

package controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.epam.controllers.CreateAccountController;
import com.epam.entities.Account;
import com.epam.entities.Customer;
import com.epam.exceptions.InvalidCustomerException;
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
 * The Class CreateAccountControllerTest.
 *
 * @author Nitin_Hasija
 */
public class CreateAccountControllerTest {

  /** The mock mvc. */
  private MockMvc mockMvc;

  /** The model. */
  @Mock
  private Model model;

  /** The mock view. */
  @Mock
  private View mockView;

  /** The customer service. */
  @Mock
  private CustomerService customerService;

  /** The account service. */
  @Mock
  private AccountService accountService;

  /** The create account controller. */
  @InjectMocks
  private CreateAccountController createAccountController;

  /** The action. */
  private static String action;

  /** The name. */
  private static String name;

  /** The email. */
  private static String email;

  /** The mobile number. */
  private static String mobileNumber;

  /** The account creation status. */
  private static String status;

  /** The expected view name. */
  private static String expectedViewName;

  /** The account number. */
  private static String accountNumber;

  /**
   * Inits the.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(createAccountController).setSingleView(mockView)
        .build();
  }

  /**
   * Sets the up.
   */
  @BeforeAll
  public static void init() {
    action = "/openAccount";
    name = "Nitin";
    email = "abc@gmail.com";
    mobileNumber = "9034671718";
    expectedViewName = "createAccount";
    accountNumber = "0";
  }

  /**
   * Try block test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("try block test")
  public void tryBlockTest() throws Exception {
    status = ConstantUtils.ACCOUNT_STATUS + accountNumber;

    Customer customer = new Customer();
    Account account = new Account();

    when(customerService.createCustomer(any(String.class), any(String.class), any(Long.class)))
        .thenReturn(customer);
    when(accountService.createAccount(any(Customer.class))).thenReturn(account);

    mockMvc
        .perform(post(action).param("name", name).param("email", email)
            .param("mobileNumber", mobileNumber).flashAttr("model", model))
        .andExpect(status().isOk()).andExpect(model().attribute("accountCreationStatus", status))
        .andExpect(view().name(expectedViewName));
  }

  /**
   * Catch block test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("catch block test in controller")
  public void catchBlockTest() throws Exception {
    status = ConstantUtils.INVALID_CUSTOMER_CREDENTIALS;
    
    when(customerService.createCustomer(any(String.class), any(String.class), any(Long.class)))
        .thenThrow(new InvalidCustomerException(status));

    mockMvc
        .perform(post(action).param("name", name).param("email", email)
            .param("mobileNumber", mobileNumber).flashAttr("model", model))
        .andExpect(status().isOk()).andExpect(model().attribute("accountCreationStatus", status))
        .andExpect(view().name(expectedViewName));
  }
}
