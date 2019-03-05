/*
 * Class checks services for the valid user
 */

package com.epam.userservice;

/**
 * This class provides services to the valid user.
 *
 * @author Nitin Hasija
 */
public class UserService {

  /**
   * Checks if is service activated.
   *
   * @param user the user
   * @return true, if is service activated
   */
  public boolean isServiceActivated(User user) {
    UserValidation validate = new UserValidation();
    return validate.isValidUser(user);
  }
}
