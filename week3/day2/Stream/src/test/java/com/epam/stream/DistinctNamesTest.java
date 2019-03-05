/**
 * Test functionality of distinctName class 
 */

// To Do
// 1. Test for null array
// 2. Test for non null array

package com.epam.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.stream.distinctnames.DistinctNames;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class DistinctNamesTest.
 *
 * @author Nitin_Hasija
 */
class DistinctNamesTest {

  /** The mixed array. */
  private String[] mixedArray;

  /** The distinct names. */
  private static DistinctNames distinctNames;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    distinctNames = new DistinctNames();
  }

  /**
   * Test when array is null.
   */
  @Test
  @DisplayName("Test when array is null")
  public void testNullArray() {
    mixedArray = null;
    assertThrows(NullPointerException.class, () -> distinctNames.getDistinctNames(mixedArray));
  }

  /**
   * Test for non null array.
   */
  @Test
  @DisplayName("Test for not null array")
  public void testNonNullArray() {
    List<String> expectedList = new ArrayList<String>();
    expectedList.add("abc");
    expectedList.add("pqr");
    expectedList.add("tuv");
    expectedList.add("xyz");
    

    mixedArray = new String[] { "abc", "pqr", "abc", "tuv", "abc", "xyz", "pqr", "xyz", "abc" };

    assertEquals(expectedList, distinctNames.getDistinctNames(mixedArray));
  }
}
