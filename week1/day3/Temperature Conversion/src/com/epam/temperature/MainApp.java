/*
 * Main class
 */

package com.epam.temperature;

/**
 * Main class to take command line arguments of temperature and displays the
 * output after conversion.
 *
 * @author Nitin_Hasija
 */

public class MainApp {

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {

    TemperatureConvertor temp = new TemperatureConvertor();

    double firstArgument = Double.parseDouble(arg[0]);
    double secondArgument = Double.parseDouble(arg[1]);

    // temperature is in celcius and have to convert it into farenhiet
    if (firstArgument == 0) {
      double farenheit = temp.convertToFahrenhiet(secondArgument);
      System.out.println("Temperature is:" + farenheit + " degree farenhiet");
    }

    else { // temperature is in farenhiet and have to convert it into celcius
      double celcius = temp.convertToCelcius(secondArgument);
      System.out.println("Temperature is:" + celcius + " degree celcius");
    }
  }
}
