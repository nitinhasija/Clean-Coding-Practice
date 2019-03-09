/**
 * Checks the validity of a customer
 */

package com.epam.bank.services;

import com.epam.bank.model.Customer;
import java.util.regex.Pattern;

/**
 * The Class CustomerValidation.
 *
 * @author Nitin_Hasija
 */
public class CustomerValidation {

  /** The min name length. */
  private static final int MIN_NAME_LENGTH = 2;

  /** The mobile number length. */
  private static final long MOBILE_NUMBER_LENGTH = 10;

  /** The customer. */
  private Customer customer;

  /**
   * Checks if is valid.
   *
   * @param customer the customer
   * @return true, if is valid
   */
  public boolean isValid(Customer customer) {

    this.customer = customer;
    return (isValidName() && isValidEmail() && isValidMobileNumber());
  }

  /**
   * Checks if is valid email.
   *
   * @return true, if is valid email
   */
  boolean isValidEmail() {
    String emailId = customer.getEmailid();

    if (emailId == null) {
      return false;
    } else {
      final Pattern emailRegex = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]"
          + "+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9]"
          + "(?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
      return emailRegex.matcher(emailId).matches();
    }
  }

  /**
   * Checks if is valid name.
   *
   * @return true, if is valid name
   */
  private boolean isValidName() {
    String name = customer.getName();

    if (name == null) {
      return false;
    } else {
      return name.length() > MIN_NAME_LENGTH;
    }
  }

  /**
   * Checks if is valid mobile number.
   *
   * @return true, if is valid mobile number
   */
  boolean isValidMobileNumber() {
    return (customer.getMobileNumber() + "").length() == MOBILE_NUMBER_LENGTH;
  }
}
