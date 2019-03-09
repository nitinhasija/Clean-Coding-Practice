/**
 *  class contains constant fields used in database
 */

package com.epam.connection;

/**
 * The Class ConstantsUtility.
 *
 * @author Nitin_Hasija
 */
public class ConstantsUtility {

  /**
   * Instantiates a new constants utility.
   */
  private ConstantsUtility() {

  }

  /** The Constant URL. */
  private static final String URL = "jdbc:mysql://localhost:3306/";

  /** The Constant USERNAME. */
  private static final String USERNAME = "root";

  /** The Constant PASSOWRD. */
  private static final String PASSOWRD = "root";

  /**
   * Gets the url.
   *
   * @return url of the connection
   */
  public static final String getURL() {
    return URL;
  }

  /**
   * Gets the username.
   *
   * @return username of the database
   */
  public static final String getUsername() {
    return USERNAME;
  }

  /**
   * Gets the password.
   *
   * @return password of the database
   */
  public static final String getPassword() {
    return PASSOWRD;
  }
}
