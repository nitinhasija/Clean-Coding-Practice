/*
 * class for Area calculation 
 */

package com.epam.futureobject;

import java.util.concurrent.Callable;

/**
 * computing area of rectangle.
 *
 * @author Nitin_Hasija
 */
public class AreaOfRectangle implements Callable<Integer> {
  
  /** The length. */
  private int length;
  
  /** The breadth. */
  private int breadth;

  /**
   * constructor to initialize variables.
   *
   * @param length the length
   * @param breadth the breadth
   */
  public AreaOfRectangle(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  public Integer call() throws Exception {
    return length * breadth;
  }
}
