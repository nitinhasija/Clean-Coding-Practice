/**
 * Class to provide services to the customer
 */

package com.epam.bank.services;

import com.epam.bank.dao.CustomerDao;
import com.epam.bank.exceptions.InvalidCustomerException;
import com.epam.bank.model.Customer;

/**
 * The Class CustomerServices.
 *
 * @author Nitin_Hasija
 */
public class CustomerServices {

  /** The customer DB. */
  private CustomerDao customerDb;
  private CustomerValidation validation;

  /**
   * Instantiates a new customer services.
   *
   * @param customerDb the customer DB
   */
  public CustomerServices(CustomerDao customerDb) {
    this.customerDb = customerDb;
    validation = new CustomerValidation();
  }

  /**
   * Creates the customer.
   *
   * @param customer the customer
   * @return true, if successful
   * @throws InvalidCustomerException the invalid customer exception
   */
  public boolean createCustomer(Customer customer) throws InvalidCustomerException {
    if (validation.isValid(customer)) {
      return customerDb.saveCustomer(customer);
    } else {
      throw new InvalidCustomerException("Invalid Customer");
    }
  }

  /**
   * Gets the customer by ID.
   *
   * @param id the id
   * @return the customer by ID
   * @throws InvalidCustomerException the invalid customer exception
   */
  public Customer getCustomerById(int id) throws InvalidCustomerException {
    return customerDb.getCustomerById(id);
  }

  /**
   * Update customer details.
   *
   * @param customer the customer
   * @return true, if successful
   * @throws InvalidCustomerException the invalid customer exception
   */
  public boolean updateCustomerDetails(Customer customer) throws InvalidCustomerException {
    return customerDb.updateCustomerDetails(customer);
  }

}
