/**
 * This class tests the functionality of create account class.
 */

/*TO DO: 
 * 1. Test whether the account is created for appropriate credentials or not.
 * 2. Test whether customer exists or not. 
 * 3. Test for whether customer details are updated are not.
 */

package com.epam.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.bank.exceptions.InvalidCustomerException;
import com.epam.bank.model.Customer;
import com.epam.bank.services.CustomerServices;
import com.epam.daoimplement.CustomerDatabase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class CustomerTesting.
 * 
 * @author Nitin_Hasija
 */
class CustomerTest {

  /** The customer services. */
  private static CustomerServices customerServices;

  /** The customer. */
  private static Customer customer;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    customer = new Customer();
    customerServices = new CustomerServices(new CustomerDatabase());
  }

  /**
   * Test in valid attributes.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for null name")
  public void testInValidAttributes() throws InvalidCustomerException {
    customer.setName(null);
    customer.setEmailId("abc");
    customer.setMobileNumber(7890536491L);
    assertThrows(InvalidCustomerException.class, () -> customerServices.createCustomer(customer));
  }

  /**
   * Test for null email.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for null emailId")
  public void testForNullEmail() throws InvalidCustomerException {
    customer.setName("abcd");
    customer.setEmailId(null);
    customer.setMobileNumber(7890536491L);
    assertThrows(InvalidCustomerException.class, () -> customerServices.createCustomer(customer));
  }

  /**
   * Test in valid email id.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid email credentials")
  public void testInValidEmailId() throws InvalidCustomerException {
    customer.setName("abcd");
    customer.setEmailId("abc@@gmail.com");
    customer.setMobileNumber(7890536491L);
    assertThrows(InvalidCustomerException.class, () -> customerServices.createCustomer(customer));
  }

  /**
   * Test in valid name.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid name credentials")
  public void testInValidName() throws InvalidCustomerException {
    customer.setName("ab");
    customer.setEmailId("abc@gmail.com");
    customer.setMobileNumber(7890536491L);
    assertThrows(InvalidCustomerException.class, () -> customerServices.createCustomer(customer));
  }

  /**
   * Test in valid mobile number.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for invalid mobile number")
  public void testInValidMobileNumber() throws InvalidCustomerException {
    customer.setName("abcd");
    customer.setEmailId("abc@gmail.com");
    customer.setMobileNumber(789053L);
    assertThrows(InvalidCustomerException.class, () -> customerServices.createCustomer(customer));
  }

  /**
   * Test valid attributes.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for accurate credentials")
  public void testValidAttributes() throws InvalidCustomerException {
    customer.setName("abc");
    customer.setEmailId("abc@gmail.com");
    customer.setMobileNumber(7890536491L);
    assertDoesNotThrow(() -> customerServices.createCustomer(customer));
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
    customer.setName("abc");
    customer.setEmailId("abc@gmail.com");
    customer.setMobileNumber(7890536491L);
    customerServices.createCustomer(customer);
    assertNotNull(customerServices.getCustomerById(customer.getId()));
  }

  /**
   * Test update customer name.
   *
   * @throws InvalidCustomerException the invalid customer exception
   */
  @Test
  @DisplayName("Test for update customer info")
  public void testUpdateCustomerName() throws InvalidCustomerException {

    customer.setName("abc");
    customer.setEmailId("abc@gmail.com");
    customer.setMobileNumber(7890536491L);
    customerServices.createCustomer(customer);

    String newName = "Nitin Hasija";
    customer.setName(newName);

    customerServices.updateCustomerDetails(customer);
    assertEquals(newName, customerServices.getCustomerById(customer.getId()).getName());
  }
}
