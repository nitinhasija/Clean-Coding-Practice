/*
 * Main class 
 */

package com.epam.planet;

/**
 * Main class to display all utilities of an immutable planet class.
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
    PlanetManager manager = new PlanetManager();

    Planet planet = manager.createPlanet();

    System.out.println(planet.getName() + " is found having " + planet.getMass() + " kg mass and having oceans:");

    for (Oceans ocean : planet.getOceanList())
      System.out.println(ocean.getName());

    System.out.println("and has continents:");

    for (Continents continent : planet.getContinentList())
      System.out.println(continent.getName());
  }
}
