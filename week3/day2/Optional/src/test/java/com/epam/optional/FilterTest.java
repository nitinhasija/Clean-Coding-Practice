/*
 * Test FilterExample class
 */

//To Do
// 1. Test for null string array
// 2. Test for mixed array

package com.epam.optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class FilterTest.
 * 
 * @author Nitin_Hasija
 */
class FilterTest {

  /** The mixed array. */
  private String[] mixedArray;

  /**
   * Test when array is null.
   */
  @Test
  @DisplayName("Test when array is null")
  public void testNullArray() {
    mixedArray = null;
    assertThrows(NullPointerException.class, () -> FilterExample.getNonEmptyStringList(mixedArray));
  }

  /**
   * Test for mixed array.
   */
  @Test
  @DisplayName("Test for mixed array")
  public void testMixedArray() {
    mixedArray = new String[] { "abc", "xyz", null, "pqr", null, "", null }; // mixed array
    List<String> expectedList = new ArrayList<String>();
    expectedList.add("abc");
    expectedList.add("xyz");
    expectedList.add("pqr");

    assertEquals(expectedList, FilterExample.getNonEmptyStringList(mixedArray));
  }
}
