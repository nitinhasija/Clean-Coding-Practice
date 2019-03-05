/**
 * Test OrElseThrowExample class.
 */

// To Do 
// 1. Test for null value
// 2. Test for non null  value

package com.epam.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class OrElseThrowTest.
 *
 * @author Nitin_Hasija
 */
class OrElseThrowTest {

  /** The name. */
  private static String name;

  /**
   * Test when name is null.
   */
  @Test
  @DisplayName("Test when name is null")
  public void testNullString() {
    name = null;
    assertThrows(IllegalArgumentException.class, () -> OrElseThrowExample.getStringLength(name));
  }

  /**
   * Test when name is non empty.
   */
  @Test
  @DisplayName("Test when name is not null")
  public void testNonEmptyString() {
    name = "abcd";
    int expectedValue = 4;
    assertEquals(expectedValue, OrElseThrowExample.getStringLength(name));
  }
}
