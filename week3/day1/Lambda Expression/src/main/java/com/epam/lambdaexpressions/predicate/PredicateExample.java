/*
 * Return a list of numbers that fulfills predicate condition
 */

package com.epam.lambdaexpressions.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

/**
 * The Class PredicateExample.
 *
 * @author Nitin_Hasija
 */
public class PredicateExample {

  /**
   * Instantiates a new predicate example.
   */
  private PredicateExample() {

  }

  /**
   * Gets the numbers.
   *
   * @param predicate the predicate
   * @param array     the array
   * @return the numbers
   */
  public static List<Integer> getNumbers(IntPredicate predicate, int[] array) {
    List<Integer> evenNumbers = new ArrayList<>();

    for (int num : array) {
      if (predicate.test(num)) {
        evenNumbers.add(num);
      }
    }

    return evenNumbers;
  }
}
