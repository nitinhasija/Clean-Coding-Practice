/**
 * Test OrElseExample class functionality
 */

// To Do 
// 1. Test for null string
// 2. Test for non empty string

package com.epam.optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class OrElseExampleTest.
 *
 * @author Nitin_Hasija
 */
class OrElseExampleTest {

  /** The name. */
  private String name;

  /**
   * Test when name is null.
   */
  @Test
  @DisplayName("Test when name is null")
  public void testNullString() {
    name = null;
    assertDoesNotThrow(() -> OrElseExample.convertToUpperCase(name));
  }

  /**
   * Test when name is non empty.
   */
  @Test
  @DisplayName("Test when name is not null")
  public void testNonEmptyString() {
    name = "abcd";
    assertEquals("ABCD", OrElseExample.convertToUpperCase(name));
  }
}
