/**
 * Implements CustomerDao interface functionality
 */

package com.epam.daoimplementation;

import com.epam.daointerface.CustomerDao;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.model.Customer;
import com.epam.util.ConstantUtils;
import com.epam.util.PersistenceUtils;

import java.util.function.Supplier;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

/**
 * The Class CustomerDatabase.
 *
 * @author Nitin_Hasija
 */
@Component
public class CustomerDaoImpl implements CustomerDao {

  /** The entity manager. */
  private EntityManager entityManager;

  /** The supplier. */
  private Supplier<InvalidCustomerException> supplier = () -> new InvalidCustomerException(
      ConstantUtils.INVALID_DETAILS);

  /**
   * Instantiates a new customer database.
   */
  public CustomerDaoImpl() {
    entityManager = PersistenceUtils.getEntityManager();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#saveCustomer(com.epam.bank.model.Customer)
   */
  @Override
  public boolean saveCustomer(Customer customer) {
    entityManager.getTransaction().begin();
    entityManager.persist(customer);
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.bank.dao.CustomerDao#getCustomerById(int)
   */
  @Override
  public Customer getCustomerById(int customerId) throws InvalidCustomerException {
    Customer customer = entityManager.find(Customer.class, customerId);
    if (customer == null) {
      throw supplier.get();
    } else {
      return customer;
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
    entityManager.getTransaction().begin();
    Customer customer = getCustomerById(customerId);
    customer.setEmailId(dummyCustomer.getEmailid());
    customer.setName(dummyCustomer.getName());
    customer.setMobileNumber(dummyCustomer.getMobileNumber());
    entityManager.getTransaction().commit();
    return true;
  }
}
