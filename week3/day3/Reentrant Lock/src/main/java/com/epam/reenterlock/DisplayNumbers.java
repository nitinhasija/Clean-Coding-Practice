/*
 * This class prints the counting using threads and reentrant lock.
 */

package com.epam.reenterlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * The Class DisplayNumbers.
 * 
 * @author Nitin_Hasija
 */
public class DisplayNumbers extends Thread {

  /** The limit. */
  private static int limit;

  /** The count. */
  private int count;

  /** The relock. */
  private static ReentrantLock relock;

  /**
   * Sets the limit.
   *
   * @param num the new limit
   */
  static void setLimit(int num) {
    limit = num;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {
    while (count < limit) {
      relock.lock(); // only one thread will print the count value and rest will wait
      System.out.println(++count);
      relock.unlock();
    }
  }
}
