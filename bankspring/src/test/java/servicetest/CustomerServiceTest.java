/**
 * 
 */

package servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.epam.daointerface.CustomerDao;
import com.epam.entities.Customer;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.service.customerservice.CustomerServicesImpl;
import com.epam.service.customervalidation.CustomerValidation;
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
 * The Class CustomerServiceTest.
 *
 * @author Nitin_Hasija
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerServiceTest {

  /** The mock dao. */
  @Mock
  private CustomerDao mockDao;

  /** The validation. */
  @Mock
  private CustomerValidation validation;

  /** The customer service. */
  @InjectMocks
  private CustomerServicesImpl customerService;

  /** The customer. */
  private Customer customer;

  /**
   * Sets the up.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  public static void setUp() throws Exception {
    MockitoAnnotations.initMocks(CustomerServiceTest.class);
  }

  /**
   * Test.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("create a valid customer")
  public void createValidCustomertest() throws InvalidCustomerException {
    when(mockDao.saveCustomer(any(Customer.class))).thenReturn(customer);
    when(validation.isValid(any(Customer.class))).thenReturn(true);

    String name = "Nitin Hasija";
    String email = "abc@gmail.com";
    Long mobileNumber = 9034681817L;

    assertNotNull(customerService.createCustomer(name, email, mobileNumber));
  }

  /**
   * Creates the invalid customer.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("create a invalid customer")
  public void createInvalidCustomer() throws InvalidCustomerException {
    when(mockDao.saveCustomer(any(Customer.class))).thenReturn(customer);
    when(validation.isValid(any(Customer.class))).thenReturn(false);

    String name = null;
    String email = "abc@gmail.com";
    Long mobileNumber = 9034681817L;

    assertThrows(InvalidCustomerException.class,
        () -> customerService.createCustomer(name, email, mobileNumber));
  }

  /**
   * Test get customer by id.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Get Customer by valid Id")
  public void testGetCustomerById() throws InvalidCustomerException {
    customer = new Customer();
    int id = customer.getId();
    when(mockDao.getCustomerById(id)).thenReturn(customer);
    assertNotNull(customerService.getCustomerById(id));
  }

  /**
   * Test get customer by invalid id.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Get Customer by Invalid Id")
  public void testGetCustomerByInvalidId() throws InvalidCustomerException {
    int id = -1;
    when(mockDao.getCustomerById(id)).thenThrow(InvalidCustomerException.class);
    assertThrows(InvalidCustomerException.class, () -> customerService.getCustomerById(id));
  }

  /**
   * Test update invalid customer.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("update invalid Customer ")
  public void testUpdateInvalidCustomer() throws InvalidCustomerException {
    when(validation.isValid(any(Customer.class))).thenReturn(false);
    String name = "Nitin Hasija";
    String email = "abc@gmail.com";
    Long mobileNumber = 9034681817L;
    int id = -1;
    assertThrows(InvalidCustomerException.class,
        () -> customerService.updateCustomerDetails(id, name, email, mobileNumber));
  }

  /**
   * Test update valid customer details.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("update valid details of customer ")
  public void testUpdateValidCustomerDetails() throws InvalidCustomerException {
    when(validation.isValid(any(Customer.class))).thenReturn(true);
    when(mockDao.updateCustomerDetails(any(Integer.class), any(Customer.class))).thenReturn(true);

    String name = "Nitin Hasija";
    String email = "abc@gmail.com";
    Long mobileNumber = 9034681817L;
    int id = 101;
    assertTrue(customerService.updateCustomerDetails(id, name, email, mobileNumber));
  }
}
