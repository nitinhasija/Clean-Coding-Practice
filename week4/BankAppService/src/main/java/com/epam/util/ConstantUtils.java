/**
 * 
 */

package com.epam.util;

/**
 * The Class ConstantUtils.
 *
 * @author Nitin_Hasija
 */
public class ConstantUtils {

  /**
   * Instantiates a new constant utils.
   */
  private ConstantUtils() {
  }

  /** The Constant PASSWORD. */
  public static final String PASSWORD = "12345";

  /** The Constant USERNAME. */
  public static final String USERNAME = "admin";

  /** The Constant DEPOSITE_STATUS. */
  public static final String DEPOSITE_STATUS = "Amount deposited successfully!! Rs.";

  /** The Constant WITHDRAW_STATUS. */
  public static final String WITHDRAW_STATUS = "Amount withdrawn: Rs.";

  /** The Constant ACCOUNT_STATUS. */
  public static final String ACCOUNT_STATUS = "Account created successfully with account number: ";

  /** The Constant ACCOUNT_DELETION. */
  public static final String ACCOUNT_DELETION = "Account deleted Sucessfully";

  /** The Constant LOGIN_ERROR. */
  public static final String LOGIN_ERROR = "Sorry!! Username or Password is invalid";

  /** The Constant UPDATE_STATUS. */
  public static final String UPDATE_STATUS = "Successfully Updated Details";

  /** The Constant ACCOUNT_NOT_FOUND. */
  public static final String ACCOUNT_NOT_FOUND = "Sorry!! Account Not Found.";

  /** The Constant INVALID_DETAILS. */
  public static final String INVALID_DETAILS = "Sorry!! Customer Details Are Invalid";

  /** The Constant INVALID_AMOUNT. */
  public static final String INVALID_AMOUNT = "Invalid Transaction Amount";

  /** The Constant SUFFIX. */
  public static final String SUFFIX = ".jsp";

  /** The Constant MOBILE_NUMBER_PATTERN. */
  public static final String MOBILE_NUMBER_PATTERN = "(0/91)?[7-9][0-9]{9}";

  /** The Constant NAME_PATTERN. */
  public static final String NAME_PATTERN = "[A-Z][a-z]+( [A-Z][a-z]+)";

  /** The Constant EMAIL_PATTERN. */
  public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+"
      + "(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
}
