/*
 * Test cases for functions in lambda expression
 */

// To Do 
// 1. Test for null array
// 2. Test for valid array

package com.epam.lambdaexpression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.lambdaexpressions.function.FunctionalExample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class FunctionTest.
 *
 * @author Nitin_Hasija
 */
class FunctionTest {

  /** The names. */
  private String[] names;

  /** The function. */
  private Function<String, String> function;

  /**
   * Test when array is null.
   */
  @Test
  @DisplayName("Test when array is null")
  public void testNullArray() {
    names = null;
    function = name -> name.toUpperCase();
    assertThrows(NullPointerException.class, () -> FunctionalExample.evaluate(names, function));
  }

  /**
   * Test when array is not empty.
   */
  @Test
  @DisplayName("Test when array is not empty")
  public void testNonNullArray() {
    names = new String[] { "abc", "pqr", "xyz" };
    function = name -> name.toUpperCase();

    List<String> expectedList = new ArrayList<String>();
    expectedList.add("ABC");
    expectedList.add("PQR");
    expectedList.add("XYZ");

    assertEquals(expectedList, FunctionalExample.evaluate(names, function));
  }
}
