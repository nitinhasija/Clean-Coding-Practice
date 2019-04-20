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
 * Servlet implementation class AccountDetails.
 */
@WebServlet("/accountDetails")
public class AccountDetails extends HttpServlet {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

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

    AccountServices accountService = new AccountServices(AccountDatabase.getInstance());
    CustomerServices customerServices = new CustomerServices(CustomerDatabase.getInstance());

    try {
      int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
      Account account = accountService.getAccountByNumber(accountNumber);
      Customer customer = customerServices.getCustomerById(account.getCustomerId());

      request.setAttribute("doesDetailsExists", "yes");
      request.setAttribute("customerId", account.getCustomerId());
      request.setAttribute("customerName", customer.getName());
      request.setAttribute("emailId", customer.getEmailid());
      request.setAttribute("balance", account.getBalance());
    } catch (Exception e) {
      request.setAttribute("doesDetailsExists", e.getMessage());
    }
    request.getRequestDispatcher("/accountDetails.jsp").forward(request, response);
  }
}
