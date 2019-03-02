/*
 * Convert celcius to farenhreit and vice versa
 */

package com.epam.temperature;

/**
 * The Class TemperatureConvertor.
 */
public class TemperatureConvertor {

  /**
   * Convert to fahrenhiet.
   *
   * @param celcius the celcius
   * @return the double
   */
  double convertToFahrenhiet(double celcius) {
    return (celcius * 9) / 5 + 32;
  }

  /**
   * Convert to celcius.
   *
   * @param fahrenhiet the fahrenhiet
   * @return the double
   */
  public double convertToCelcius(double fahrenhiet) {
    return (fahrenhiet - 32) * 5 / 9;
  }
}
