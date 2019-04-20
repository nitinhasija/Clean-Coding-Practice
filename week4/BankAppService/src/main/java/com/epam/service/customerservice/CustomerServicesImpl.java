/**
 * Class to provide services to the customer
 */

package com.epam.service.customerservice;

import com.epam.daoimplementation.CustomerDaoImpl;
import com.epam.daointerface.CustomerDao;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.model.Customer;
import com.epam.service.customervalidation.CustomerValidationImpl;
import com.epam.util.ConstantUtils;

import java.util.function.Supplier;

/**
 * The Class CustomerServices.
 *
 * @author Nitin_Hasija
 */
public class CustomerServicesImpl implements CustomerService {

  /** The customer DB. */
  private CustomerDao customerDb;

  /** The validation. */
  CustomerValidationImpl validation;

  /** The supplier. */
  private Supplier<InvalidCustomerException> supplier = () -> new InvalidCustomerException(
      ConstantUtils.INVALID_DETAILS);

  /**
   * Instantiates a new customer services impl.
   */
  public CustomerServicesImpl() {
    customerDb = CustomerDaoImpl.getInstance();
    validation = new CustomerValidationImpl();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.customerservice.CustomerServiceInterface#createCustomer(java
   * .lang.String, java.lang.String, long)
   */
  public Customer createCustomer(String name, String email, long mobileNumber)
      throws InvalidCustomerException {
    Customer customer = new Customer();
    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);

    if (!validation.isValid(customer)) {
      throw supplier.get();
    } else {
      customerDb.saveCustomer(customer);
    }
    return customer;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.customerservice.CustomerServiceInterface#getCustomerById(
   * int)
   */
  public Customer getCustomerById(int id) throws InvalidCustomerException {
    return customerDb.getCustomerById(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.customerservice.CustomerServiceInterface#
   * updateCustomerDetails(int, java.lang.String, java.lang.String, long)
   */
  public boolean updateCustomerDetails(int customerId, String name, String emailId,
      long mobileNumber) throws InvalidCustomerException {

    Customer dummyCustomer = new Customer();
    dummyCustomer.setName(name);
    dummyCustomer.setEmailId(emailId);
    dummyCustomer.setMobileNumber(mobileNumber);

    if (!validation.isValid(dummyCustomer)) {
      throw supplier.get();
    } else {
      return customerDb.updateCustomerDetails(customerId, dummyCustomer);
    }
  }
}
