package com.epam.servlets;

import com.epam.bank.exceptions.AccountNotFoundException;
import com.epam.bank.exceptions.InvalidTransactionException;
import com.epam.bank.services.AccountServices;
import com.epam.bank.services.TransactionValidation;
import com.epam.daoimplement.AccountDatabase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Withdraw.
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new withdraw.
   *
   * @see HttpServlet#HttpServlet()
   */
  public Withdraw() {
    super();
  }

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
      double amountToWithdraw = Double.parseDouble(request.getParameter("amount"));

      if (TransactionValidation.isValidDepositeAmount(amountToWithdraw)) {
        accountService.withdraw(accountNumber, amountToWithdraw);
        request.setAttribute("amountWithdrawnStatus", "Amount withdrawn: Rs." + amountToWithdraw);
      }

    } catch (AccountNotFoundException | NumberFormatException | InvalidTransactionException e) {
      request.setAttribute("amountWithdrawnStatus", e.getMessage());
    }
    request.getRequestDispatcher("/withdrawAmount.jsp").forward(request, response);
  }
}