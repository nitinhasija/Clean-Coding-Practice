/**
 * Test MapExample class
 */

// To Do
// 1. Test to get list of string for desired length;

package com.epam.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class MapTest.
 * 
 * @author Nitin_Hasija
 */
class MapTest {

  /** The mixed array. */
  private String[] mixedArray;

  /** The length. */
  private static int length;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    length = 4;
  }

  /**
   * Test when array is null.
   */
  @Test
  @DisplayName("Test when array is null")
  public void testNullArray() {
    mixedArray = null;
    assertThrows(NullPointerException.class, () -> MapExample.getValidStrings(mixedArray, length));
  }

  /**
   * Test for not null array.
   */
  @Test
  @DisplayName("Test for not null array")
  public void testNonNullArray() {
    mixedArray = new String[] { "abc", "xyz", null, "pqr", "nitin", null, "", "hardwork" };

    List<String> expectedList = new ArrayList<String>();
    expectedList.add("nitin");
    expectedList.add("hardwork");

    assertEquals(expectedList, MapExample.getValidStrings(mixedArray, length));
  }
}
