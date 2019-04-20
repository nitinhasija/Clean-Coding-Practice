package com.epam.controllers;

import com.epam.service.accountservice.AccountServicesImpl;
import com.epam.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class AccountDeletion.
 *
 * @author Nitin_Hasija
 */
@Controller
public class DeleteAccountController {

  /** The Constant ACCOUNT_DELETION. */

  /** The account service. */
  @Autowired
  private AccountServicesImpl accountService;

  /**
   * Delete account.
   *
   * @param accountNumber the account number
   * @param model         the model
   * @return the string
   */
  @PostMapping("/deleteAccount")
  public String deleteAccount(@RequestParam("accountNumber") int accountNumber, Model model) {
    try {
      accountService.deleteAccount(accountNumber);
      model.addAttribute("accountDeletionStatus", ConstantUtils.ACCOUNT_DELETION);
    } catch (Exception e) {
      model.addAttribute("accountDeletionStatus", e.getMessage());
    }
    return "deleteAccount";
  }
}
