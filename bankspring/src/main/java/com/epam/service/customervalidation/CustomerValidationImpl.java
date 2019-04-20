/**
 * Checks the validity of a customer
 */

package com.epam.service.customervalidation;

import com.epam.entities.Customer;
import com.epam.util.ConstantUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * The Class CustomerValidation.
 *
 * @author Nitin_Hasija
 */
@Component
public class CustomerValidationImpl implements CustomerValidation {

  /** The pattern. */
  private Pattern pattern = null;

  /** The matcher. */
  private Matcher matcher = null;

  /** The customer. */
  private Customer customer;

  /**
   * Checks if is valid email.
   *
   * @return true, if is valid email
   */
  private boolean isValidEmail() {
    String emailId = customer.getEmailid();
    if (emailId == null) {
      return false;
    }
    pattern = Pattern.compile(ConstantUtils.EMAIL_PATTERN);
    matcher = pattern.matcher(emailId);
    return matcher.matches();
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
    }
    pattern = Pattern.compile(ConstantUtils.NAME_PATTERN);
    matcher = pattern.matcher(name);
    return matcher.matches();
  }

  /**
   * Checks if is valid mobile number.
   *
   * @return true, if is valid mobile number
   */
  private boolean isValidMobileNumber() {
    String mobileNumber = customer.getMobileNumber() + "";
    pattern = Pattern.compile(ConstantUtils.MOBILE_NUMBER_PATTERN);
    matcher = pattern.matcher(mobileNumber);
    return matcher.matches();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.epam.service.customervalidation.CustomerValidationInterface#isValid(com.
   * epam.model.Customer)
   */
  public boolean isValid(Customer customer) {
    this.customer = customer;
    return (isValidName()) && (isValidEmail()) && (isValidMobileNumber());
  }
}
