/**
 * 
 */
package com.epam.service.transactionvalidation;

import com.epam.model.Account;

/**
 * The Interface TransactionValidationInterface.
 *
 * @author Nitin_Hasija
 */
public interface TransactionValidation {
  
  /**
   * Checks if is valid deposite amount.
   *
   * @param amount the amount
   * @return true, if is valid deposite amount
   */
  boolean isValidDepositeAmount(double amount);
  
  /**
   * Checks if is valid withdraw amount.
   *
   * @param account the account
   * @param amount the amount
   * @return true, if is valid withdraw amount
   */
  boolean isValidWithdrawAmount(Account account, double amount);
}
