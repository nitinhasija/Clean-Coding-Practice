/*
 * Producer class implementation
 */

package com.epam.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * The Class Producer.
 *
 * @author Nitin_Hasija
 */

public class Producer implements Runnable {

  /** The queue. */
  private BlockingQueue<Integer> queue;

  /**
   * constructor to initialize variables.
   *
   * @param queue the queue
   */
  Producer(BlockingQueue<Integer> queue) {
    this.queue = queue;
  }

  /*
   * Overriding run method
   */
  @Override
  public void run() {
    for (int packetCounter = 1; packetCounter <= 10; packetCounter++) {
      try {
        queue.put(packetCounter);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
