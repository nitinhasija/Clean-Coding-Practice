/*
 * Testing the functionality of user validation class
 */

// To Do
// 1. Test for a valid user.
// 2. Test for an invalid user.

package com.epam;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.userservice.User;
import com.epam.userservice.UserValidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class UserValidationTest.
 */
class UserValidationTest {

  /** The user. */
  private User user;

  /** The user type. */
  private UserValidation validate;

  /**
   * Inits the.
   */
  @BeforeEach
  void init() {
    user = new User();
    validate = new UserValidation();
  }

  /**
   * Test for a valid user.
   */
  @Test
  @DisplayName("when first name and last name both are in range")
  void testWhenFirstAndLastNameIsInRange() {
    user.setFirstName("nitin");
    user.setLastName("hasija");

    assertTrue(validate.isValidUser(user));
  }

  /**
   * Test for an invalid user.
   */
  @Test
  @DisplayName("when only first name is not in range")
  void testOnlyFirstNameIsInRange() {
    user.setFirstName("abc");
    user.setLastName("hasija");

    assertFalse(validate.isValidUser(user));
  }

  /**
   * Test for an invalid user.
   */
  @Test
  @DisplayName("when only last name is not in range")
  void testWhenOnlyLastNameIsInRange() {
    user.setFirstName("nitin");
    user.setLastName("ab");

    assertFalse(validate.isValidUser(user));
  }

  /**
   * Test for an invalid user.
   */
  @Test
  @DisplayName("when first name and last name both are not in range")
  void testWhenFirstAndLastNameAreNotInRange() {
    user.setFirstName("nit");
    user.setLastName("abcdefghijklmnop");

    assertFalse(validate.isValidUser(user));
  }
}
