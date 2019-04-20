/**
 * 
 */

package com.epam.controllers;

import com.epam.model.Account;
import com.epam.model.Customer;
import com.epam.service.accountservice.AccountServicesImpl;
import com.epam.service.customerservice.CustomerServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class AccountDetails.
 *
 * @author Nitin_Hasija
 */
@Controller
public class AccountDetailsController {

  /** The customer service. */
  @Autowired
  private CustomerServicesImpl customerService;

  /** The account service. */
  @Autowired
  private AccountServicesImpl accountService;

  /**
   * Details.
   *
   * @param accountNumber the account number
   * @param model         the model
   * @return the string
   */
  @PostMapping("/accountDetails")
  public String details(@RequestParam("accountNumber") int accountNumber, Model model) {
    try {
      Account account = accountService.getAccountByNumber(accountNumber);
      Customer customer = customerService.getCustomerById(account.getCustomerId());
      model.addAttribute("doesDetailsExists", "yes");
      model.addAttribute("customerId", account.getCustomerId());
      model.addAttribute("customerName", customer.getName());
      model.addAttribute("emailId", customer.getEmailid());
      model.addAttribute("balance", account.getBalance());
    } catch (Exception e) {
      model.addAttribute("doesDetailsExists", e.getMessage());
    }
    return "accountDetails";
  }
}
