/**
 * Dummy customer to implement CustomerDao interface functionality
 */

package com.epam.daoimplementation;

import com.epam.daointerface.CustomerDao;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.model.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The Class CustomerDatabase.
 *
 * @author Nitin_Hasija
 */
public class CustomerDaoImpl implements CustomerDao {

  /** The customer list. */
  private static List<Customer> customerList;

  /** The object. */
  private static CustomerDaoImpl object;

  /** The supplier. */
  private Supplier<InvalidCustomerException> supplier = () -> new InvalidCustomerException(
      "Invalid Customer Exception");

  /**
   * Predicate.
   *
   * @param id the id
   * @return the predicate
   */
  private Predicate<Customer> predicate(int id) {
    return customer -> customer.getId() == id;
  }

  /**
   * Instantiates a new customer database.
   */
  private CustomerDaoImpl() {
  }

  /**
   * Gets the single instance of CustomerDatabase.
   *
   * @return single instance of CustomerDatabase
   */
  public static CustomerDaoImpl getInstance() {
    if (object == null) {
      customerList = new ArrayList<>();
      object = new CustomerDaoImpl();
    }
    return object;
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
  public boolean updateCustomerDetails(int customerId, Customer dummyCustomer)
      throws InvalidCustomerException {
    Customer customer = getCustomerById(customerId);
    customer.setEmailId(dummyCustomer.getEmailid());
    customer.setName(dummyCustomer.getName());
    customer.setMobileNumber(dummyCustomer.getMobileNumber());
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#saveCustomer(com.epam.bank.model.Customer)
   */
  @Override
  public boolean saveCustomer(Customer customer) {
    return customerList.add(customer);
  }
}
