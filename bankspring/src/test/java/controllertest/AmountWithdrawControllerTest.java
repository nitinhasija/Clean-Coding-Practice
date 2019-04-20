/**
 * 
 */

package controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.epam.controllers.AmountWithdrawController;
import com.epam.exceptions.InvalidTransactionException;
import com.epam.service.accountservice.AccountService;
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
 * The Class AmountWithdrawControllerTest.
 *
 * @author Nitin_Hasija
 */
public class AmountWithdrawControllerTest {
  /** The account service. */
  @Mock
  private AccountService accountService;

  /** The mock mvc. */
  private MockMvc mockMvc;

  /** The model. */
  @Mock
  private Model model;

  /** The mock view. */
  @Mock
  private View mockView;

  /** The delete account controller. */
  @InjectMocks
  private AmountWithdrawController amountWithdrawController;

  /** The action. */
  private static String action;

  /** The account number. */
  private static String accountNumber;

  /** The expected view name. */
  private static String expectedViewName;

  /** The amount. */
  private static String amount;

  /**
   * Sets the up before class.
   */
  @BeforeAll
  public static void setUpBeforeClass() {
    action = "/withdraw";
    accountNumber = "12345";
    expectedViewName = "withdrawAmount";
    amount = "100.0";
  }

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(amountWithdrawController).setSingleView(mockView)
        .build();
  }

  /**
   * Try block test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test try block")
  public void tryBlockTest() throws Exception {
    String modelValue = ConstantUtils.WITHDRAW_STATUS + amount;
    doNothing().when(accountService).withdraw(any(Integer.class), any(Double.class));

    mockMvc
        .perform(post(action).param("accountNumber", accountNumber).param("amount", amount)
            .flashAttr("model", model))
        .andExpect(model().attribute("amountWithdrawnStatus", modelValue))
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
    String message = ConstantUtils.INVALID_TRANSACTION_AMOUNT;
    doThrow(new InvalidTransactionException(message)).when(accountService)
        .withdraw(any(Integer.class), any(Double.class));

    mockMvc
        .perform(post(action).param("accountNumber", accountNumber).param("amount", amount)
            .flashAttr("model", model))
        .andExpect(status().isOk()).andExpect(model().attribute("amountWithdrawnStatus", message))
        .andExpect(view().name(expectedViewName));
  }
}
