
/**
 * Customer Interface
 */

package com.epam.bank.dao;

import com.epam.bank.exceptions.InvalidCustomerException;
import com.epam.bank.model.Customer;

/**
 * The Interface CustomerDao.
 */
public interface CustomerDao {

  /**
   * Save customer.
   *
   * @param customer the customer
   * @return true, if successful
   * @throws InvalidCustomerException the invalid customer exception
   */
  boolean saveCustomer(Customer customer) throws InvalidCustomerException;

  /**
   * Gets the customer by id.
   *
   * @param customerId the customer id
   * @return the customer by id
   * @throws InvalidCustomerException the invalid customer exception
   */
  Customer getCustomerById(int customerId) throws InvalidCustomerException;

  /**
   * Update customer details.
   *
   * @param customer the customer
   * @return true, if successful
   * @throws InvalidCustomerException the invalid customer exception
   */
  boolean updateCustomerDetails(Customer customer) throws InvalidCustomerException;
}
