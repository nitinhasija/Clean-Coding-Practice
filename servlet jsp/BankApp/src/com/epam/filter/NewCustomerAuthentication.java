/**
 * 
 */

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
 * The Class AuthenticationFilter.
 *
 * @author Nitin_Hasija
 */

@WebFilter("/openAccount")
public class NewCustomerAuthentication implements Filter {
  private Customer customer;
  private CustomerValidation validation;

  /*
   * (non-Javadoc)
   * 
   * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
   */
  @Override
  public void init(FilterConfig arg0) throws ServletException {
    customer = new Customer();
    validation = new CustomerValidation();
  }

  /*
   * (non-Javadoc)
   * 
   * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
   * javax.servlet.ServletResponse, javax.servlet.FilterChain)
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {

    customer.setName(request.getParameter("name"));
    customer.setEmailId(request.getParameter("email"));
    try {
      customer.setMobileNumber(Long.parseLong(request.getParameter("mobileNumber")));
    } catch (NumberFormatException e) {
      request.setAttribute("incorrectMobileNumber", "Invalid Mobile Number");
    }
    if (validation.isValid(customer)) {
      request.setAttribute("customer", customer);
      filterChain.doFilter(request, response);
    } else {
      request.setAttribute("accountCreationStatus", "Cannot create account: invalid credentials");
    }
    request.getRequestDispatcher("/createAccount.jsp").forward(request, response);
  }
}
