/*
 * Custom exception
 */

package com.epam.exception;

/**
 * The Class OutOfRangeException.
 * 
 * @author Nitin_Hasija
 */
public class OutOfRangeException extends Exception {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /**
   * Instantiates a new out of range exception.
   */
  public OutOfRangeException() {
    super("Exception found:");
  }
}
