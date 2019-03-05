/**
 * Test cases for NumberUtil class
 */

// To Do
// 1. Test to compute the count of even numbers
// 2. Test to compute the count of odd numbers
// 3. Test to compute the sum of even numbers
// 4. Test to compute the sum of odd numbers

package com.epam.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.stream.oddeven.NumbersUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class OddEvenTest.
 *
 * @author Nitin_Hasija
 */
class OddEvenTest {

  /** The list of numbers. */
  private static List<Integer> listOfNumbers;

  /** The number util. */
  private static NumbersUtil numberUtil;

  /** The expected value. */
  private int expectedValue;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    listOfNumbers = new ArrayList<Integer>();
    listOfNumbers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

    numberUtil = new NumbersUtil(listOfNumbers);
  }

  /**
   * Test to compute the count of odd numbers.
   */
  @Test
  @DisplayName("Test to compute the count of odd numbers")
  void testCountOddNumbers() {
    expectedValue = 50;
    assertEquals(expectedValue, numberUtil.getOddCount());
  }

  /**
   * Test to compute the count of even numbers.
   */
  @Test
  @DisplayName("Test to compute the count of even numbers")
  void testCountEvenNumbers() {
    expectedValue = 50;
    assertEquals(expectedValue, numberUtil.getEvenCount());
  }

  /**
   * Test to compute the sum of odd numbers.
   */
  @Test
  @DisplayName("Test to compute the sum of even numbers")
  void testSumEvenNumbers() {
    expectedValue = 2550;
    assertEquals(expectedValue, numberUtil.getEvenNumberSum());
  }

  /**
   * Test to compute the count of even numbers.
   */
  @Test
  @DisplayName("Test to compute the sum of odd numbers")
  void testSumOddNumbers() {
    expectedValue = 2500;
    assertEquals(expectedValue, numberUtil.getOddNumberSum());
  }
}
