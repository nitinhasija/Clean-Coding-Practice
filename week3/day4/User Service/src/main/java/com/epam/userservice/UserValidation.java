/*
 * check if a user is valid or not
 */

package com.epam.userservice;

/**
 * The Class UserValidation.
 * 
 * @author Nitin_Hasija
 */
public class UserValidation {

  /**
   * Checks if is valid user.
   *
   * @param user the user
   * @return true, if is valid user
   */
  public boolean isValidUser(User user) {
    return isFirstNameValid(user) && isLastNameValid(user);
  }

  /**
   * First name is valid.
   *
   * @param user the user
   * @return true, if successful
   */
  private boolean isFirstNameValid(User user) {
    return user.getFirstName().length() > NameLength.MIN_LENGTH.getLength()
        && user.getFirstName().length() < NameLength.MAX_LENGTH.getLength();
  }

  /**
   * Last name is valid.
   *
   * @param user the user
   * @return true, if successful
   */
  private boolean isLastNameValid(User user) {
    return user.getLastName().length() > NameLength.MIN_LENGTH.getLength()
        && user.getLastName().length() < NameLength.MAX_LENGTH.getLength();
  }
}
