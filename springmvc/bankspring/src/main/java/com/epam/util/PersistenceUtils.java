/**
 * 
 */

package com.epam.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The Class PersistenceUtils.
 *
 * @author Nitin_Hasija
 */
public class PersistenceUtils {

  /** The entity manager. */
  private static EntityManager entityManager;

  /**
   * Instantiates a new persistence utils.
   */
  private PersistenceUtils() {
  }

  /**
   * Gets the entity manager.
   *
   * @return the entity manager
   */
  public static EntityManager getEntityManager() {
    if (entityManager == null) {
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
      entityManager = factory.createEntityManager();
    }
    return entityManager;
  }
}
