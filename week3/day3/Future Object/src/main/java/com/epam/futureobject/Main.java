/*
 * Future Object Implementation
 */

package com.epam.futureobject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The Class Main.
 *
 * @author Nitin_Hasija
 */
public class Main {

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws InterruptedException the interrupted exception
   * @throws ExecutionException   the execution exception
   */
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService service = Executors.newSingleThreadExecutor();
    Future<Integer> futureOfArea = service.submit(new AreaOfRectangle(4, 5));
    Future<Integer> futureOfPerimeter = service.submit(new PerimeterOfRectangle(10, 20));

    System.out.println("Area of Rectangle is:" + futureOfArea.get());
    System.out.println("Perimeter of Rectangle is:" + futureOfPerimeter.get());
  }
}
