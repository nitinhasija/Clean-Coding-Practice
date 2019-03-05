/**
 * Test for producer class
 */

// To Do
// 1.  check the size of queue

package com.epam.blockingqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class ProcuderTest.
 *
 * @author Nitin_Hasija
 */
class ProcuderTest {

  /** The queue. */
  private static BlockingQueue<Integer> queue;

  /** The producer. */
  private static Producer producer;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    queue = new ArrayBlockingQueue<>(3);
    producer = new Producer(queue);
  }

  /**
   * Test remaining queue capacity.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  @DisplayName("Test for producer")
  public void testRemainingQueueCapacity() throws InterruptedException {
    new Thread(producer).start();
    Thread.sleep(10);
    int expectedCapacity = 0;
    assertEquals(expectedCapacity, queue.remainingCapacity());
  }
}
