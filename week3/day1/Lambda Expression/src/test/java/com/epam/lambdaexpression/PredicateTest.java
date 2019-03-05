/**
 * Predicate testing
 */

// To Do List
// 1. Test for null array
// 2. Test for valid array

package com.epam.lambdaexpression;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.lambdaexpressions.predicate.PredicateExample;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class PredicateTest.
 *
 * @author Nitin_Hasija
 */
class PredicateTest {

  /** The predicate. */
  static IntPredicate predicate;

  /**
   * Initialize predicate.
   */
  @BeforeAll
  public static void init() {
    predicate = num -> num % 2 == 0;
  }

  /**
   * test with null array.
   */
  @Test
  @DisplayName("test with null array")
  public void nullArrayTesting() {
    int[] arr = null;
    assertThrows(NullPointerException.class, () -> PredicateExample.getNumbers(predicate, arr));
  }

  /**
   * Test for valid array.
   */
  @Test
  @DisplayName("Test for valid array")
  public void validArray() {
    List<Integer> expectedList = new ArrayList<Integer>();
    expectedList.add(10);
    expectedList.add(20);
    expectedList.add(30);
    int[] arr = { 5, 10, 15, 20, 25, 30 };
    assertEquals(expectedList, PredicateExample.getNumbers(predicate, arr));
  }
}
