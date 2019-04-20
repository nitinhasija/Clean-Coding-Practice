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

import com.epam.controllers.DeleteAccountController;
import com.epam.exceptions.AccountNotFoundException;
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
 * The Class DeleteAccountControllerTest.
 *
 * @author Nitin_Hasija
 */
public class DeleteAccountControllerTest {

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
  private DeleteAccountController deleteAccountController;

  /** The action. */
  private static String action;

  /** The account number. */
  private static String accountNumber;

  /** The expected view name. */
  private static String expectedViewName;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    action = "/deleteAccount";
    accountNumber = "12345";
    expectedViewName = "deleteAccount";
  }

  /**
   * Inits the.
   */
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(deleteAccountController).setSingleView(mockView)
        .build();
  }

  /**
   * Controller test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("delete account controller test")
  public void tryBlockTest() throws Exception {
    doNothing().when(accountService).deleteAccount(any(Integer.class));

    mockMvc.perform(post(action).param("accountNumber", accountNumber).flashAttr("model", model))
        .andExpect(status().isOk())
        .andExpect(model().attribute("accountDeletionStatus", ConstantUtils.ACCOUNT_DELETION))
        .andExpect(view().name(expectedViewName));
  }

  /**
   * Exception test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("test exception in controller")
  public void catchBlockTest() throws Exception {
    doThrow(new AccountNotFoundException(ConstantUtils.ACCOUNT_NOT_FOUND)).when(accountService)
        .deleteAccount(any(Integer.class));

    mockMvc.perform(post(action).param("accountNumber", accountNumber).flashAttr("model", model))
        .andExpect(status().isOk())
        .andExpect(model().attribute("accountDeletionStatus", ConstantUtils.ACCOUNT_NOT_FOUND))
        .andExpect(view().name(expectedViewName));
  }
}
