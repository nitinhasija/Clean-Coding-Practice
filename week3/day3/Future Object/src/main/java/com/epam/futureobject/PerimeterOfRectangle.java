/*
 * class for perimeter calculation
 */

package com.epam.futureobject;

import java.util.concurrent.Callable;

/**
 * computing perimeter of a rectangle.
 *
 * @author Nitin_Hasija
 */
public class PerimeterOfRectangle implements Callable<Integer> {

  /** The breadth. */
  private int length;
  private int breadth;

  /**
   * Instantiates a new parameter of rectangle.
   *
   * @param length  the length
   * @param breadth the breadth
   */
  public PerimeterOfRectangle(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  public Integer call() throws Exception {
    Thread.sleep(10000);
    return 2 * (length + breadth);
  }
}
