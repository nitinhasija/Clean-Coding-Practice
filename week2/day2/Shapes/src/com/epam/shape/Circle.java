/*
 * Circle class
 */

package com.epam.shape;

import com.epam.model.Shape;

/**
 * Represents a circle that implements shape interface.
 *
 * @author Nitin_Hasija
 */
public class Circle implements Shape {

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.model.Shape#drawShape()
   */
  @Override
  public void drawShape() {
    System.out.println("Circle has drawn");
  }
}