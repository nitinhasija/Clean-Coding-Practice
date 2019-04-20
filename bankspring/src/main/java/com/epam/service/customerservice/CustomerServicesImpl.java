/**
 * Class to provide services to the customer
 */

package com.epam.service.customerservice;

import com.epam.daointerface.CustomerDao;
import com.epam.entities.Customer;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.service.customervalidation.CustomerValidation;
import com.epam.util.ConstantUtils;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class CustomerServices.
 *
 * @author Nitin_Hasija
 */
@Service
public class CustomerServicesImpl implements CustomerService {

  /** The customer DB. */
  @Autowired
  private CustomerDao customerDb;

  /** The validation. */
  @Autowired
  private CustomerValidation validation;

  /** The supplier. */
  private Supplier<InvalidCustomerException> supplier = () -> new InvalidCustomerException(
      ConstantUtils.INVALID_CUSTOMER_CREDENTIALS);

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.customerservice.CustomerServiceInterface#createCustomer(java
   * .lang.String, java.lang.String, long)
   */
  @Override
  public Customer createCustomer(String name, String email, long mobileNumber)
      throws InvalidCustomerException {
    Customer customer = new Customer();
    customer.setName(name);
    customer.setEmailId(email);
    customer.setMobileNumber(mobileNumber);
    if (validation.isValid(customer)) {
      customerDb.saveCustomer(customer);
    } else {
      throw supplier.get();
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
  @Override
  public Customer getCustomerById(int id) throws InvalidCustomerException {
    return customerDb.getCustomerById(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.service.customerservice.CustomerServiceInterface#
   * updateCustomerDetails(int, java.lang.String, java.lang.String, long)
   */
  @Override
  public boolean updateCustomerDetails(int customerId, String name, String emailId,
      long mobileNumber) throws InvalidCustomerException {

    Customer dummyCustomer = new Customer();
    dummyCustomer.setName(name);
    dummyCustomer.setEmailId(emailId);
    dummyCustomer.setMobileNumber(mobileNumber);

    if (validation.isValid(dummyCustomer)) {
      return customerDb.updateCustomerDetails(customerId, dummyCustomer);
    } else {
      throw supplier.get();
    }
  }
}
