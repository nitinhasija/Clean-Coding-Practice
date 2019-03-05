/*
 * Evaluate string array using function in lambda expession
 */

package com.epam.lambdaexpressions.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * The Class FunctionalExample.
 *
 * @author Nitin_Hasija
 */
public class FunctionalExample {

  /**
   * Instantiates a new functional example.
   */
  private FunctionalExample() {

  }

  /**
   * Evaluate.
   *
   * @param names    the names
   * @param function the function
   * @return the list
   */
  public static List<String> evaluate(String[] names, Function<String, String> function) {
    List<String> nameList = new ArrayList<>();
    for (String name : names) {
      nameList.add(function.apply(name));
    }
    return nameList;
  }
}
