/*
 * Join elements and return a string
 */

package com.epam.joinelements;

/**
 * The Class JoinElements.
 * 
 * @author Nitin_Hasija
 */
public class JoinElements {

  /**
   * Join elements into string.
   *
   * @param array     the array
   * @param character the character
   * @return the string
   */
  String joinElementsIntoString(int[] array, char character) {
    String result = "";

    for (int index = 0; index < array.length; index++) {
      if (index + 1 == array.length)
        result += array[index];

      else
        result += array[index] + "" + character;
    }
    return result;
  }
}
