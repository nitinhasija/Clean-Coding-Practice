/**
 * This class performs transactions related activities 
 */

package com.epam.service.transactionvalidation;

import com.epam.entities.Account;
import org.springframework.stereotype.Component;

/**
 * The Class Transaction.
 *
 * @author Nitin_Hasija
 */
@Component
public class TransactionValidationImpl implements TransactionValidation {
  /**
   * Checks if is valid deposite amount.
   *
   * @param amount the amount
   * @return true, if is valid deposite amount
   */
  public boolean isValidDepositAmount(double amount) {
    return (amount > 0);
  }

  /**
   * Checks if is valid withdraw amount.
   *
   * @param account the account
   * @param amount  the amount
   * @return true, if is valid withdraw amount
   */
  public boolean isValidWithdrawAmount(Account account, double amount) {
    double previousAmount = account.getBalance();
    return (amount <= previousAmount && amount > 0);
  }
}