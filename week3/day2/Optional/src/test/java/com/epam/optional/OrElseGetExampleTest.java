/**
 * Test OrElseGetExample class.
 */

// To Do 
// 1. Test for null  index value
// 2. Test for non null  index value

package com.epam.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class OrElseGetExampleTest.
 *
 * @author Nitin_Hasija
 */
class OrElseGetExampleTest {

  /** The names. */
  private static String[] names;

  /** The index. */
  private int index;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    names = new String[5];
  }

  /**
   * Test for null index value.
   */
  @Test
  @DisplayName("Test when index value is null")
  public void testNullindexvalue() {
    index = 0;
    assertEquals("not defined", OrElseGetExample.getIndexValue(names, index));
  }

  /**
   * Test for non null index value.
   */
  @Test
  @DisplayName("Test for non null index value")
  public void testNotNullindexvalue() {
    index = 2;
    names[index] = "abc";
    assertNotEquals("not defined", OrElseGetExample.getIndexValue(names, index));
  }
}
