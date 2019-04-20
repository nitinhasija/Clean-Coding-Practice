/*
 * 
 */

package com.epam.controllers;

import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidTransactionException;
import com.epam.service.accountservice.AccountService;
import com.epam.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class Deposit.
 *
 * @author Nitin_Hasija
 */
@Controller
public class AmountDepositController {

  /** The account service. */
  @Autowired
  private AccountService accountService;

  /**
   * Deposit amount.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @param model         the model
   * @return the string
   */
  @PostMapping("/deposit")
  public String depositAmount(@RequestParam("accountNumber") int accountNumber,
      @RequestParam("amount") double amount, Model model) {
    try {
      accountService.deposit(accountNumber, amount);
      model.addAttribute("amountDepositStatus", ConstantUtils.DEPOSIT_STATUS + amount);

    } catch (AccountNotFoundException | InvalidTransactionException e) {
      model.addAttribute("amountDepositStatus", e.getMessage());
    }
    return "depositAmount";
  }
}
