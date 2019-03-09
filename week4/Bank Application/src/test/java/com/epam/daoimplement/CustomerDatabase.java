/**
 * Dummy customer to implement CustomerDao interface functionality
 */

package com.epam.daoimplement;

import com.epam.bank.dao.CustomerDao;
import com.epam.bank.exceptions.InvalidCustomerException;
import com.epam.bank.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The Class CustomerDatabase.
 *
 * @author Nitin_Hasija
 */
public class CustomerDatabase implements CustomerDao {

  /** The customer list. */
  private List<Customer> customerList;

  /** The supplier. */
  private Supplier<InvalidCustomerException> supplier = () -> {
    return new InvalidCustomerException("Invalid Customer Exception");
  };

  private Predicate<Customer> predicate(int id) {
    return customer -> customer.getId() == id;
  }

  /**
   * Instantiates a new customer database.
   */
  public CustomerDatabase() {
    customerList = new ArrayList<Customer>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#getCustomerByID(int)
   */
  @Override
  public Customer getCustomerById(int id) throws InvalidCustomerException {
    return customerList.stream().filter(predicate(id)).findAny().orElseThrow(supplier);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#updateCustomerDetails(com.epam.bank.model.
   * Customer)
   */
  @Override
  public boolean updateCustomerDetails(Customer customer) throws InvalidCustomerException {
    Customer oldDetailedCustomer = getCustomerById(customer.getId());
    customerList.remove(oldDetailedCustomer);
    Customer updatedCustomer = new Customer(customer);
    customerList.add(updatedCustomer);
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#saveCustomer(com.epam.bank.model.Customer)
   */
  @Override
  public boolean saveCustomer(Customer customer) throws InvalidCustomerException {
    return customerList.add(customer);
  }

}
