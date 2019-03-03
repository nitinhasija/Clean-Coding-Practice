/*
 * Square Class
 */

package com.epam.shape;

import com.epam.model.Shape;

/**
 * Represents a Rectangle that implements shape interface.
 *
 * @author Nitin_Hasija
 */
public class Rectangle implements Shape {

  /*
   * (non-Javadoc)
   * 
   * @see com.epam.model.Shape#drawShape()
   */
  @Override
  public void drawShape() {
    System.out.println("Rectangle has drawn");
  }
}