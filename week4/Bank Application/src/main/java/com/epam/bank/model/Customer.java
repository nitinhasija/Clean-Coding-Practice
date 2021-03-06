/**
 * A model class of customer
 */

package com.epam.bank.model;

import com.epam.bank.util.CustomerIdGenerator;

/**
 * The Class Customer.
 *
 * @author Nitin_Hasija
 */
public class Customer {

  /** The name. */
  private String name;

  /** The emailId. */
  private String emailId;

  /** The mobile number. */
  private long mobileNumber;

  /** The id. */
  private final int id;

  /**
   * Instantiates a new customer.
   */
  public Customer() {
    id = CustomerIdGenerator.getCustomerId();
  }

  /**
   * Instantiates a new customer.
   *
   * @param customer the customer
   */
  public Customer(Customer customer) {
    this.id = customer.getId();
    name = customer.getName();
    emailId = customer.getEmailid();
    mobileNumber = customer.getMobileNumber();
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the emailId.
   *
   * @return the emailId
   */
  public String getEmailid() {
    return emailId;
  }

  /**
   * Gets the mobile number.
   *
   * @return the mobileNumber
   */
  public long getMobileNumber() {
    return mobileNumber;
  }

  /**
   * Gets the id.
   *
   * @return customer ID
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the email id.
   *
   * @param emailId the new email id
   */
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  /**
   * Sets the mobile number.
   *
   * @param mobileNumber the new mobile number
   */
  public void setMobileNumber(long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
}
