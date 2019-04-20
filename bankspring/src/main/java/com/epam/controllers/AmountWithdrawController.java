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
 * The Class Withdraw.
 *
 * @author Nitin_Hasija
 */
@Controller
public class AmountWithdrawController {

  /** The account service. */
  @Autowired
  private AccountService accountService;

  /**
   * Withdraw amount.
   *
   * @param accountNumber the account number
   * @param amount        the amount
   * @param model         the model
   * @return the string
   */
  @PostMapping("/withdraw")
  public String withdrawAmount(@RequestParam("accountNumber") int accountNumber,
      @RequestParam("amount") double amount, Model model) {
    try {
      accountService.withdraw(accountNumber, amount);
      model.addAttribute("amountWithdrawnStatus", ConstantUtils.WITHDRAW_STATUS + amount);
    } catch (AccountNotFoundException | InvalidTransactionException e) {
      model.addAttribute("amountWithdrawnStatus", e.getMessage());
    }
    return "withdrawAmount";
  }
}