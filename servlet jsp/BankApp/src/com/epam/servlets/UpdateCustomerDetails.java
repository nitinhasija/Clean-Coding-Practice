package com.epam.servlets;

import com.epam.bank.exceptions.AccountNotFoundException;
import com.epam.bank.exceptions.InvalidCustomerException;
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
 * Servlet implementation class UpdateCustomerDetails.
 */
@WebServlet("/updateCustomerDetails")
public class UpdateCustomerDetails extends HttpServlet {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new update customer details.
   *
   * @see HttpServlet#HttpServlet()
   */
  public UpdateCustomerDetails() {
    super();
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
    CustomerServices customerServices = new CustomerServices(CustomerDatabase.getInstance());

    Customer dummyCustomer = (Customer) request.getAttribute("dummyCustomer");
    try {
      int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
      AccountServices accountServices = new AccountServices(AccountDatabase.getInstance());
      int customerId = accountServices.getAccountByNumber(accountNumber).getCustomerId();
      
      if (customerServices.updateCustomerDetails(customerId, dummyCustomer)) {
        request.setAttribute("customerDetailsUpdateStatus", "Successfully Updated Details");
      }
    } catch (InvalidCustomerException | AccountNotFoundException e) {
      request.setAttribute("customerDetailsUpdateStatus", e.getMessage());
    }
  }
}
