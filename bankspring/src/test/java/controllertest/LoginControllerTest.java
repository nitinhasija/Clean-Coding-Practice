/**
 * 
 */

package controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.epam.controllers.LoginController;
import javax.servlet.http.HttpSession;
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
 * The Class LoginControllerTest.
 *
 * @author Nitin_Hasija
 */
public class LoginControllerTest {

  /** The mock mvc. */
  private MockMvc mockMvc;

  /** The model. */
  @Mock
  private Model model;

  /** The session. */
  @Mock
  private HttpSession session;

  /** The mock view. */
  @Mock
  private View mockView;

  /** The login controller. */
  @InjectMocks
  private LoginController loginController;

  /** The username. */
  private static String username;

  /** The password. */
  private static String password;

  /** The action. */
  private static String action;

  /** The expected view name. */
  private String expectedViewName;

  /**
   * Sets the up before class.
   */
  @BeforeAll
  public static void setUpBeforeClass() {
    action = "/login";
  }

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @BeforeEach
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(loginController).setSingleView(mockView).build();
    doNothing().when(session).setAttribute(any(String.class), any(String.class));
  }

  /**
   * Test if condition.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test if condition")
  public void testIfCondition() throws Exception {
    username = "admin";
    password = "12345";
    expectedViewName = "welcomePage";

    mockMvc
        .perform(post(action).param("username", username).param("password", password)
            .flashAttr("session", session).flashAttr("model", model))
        .andExpect(status().isOk()).andExpect(view().name(expectedViewName));
  }

  /**
   * Test else condition.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("Test else condition")
  public void testElseCondition() throws Exception {
    username = "username";
    password = "login";
    expectedViewName = "login";

    mockMvc
        .perform(post(action).param("username", username).param("password", password)
            .flashAttr("session", session).flashAttr("model", model))
        .andExpect(status().isOk()).andExpect(view().name(expectedViewName));
  }
}
