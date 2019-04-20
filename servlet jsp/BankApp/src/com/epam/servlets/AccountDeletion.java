package com.epam.servlets;

import com.epam.bank.services.AccountServices;
import com.epam.daoimplement.AccountDatabase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountDeletionServlet.
 */
@WebServlet("/deleteAccount")
public class AccountDeletion extends HttpServlet {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /*
   * (non-Javadoc)
   * 
   * @see
   * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
   * javax.servlet.http.HttpServletResponse)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    AccountServices accountService = new AccountServices(AccountDatabase.getInstance());
    try {
      int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
      accountService.deleteAccount(accountNumber);
      request.setAttribute("accountDeletionStatus", "Account deleted Sucessfully");
    } catch (Exception e) {
      request.setAttribute("accountDeletionStatus", e.getMessage());
    }
    request.getRequestDispatcher("/deleteAccount.jsp").forward(request, response);
  }
}
