package com.epam.controllers;

import com.epam.exceptions.AccountNotFoundException;
import com.epam.exceptions.InvalidCustomerException;
import com.epam.service.accountservice.AccountService;
import com.epam.service.customerservice.CustomerService;
import com.epam.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class UpdateCustomerDetails.
 *
 * @author Nitin_Hasija
 */
@Controller
public class UpdateDetailsController {

  /** The customer service. */
  @Autowired
  private CustomerService customerService;

  @Autowired
  private AccountService accountService;

  /**
   * Update details.
   *
   * @param name          the name
   * @param emailId       the email
   * @param mobileNumber  the mobile number
   * @param accountNumber the account number
   * @param model         the model
   */
  @PostMapping("updateCustomerDetails")
  public String updateDetails(@RequestParam("name") String name,
      @RequestParam("emailId") String emailId, @RequestParam("mobileNumber") long mobileNumber,
      @RequestParam("accountNumber") int accountNumber, Model model) {

    try {
      int customerId = accountService.getCustomerId(accountNumber);
      if (customerService.updateCustomerDetails(customerId, name, emailId, mobileNumber)) {
        model.addAttribute("customerDetailsUpdateStatus", ConstantUtils.UPDATE_STATUS);
      }
    } catch (InvalidCustomerException | AccountNotFoundException e) {
      model.addAttribute("customerDetailsUpdateStatus", e.getMessage());
    }
    return "updateCustomerDetails";
  }
}
