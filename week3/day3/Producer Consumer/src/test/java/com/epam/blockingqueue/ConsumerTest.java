/**
 * Test for Consumer class
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
class ConsumerTest {

  /** The queue. */
  private static BlockingQueue<Integer> queue;

  /** The producer. */
  private static Consumer consumer;

  /**
   * Inits the.
   *
   * @throws InterruptedException the interrupted exception
   */
  @BeforeAll
  public static void init() throws InterruptedException {
    queue = new ArrayBlockingQueue<>(3);
    queue.put(1);
    queue.put(2);
    queue.put(3);

    consumer = new Consumer(queue);
  }

  /**
   * Test remaining queue capacity.
   *
   * @throws InterruptedException the interrupted exception
   */
  @Test
  @DisplayName("Test for Consumer")
  public void testRemainingQueueCapacity() throws InterruptedException {
    new Thread(consumer).start();
    Thread.sleep(10);
    int expectedCapacity = 3;
    assertEquals(expectedCapacity, queue.remainingCapacity());
  }
}
