/*
 * Test for user service
 */

// To Do 
// 1. Test for a valid user.
// 2. Test for an invalid user.

package com.epam;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.userservice.User;
import com.epam.userservice.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class UserServiceTest.
 * 
 * @author Nitin_Hasija
 */
class UserServiceTest {

  /** The service. */
  private UserService service;

  /** The user. */
  private User user;

  /**
   * Inits the.
   */
  @BeforeEach
  void init() {
    service = new UserService();
    user = new User();
  }

  /**
   * Test for a valid user.
   */
  @Test
  @DisplayName("Test to provide services if it is a valid user")
  void testIfUserIsValid() {
    user.setFirstName("nitin");
    user.setLastName("hasija");
    assertTrue(service.isServiceActivated(user));
  }

  /**
   * Test for an invalid user.
   */
  @Test
  @DisplayName("Test to not provide services if it is not a valid user")
  void testIfUserIsNotValid() {
    user.setFirstName("abc");
    user.setLastName("hasija");
    assertFalse(service.isServiceActivated(user));
  }
}
