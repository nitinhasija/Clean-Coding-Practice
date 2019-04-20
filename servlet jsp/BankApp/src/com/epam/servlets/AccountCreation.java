package com.epam.servlets;

import com.epam.bank.model.Account;
import com.epam.bank.model.Customer;
import com.epam.bank.services.AccountServices;
import com.epam.bank.services.CustomerServices;
import com.epam.daoimplement.AccountDatabase;
import com.epam.daoimplement.CustomerDatabase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerDetailsServlet.
 */
@WebServlet("/openAccount")
public class AccountCreation extends HttpServlet {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The customer service. */
  private final CustomerServices customerService;

  /** The account service. */
  private final AccountServices accountService;

  /**
   * Instantiates a new account creation.
   *
   * @see HttpServlet#HttpServlet()
   */
  public AccountCreation() {
    customerService = new CustomerServices(CustomerDatabase.getInstance());
    accountService = new AccountServices(AccountDatabase.getInstance());
  }

  /**
   * Do post.
   *
   * @param request  the request
   * @param response the response
   * @throws ServletException the servlet exception
   * @throws IOException      Signals that an I/O exception has occurred.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Customer customer = (Customer) request.getAttribute("customer");
    try {
      if (customerService.saveCustomerDetails(customer)) {
        Account account = accountService.createAccount(customer);
        request.setAttribute("accountCreationStatus",
            "Account created successfully with account number: " + account.getAccountNumber());
      }
    } catch (Exception e) {
      request.setAttribute("accountCreationStatus", e.getMessage());
    }
  }
}
