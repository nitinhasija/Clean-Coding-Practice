/**
 * Marks for calculating result
 */

package com.epam.util;

/**
 * The Enum Constants.
 *
 * @author Nitin_Hasija
 */
public enum Constants {
  /** The max marks. */
  MAX_MARKS(500.0),

  /** The required individual marks. */
  INDIVIDUAL_MARKS(40.0),

  /** The required average. */
  REQUIRED_AVERAGE(0.6);

  /** The score. */
  private double score = 0.0;

  /**
   * Instantiates a new constants.
   *
   * @param score the score
   */
  Constants(double score) {
    this.score = score;
  }

  /**
   * Gets the score.
   *
   * @return the score
   */
  public double getScore() {
    return score;
  }

}
