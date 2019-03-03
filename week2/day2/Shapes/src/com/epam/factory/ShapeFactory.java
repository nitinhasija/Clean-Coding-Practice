/*
 * A factory class
 */

package com.epam.factory;

import com.epam.model.Shape;

/**
 * Factory class implementation.
 *
 * @author Nitin_Hasija
 */
public class ShapeFactory {

  /**
   * Change first letter.
   *
   * @param shapeName the shape name
   * @return the string
   */
  private String changeFirstLetter(String shapeName) {

    String className = shapeName.charAt(0) + "";
    className = className.toUpperCase();
    className += shapeName.substring(1, shapeName.length());

    return className;
  }

  /**
   * Gets the shape object.
   *
   * @param shapeName the shape name
   * @return the shape object
   */
  public Shape getShapeObject(String shapeName) {
    String validShapeName = changeFirstLetter(shapeName);
    try {
      Class<?> cls = Class.forName("com.epam.shapes." + validShapeName);
      return (Shape) cls.newInstance();
    }

    catch (ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
      System.out.println("class is not available");
      return null;
    }
  }
}
