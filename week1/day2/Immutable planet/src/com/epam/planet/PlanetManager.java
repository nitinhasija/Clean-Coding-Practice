/*
 * Planet Manager
 */

package com.epam.planet;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages a new planet and all the utilities.
 *
 * @author Nitin_Hasija
 */
public class PlanetManager {
  /**
   * Creates the planet.
   *
   * @return planet object
   */
  public Planet createPlanet() {

    List<Oceans> oceanList = createOceans();
    List<Continents> continentList = createContinents();
    return new Planet(oceanList, continentList, "Earth", 789466.256);
  }

  /**
   * Creates the oceans.
   *
   * @return list of oceans
   */
  private List<Oceans> createOceans() {
    List<Oceans> ocean = new ArrayList<>();

    ocean.add(new Oceans("Altantic Ocean"));
    ocean.add(new Oceans("Indian Ocean"));

    return ocean;
  }

  /**
   * Creates the continents.
   *
   * @return list of oceans
   */
  private List<Continents> createContinents() {
    List<Continents> continent = new ArrayList<>();

    continent.add(new Continents("Asia"));
    continent.add(new Continents("Australia"));

    return continent;
  }
}
