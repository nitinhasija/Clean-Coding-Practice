/*
 * This class computes distinct names from list
 */

package com.epam.stream.distinctnames;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class DistinctNames.
 *
 * @author Nitin_Hasija
 */
public class DistinctNames {

  /**
   * identifies the distinct names from the list.
   *
   * @param array an array of strings
   * @return a list of distinct strings
   */
  public List<Object> getDistinctNames(String[] array) {
    return Arrays.asList(array).stream().distinct().collect(Collectors.toList());
  }
}
