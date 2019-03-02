/*
 * class to convert into desired string
 */

package com.epam.arraytostring;

/**
 * This class converts the array to string.
 *
 * @author Nitin_Hasija
 */
public class ConvertToString {

  /**
   * As matrix.
   *
   * @param array contains elements entered by the user
   * @return the desired string
   */
  public String asMatrix(double[][] array) {
    String str = "";

    for (int row = 0; row < array.length; row++) {
      for (int column = 0; column < array[0].length; column++)
        str += array[row][column] + " ";

      str += "\n";
    }
    return str;
  }
}
