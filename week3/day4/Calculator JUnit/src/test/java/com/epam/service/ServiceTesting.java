/*
 * Tests for calculator class 
 */

// TO DO 
// 1. Test with both +ve numbers and sum is in range.
// 2. Test with both -ve numbers and sum is in range.
// 3. Test with one +ve numbers and one -ve number and sum is in range.
// 4. Test with both +ve boundary values.
// 5. Test with both -ve boundary values.

package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.exception.OutOfRangeException;
import com.epam.services.Services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class CalculatorTesting.
 * 
 * @author Nitin_Hasija
 */

class ServiceTesting {

  /** The calculate. */
  private static Services service;

  /**
   * This method initialize data member.
   */
  @BeforeAll
  private static void init() {
    service = new Services();
  }

  /**
   * test with both +ve numbers and sum is in range.
   *
   * @throws OutOfRangeException the out of range exception
   */
  @Test
  @DisplayName("Test with two positive numbers and sum will be in integer range")
  void testWithBothPositiveNumbers() throws OutOfRangeException {
    assertEquals(5, service.add(2, 3));
  }

  /**
   * test with both -ve numbers and sum is in range.
   *
   * @throws OutOfRangeException the out of range exception
   */
  @Test
  @DisplayName("Test with two negative numbers and sum will be in integer range")
  void testWithBothNegativeNumbers() throws OutOfRangeException {
    assertEquals(-7, service.add(-3, -4));
  }

  /**
   * test with one +ve numbers and one -ve number and sum is in range.
   *
   * @throws OutOfRangeException the out of range exception
   */
  @Test
  @DisplayName("test with one +ve numbers and one -ve number and sum is in range")
  void testWithOnePositive() throws OutOfRangeException {
    assertEquals(-1, service.add(3, -4));
  }

  /**
   * test with both +ve boundary values.
   *
   * @throws OutOfRangeException the out of range exception
   */
  @Test
  @DisplayName("Test when both the numbers have maximum integer value and sum will be out of range")
  void testWithPositiveBoundaryValue() throws OutOfRangeException {
    int maxValue = Integer.MAX_VALUE;
    assertThrows(OutOfRangeException.class, () -> service.add(maxValue, maxValue));
  }

  /**
   * test with both -ve boundary values.
   *
   * @throws OutOfRangeException the out of range exception
   */
  @Test
  @DisplayName("Test when both the numbers have minimum integer value and sum will be +ve")
  void testWithNegativeBoundaryValue() throws OutOfRangeException {
    int minValue = Integer.MIN_VALUE;
    assertThrows(OutOfRangeException.class, () -> service.add(minValue, minValue));
  }
}