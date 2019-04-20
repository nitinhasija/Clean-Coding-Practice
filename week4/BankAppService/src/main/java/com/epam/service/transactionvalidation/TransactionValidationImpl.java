/**
 * This class performs transactions related activities 
 */

package com.epam.service.transactionvalidation;

import com.epam.model.Account;

/**
 * The Class Transaction.
 *
 * @author Nitin_Hasija
 */
public class TransactionValidationImpl implements TransactionValidation {

   
  /* (non-Javadoc)
   * @see com.epam.service.transactionvalidation.TransactionValidation#isValidDepositeAmount(double)
   */
  public boolean isValidDepositeAmount(double amount) {
    return (amount > 0);
  }

  /* (non-Javadoc)
   * @see com.epam.service.transactionvalidation.TransactionValidation#isValidWithdrawAmount(com.epam.model.Account, double)
   */
  public boolean isValidWithdrawAmount(Account account, double amount) {
    double previousAmount = account.getBalance();
    return (amount < previousAmount && amount > 0);
  }
}