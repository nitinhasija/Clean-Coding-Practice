/**
 * Dummy customer to implement CustomerDao interface functionality
 */

package com.epam.daoimplement;

import com.epam.bank.dao.CustomerDao;
import com.epam.bank.exceptions.InvalidCustomerException;
import com.epam.bank.model.Customer;
import java.util.function.Supplier;
import javax.persistence.EntityManager;

/**
 * The Class CustomerDatabase.
 *
 * @author Nitin_Hasija
 */
public class CustomerDatabase implements CustomerDao {

  /** The entity manager. */
  private static EntityManager entityManager;

  /** The object. */
  private static CustomerDatabase object;

  /** The supplier. */
  private Supplier<InvalidCustomerException> supplier = () -> new InvalidCustomerException(
      "Invalid Customer Exception");

  /**
   * Instantiates a new customer database.
   */
  private CustomerDatabase() {
  }

  /**
   * Gets the single instance of CustomerDatabase.
   *
   * @return single instance of CustomerDatabase
   */
  public static CustomerDatabase getInstance() {
    if (object == null) {
      object = new CustomerDatabase();
      entityManager = PersistenceUtils.getEntityManager();
    }
    return object;
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
