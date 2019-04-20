package com.epam.controllers;

import com.epam.util.ConstantUtils;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Class Login.
 *
 * @author Nitin_Hasija
 */
@Controller
public class LoginController {

  /**
   * Login.
   *
   * @param username the username
   * @param password the password
   * @param session  the session
   * @param model    the model
   * @return the string
   */
  @PostMapping("/login")
  public String login(@RequestParam("username") String username,
      @RequestParam("password") String password, HttpSession session, Model model) {
    String page = "";
    if (username.equals(ConstantUtils.USERNAME) && password.equals(ConstantUtils.PASSWORD)) {
      session.setAttribute("username", username);
      page = "welcomePage";
    } else {
      model.addAttribute("loginError", ConstantUtils.LOGIN_ERROR);
      page = "login";
    }
    return page;
  }
}
