/*
 * Model class for user 
 */

package com.epam.userservice;

/**
 * The Class User.
 * 
 * @author Nitin_Hasija
 */
public class User {

  /** first name and last name of the user. */
  private String firstName;

  /** The last name. */
  private String lastName;

  /**
   * assign first name to the user.
   *
   * @param firstName is the first name of the user
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * assign last name to the user.
   *
   * @param lastName is the last name of the user
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets the first name.
   *
   * @return first name of the user
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the last name.
   *
   * @return last name of the user
   */
  public String getLastName() {
    return lastName;
  }
}
