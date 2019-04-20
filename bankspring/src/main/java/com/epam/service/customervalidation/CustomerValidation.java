/**
 * 
 */

package com.epam.service.customervalidation;

import com.epam.entities.Customer;

/**
 * The Interface CustomerValidationInterface.
 *
 * @author Nitin_Hasija
 */
public interface CustomerValidation {
  
  /**
   * Checks if is valid.
   *
   * @param customer the customer
   * @return true, if is valid
   */
  boolean isValid(Customer customer);
}
