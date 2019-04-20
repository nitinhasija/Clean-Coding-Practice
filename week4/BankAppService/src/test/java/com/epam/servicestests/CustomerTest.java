/**
 * This class tests the functionality of create account class.
 */

/*TO DO: 
 * 1. Test whether the account is created for appropriate credentials or not.
 * 2. Test whether customer exists or not. 
 * 3. Test for whether customer details are updated are not.
 */

package com.epam.servicestests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.epam.exceptions.InvalidCustomerException;
import com.epam.model.Customer;
import com.epam.service.customerservice.CustomerService;
import com.epam.service.customerservice.CustomerServicesImpl;

/**
 * The Class CustomerTesting.
 * 
 * @author Nitin_Hasija
 */
class CustomerTest {

  /** The customer services. */
  private static CustomerService customerServices;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    customerServices = new CustomerServicesImpl();
  }

  /**
   * Test in valid attributes.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for null name")
  public void testInValidAttributes() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class,
        () -> customerServices.createCustomer(null, "abc@gmail.com", 7890536491L));
  }

  /**
   * Test for null email.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for null emailId")
  public void testForNullEmail() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class,
        () -> customerServices.createCustomer("Abc Xyz", null, 7890536491L));
  }

  /**
   * Test in valid email id.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid email credentials")
  public void testInValidEmailId() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class,
        () -> customerServices.createCustomer("abc", "abc@@gmail.com", 7890536491L));
  }

  /**
   * Test in valid mobile number.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid mobile number")
  public void testInValidMobileNumber() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class,
        () -> customerServices.createCustomer("abc", "abc@@gmail.com", 7890591L));
  }

  /**
   * Test valid attributes.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for accurate credentials")
  public void testValidAttributes() throws InvalidCustomerException {
    assertDoesNotThrow(
        () -> customerServices.createCustomer("Abc Sharma", "abc@gmail.com", 9034681811L));
  }

  /**
   * Test in valid customer id.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test InValid customer ID")
  public void testInValidCustomerId() throws InvalidCustomerException {
    assertThrows(InvalidCustomerException.class, () -> customerServices.getCustomerById(-1));
  }

  /**
   * Test validcustomer id.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test Valid customer ID")
  public void testValidcustomerId() throws InvalidCustomerException {
    Customer customer = customerServices.createCustomer("Abc Sharma", "abc@gmail.com", 9034681811L);
    assertNotNull(customerServices.getCustomerById(customer.getId()));
  }

  /**
   * Test update customer name.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for valid customer info updation")
  public void testValidCustomerInfoUpdation() throws InvalidCustomerException {
    Customer customer = customerServices.createCustomer("Abc Sharma", "abc@gmail.com", 9034681811L);
    String newName = "Nitin Hasija";
    assertTrue(customerServices.updateCustomerDetails(customer.getId(), newName, "abc@gmail.com",
        7890536491L));
  }

  /**
   * Test invalid customer info updation.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid customer info updation")
  public void testInvalidCustomerInfoUpdation() throws InvalidCustomerException {
    Customer customer = customerServices.createCustomer("Abc Sharma", "abc@gmail.com", 9034681811L);
    String newName = null;
    assertThrows(InvalidCustomerException.class, () -> customerServices
        .updateCustomerDetails(customer.getId(), newName, "abc@gmail.com", 7890536491L));
  }
}
