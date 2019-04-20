package com.epam.filter;

import com.epam.bank.model.Customer;
import com.epam.bank.services.CustomerValidation;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class UpdateCustomerDetails.
 */
@WebFilter("/updateCustomerDetails")
public class CustomerUpdateAuthentication implements Filter {

  /** The dummy customer. */
  private Customer dummyCustomer;

  /** The validation. */
  private CustomerValidation validation;

  /*
   * (non-Javadoc)
   * 
   * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
   */
  @Override
  public void init(FilterConfig arg0) throws ServletException {
    dummyCustomer = new Customer();
    validation = new CustomerValidation();
  }

  /**
   * Do filter.
   *
   * @param request  the request
   * @param response the response
   * @param chain    the chain
   * @throws IOException      Signals that an I/O exception has occurred.
   * @throws ServletException the servlet exception
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    String name = request.getParameter("name");
    String emailId = request.getParameter("emailId");

    try {
      long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));
      dummyCustomer.setMobileNumber(mobileNumber);
    } catch (NumberFormatException e) {
      request.setAttribute("incorrectMobileNumber", "Invalid Mobile Number");
    }

    dummyCustomer.setName(name);
    dummyCustomer.setEmailId(emailId);

    String accNumber = request.getParameter("accountNumber");

    if (accNumber.matches(".*[a-zA-Z]+.*")) {
      request.setAttribute("customerDetailsUpdateStatus", "Invalid AccountNumber");
    } else if (validation.isValid(dummyCustomer)) {
      request.setAttribute("accountNumber", accNumber);
      request.setAttribute("dummyCustomer", dummyCustomer);
      chain.doFilter(request, response);
    } else {
      request.setAttribute("customerDetailsUpdateStatus", "Invalid Credentials");
    }

    request.getRequestDispatcher("/updateCustomerDetails.jsp").forward(request, response);
  }
}