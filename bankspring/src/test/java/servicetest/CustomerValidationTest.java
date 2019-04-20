/**
 * TO DO
 * 1. Test for valid credentials
 * 2. Test for null credentials
 * 3. Test for invalid credentials
 */

package servicetest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.entities.Customer;
import com.epam.service.customervalidation.CustomerValidationImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerValidationTest.
 *
 * @author Nitin_Hasija
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerValidationTest {

  /** The validation. */
  private static CustomerValidationImpl validation;

  /** The customer. */
  private static Customer customer;

  /** The name. */
  private String name;

  /** The email. */
  private String email;

  /** The mobile number. */
  private Long mobileNumber;

  /**
   * Inits the.
   *
   * @throws Exception the exception
   */
  @BeforeAll
  public static void init() throws Exception {
    customer = new Customer();
    validation = new CustomerValidationImpl();
  }

  /**
   * Testfor valid details.
   */
  @Test
  @DisplayName("test for valid details")
  public void testforValidDetails() {
    name = "Abc Xyz";
    email = "abc@gmail.com";
    mobileNumber = 9034658915L;

    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);

    assertTrue(validation.isValid(customer));
  }

  /**
   * Test null email.
   */
  @Test
  @DisplayName("test for null email Id")
  public void testNullEmail() {
    name = "Abc Xyz";
    email = null;
    mobileNumber = 9034658915L;

    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);

    assertFalse(validation.isValid(customer));
  }

  /**
   * Test null name.
   */
  @Test
  @DisplayName("test for null name")
  public void testNullName() {
    name = null;
    email = "abc@gmail.com";
    mobileNumber = 9034658915L;

    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);

    assertFalse(validation.isValid(customer));
  }

  /**
   * Testfor null mobile number.
   */
  @Test
  @DisplayName("test for incorrect mobile Number")
  public void testforNullMobileNumber() {
    name = "Abc Xyz";
    email = "abc@gmail.com";
    mobileNumber = 903478L;

    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);

    assertFalse(validation.isValid(customer));
  }

  /**
   * Test invalid name.
   */
  @Test
  @DisplayName("test for invalid name")
  public void testInvalidName() {
    name = "abc";
    email = "abc@gmail.com";
    mobileNumber = 9034658915L;

    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);

    assertFalse(validation.isValid(customer));
  }

  /**
   * Test invalid email.
   */
  @Test
  @DisplayName("test for invalid email")
  public void testInvalidEmail() {
    name = "abc";
    email = "abc@@gmail.com";
    mobileNumber = 9034658915L;

    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);

    assertFalse(validation.isValid(customer));
  }
}
