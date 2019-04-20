/*
 * 
 */

package com.epam.controllers;

import com.epam.model.Account;
import com.epam.model.Customer;
import com.epam.service.accountservice.AccountServicesImpl;
import com.epam.service.customerservice.CustomerServicesImpl;
import com.epam.util.ConstantUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class AccountCreation.
 *
 * @author Nitin_Hasija
 */
@Controller
public class CreateAccountController {

  /** The Constant ACCOUNT_STATUS. */

  /** The customer service. */
  @Autowired
  private CustomerServicesImpl customerService;

  /** The account service. */
  @Autowired
  private AccountServicesImpl accountService;

  /**
   * Creates the account.
   *
   * @param name         the name
   * @param email        the email
   * @param mobileNumber the mobile number
   * @param model        the model
   * @return the string
   */
  @PostMapping("/openAccount")
  public String createAccount(@RequestParam("name") String name,
      @RequestParam("email") String email, @RequestParam("mobileNumber") long mobileNumber,
      Model model) {

    try {
      Customer customer = customerService.createCustomer(name, email, mobileNumber);
      Account account = accountService.createAccount(customer);
      model.addAttribute("accountCreationStatus",
          ConstantUtils.ACCOUNT_STATUS + account.getAccountNumber());
    } catch (Exception e) {
      model.addAttribute("accountCreationStatus", e.getMessage());
    }
    return "createAccount";
  }
}
