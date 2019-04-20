package com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login.
 */
@WebServlet("/login")
public class Login extends HttpServlet {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new login.
   *
   * @see HttpServlet#HttpServlet()
   */
  public Login() {
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
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username.equals("admin") && password.equals("12345")) {
      HttpSession session = request.getSession();
      session.setAttribute("username", username);
      response.sendRedirect("welcomePage.jsp");
    } else {
      request.setAttribute("loginError", "Username or Password is invalid");
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }
}