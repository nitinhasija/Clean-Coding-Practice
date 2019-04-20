/**
 * Customer Interface
 */

package com.epam.daointerface;

import com.epam.exceptions.InvalidCustomerException;
import com.epam.model.Customer;

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
   * @param customerId    the customer id
   * @param dummyCustomer the dummy customer
   * @return true, if successful
   * @throws InvalidCustomerException the invalid customer exception
   */
  boolean updateCustomerDetails(int customerId, Customer dummyCustomer)
      throws InvalidCustomerException;
}
