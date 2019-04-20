/**
 * Logout Controller
 */

package com.epam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class LogoutController.
 *
 * @author Nitin_Hasija
 */
@Controller
public class LogoutController {

  /**
   * Logout.
   *
   * @param session the session
   * @return the string
   */
  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "login";
  }
}
