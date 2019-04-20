/**
 * 
 */

package com.epam.service.customerservice;

import com.epam.entities.Customer;
import com.epam.exceptions.InvalidCustomerException;

/**
 * The Interface CustomerServiceInterface.
 *
 * @author Nitin_Hasija
 */
public interface CustomerService {

  /**
   * Creates the customer.
   *
   * @param name         the name
   * @param email        the email
   * @param mobileNumber the mobile number
   * @return the customer
   * @throws InvalidCustomerException the invalid customer exception
   */
  Customer createCustomer(String name, String email, long mobileNumber)
      throws InvalidCustomerException;

  /**
   * Gets the customer by id.
   *
   * @param id the id
   * @return the customer by id
   * @throws InvalidCustomerException the invalid customer exception
   */
  Customer getCustomerById(int id) throws InvalidCustomerException;

  /**
   * Update customer details.
   *
   * @param customerId   the customer id
   * @param name         the name
   * @param emailId      the email id
   * @param mobileNumber the mobile number
   * @return true, if successful
   * @throws InvalidCustomerException the invalid customer exception
   */
  boolean updateCustomerDetails(int customerId, String name, String emailId, long mobileNumber)
      throws InvalidCustomerException;

}
