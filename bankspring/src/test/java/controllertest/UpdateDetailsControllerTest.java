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

import com.epam.controllers.UpdateDetailsController;
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
 * The Class UpdateDetailsControllerTest.
 *
 * @author Nitin_Hasija
 */
public class UpdateDetailsControllerTest {

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
  private UpdateDetailsController pdateDetailsController;

  /** The action. */
  private static String action;

  /** The name. */
  private static String name;

  /** The email. */
  private static String emailId;

  /** The mobile number. */
  private static String mobileNumber;

  /** The account number. */
  private static String accountNumber;

  /** The expected view name. */
  private static String expectedViewName;

  /**
   * Inits the.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(pdateDetailsController).setSingleView(mockView)
        .build();
  }

  /**
   * Sets the up.
   */
  @BeforeAll
  public static void init() {
    action = "/updateCustomerDetails";
    name = "Nitin";
    emailId = "abc@gmail.com";
    mobileNumber = "9034671718";
    accountNumber = "1234567";
    expectedViewName = "updateCustomerDetails";
  }

  /**
   * Try block test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("try block test")
  public void tryBlockTest() throws Exception {

    when(customerService.updateCustomerDetails(any(Integer.class), any(String.class),
        any(String.class), any(Long.class))).thenReturn(true);
    when(accountService.getCustomerId(any(Integer.class))).thenReturn(any(Integer.class));

    mockMvc
        .perform(post(action).param("name", name).param("emailId", emailId)
            .param("mobileNumber", mobileNumber).param("accountNumber", accountNumber)
            .flashAttr("model", model))
        .andExpect(status().isOk())
        .andExpect(model().attribute("customerDetailsUpdateStatus", ConstantUtils.UPDATE_STATUS))
        .andExpect(view().name(expectedViewName));
  }

  /**
   * Catch block test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("catch block test")
  public void catchBlockTest() throws Exception {

    doThrow(new AccountNotFoundException("Sorry!! Account Not Found.")).when(accountService)
        .getCustomerId(any(Integer.class));

    mockMvc
        .perform(post(action)
            .param("name", name).param("emailId", emailId).param("mobileNumber", mobileNumber)
            .param("accountNumber", accountNumber).flashAttr("model", model))
        .andExpect(status().isOk())
        .andExpect(
            model().attribute("customerDetailsUpdateStatus", ConstantUtils.ACCOUNT_NOT_FOUND))
        .andExpect(view().name(expectedViewName));
  }
}
