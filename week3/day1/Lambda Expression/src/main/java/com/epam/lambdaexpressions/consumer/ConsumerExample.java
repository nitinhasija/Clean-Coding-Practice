/*
 * consumer interface concept implementation
 */

package com.epam.lambdaexpressions.consumer;

import java.util.function.Consumer;

/**
 * The Class Example.
 *
 * @author Nitin_Hasija
 */
public class ConsumerExample {

  /**
   * The main method.
   *
   * @param arg the arguments
   */
  public static void main(String[] arg) {
    Consumer<String> c = System.out::println;

    c.accept("Hello World!!");
  }
}
