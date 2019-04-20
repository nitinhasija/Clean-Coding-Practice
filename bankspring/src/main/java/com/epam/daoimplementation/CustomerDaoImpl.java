/**
 * Implements CustomerDao interface functionality
 */

package com.epam.daoimplementation;

import com.epam.daointerface.CustomerDao;
import com.epam.entities.Customer;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.repository.CustomerRepository;
import com.epam.util.ConstantUtils;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The Class CustomerDatabase.
 *
 * @author Nitin_Hasija
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {
  @Autowired
  public CustomerRepository customerRepo;

  /** The supplier. */
  private Supplier<InvalidCustomerException> supplier = () -> new InvalidCustomerException(
      ConstantUtils.INVALID_DETAILS);

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#saveCustomer(com.epam.bank.model.Customer)
   */
  @Override
  public Customer saveCustomer(Customer customer) {
    return customerRepo.save(customer);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#getCustomerById(int)
   */
  @Override
  public Customer getCustomerById(int customerId) throws InvalidCustomerException {
    Optional<Customer> customer = customerRepo.findById(customerId);
    if (customer.isPresent()) {
      return customer.get();
    } else {
      throw supplier.get();
    }
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
    customerRepo.save(customer);
    return true;
  }
}
