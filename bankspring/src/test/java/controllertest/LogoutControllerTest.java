/**
 * 
 */

package controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.epam.controllers.LogoutController;
import javax.servlet.http.HttpSession;
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
 * The Class LogoutControllerTest.
 *
 * @author Nitin_Hasija
 */
public class LogoutControllerTest {

  /** The action. */
  private String action;

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
  private LogoutController logoutController;

  /** The expected view name. */
  private String expectedViewName;

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @BeforeEach
  public void setUp() throws Exception {
    action = "/logout";
    expectedViewName = "login";
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(logoutController).setSingleView(mockView).build();
  }

  /**
   * Test.
   *
   * @throws Exception the exception
   */
  @Test
  @DisplayName("logout test")
  public void test() throws Exception {
    mockMvc.perform(get(action).flashAttr("session", session)).andExpect(status().isOk())
        .andExpect(view().name(expectedViewName));
  }
}
