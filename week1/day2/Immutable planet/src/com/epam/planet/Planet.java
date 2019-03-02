/*
 * Planet class
 */
package com.epam.planet;

import java.util.List;

/**
 * Immutable planet class.
 *
 * @author Nitin_Hasija
 */
final class Planet {

  /** The ocean list. */
  private final List<Oceans> oceanList;

  /** The continent list. */
  private final List<Continents> continentList;

  /** The name. */
  private final String name;

  /** The mass. */
  private final double mass;

  /**
   * Instantiates a new planet.
   *
   * @param oceanList     the ocean list
   * @param continentList the continent list
   * @param name          the name
   * @param mass          the mass
   */
  public Planet(List<Oceans> oceanList, List<Continents> continentList, String name, double mass) {
    this.continentList = continentList;
    this.oceanList = oceanList;
    this.name = name;
    this.mass = mass;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the mass.
   *
   * @return the mass
   */
  public double getMass() {
    return mass;
  }

  /**
   * Gets the ocean list.
   *
   * @return the ocean list
   */
  public List<Oceans> getOceanList() {
    return oceanList;
  }

  /**
   * Gets the continent list.
   *
   * @return the continent list
   */
  public List<Continents> getContinentList() {
    return continentList;
  }
}
