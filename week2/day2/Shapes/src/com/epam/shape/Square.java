/*
 * Square class
 */

package com.epam.shape;

import com.epam.model.Shape;

/**
 * The Class Square.
 */
public class Square implements Shape {

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.model.Shape#drawShape()
   */
  @Override
  public void drawShape() {
    System.out.println("Square has drawn");
  }
}