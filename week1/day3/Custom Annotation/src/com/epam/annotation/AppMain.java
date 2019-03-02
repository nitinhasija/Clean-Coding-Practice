/*
 * Main class
 */

package com.epam.annotation;

import java.lang.annotation.Annotation;

/**
 * The Class Main.
 * 
 * @author Nitin_Hasija
 */
@Information(author = "nitin", version = 1.1)
public class AppMain {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {

    AppMain app = new AppMain();
    Annotation annotation = app.getClass().getAnnotation(Information.class);
    Information info = (Information) annotation;
    System.out.println(info.author());
    System.out.println(info.version());
  }
}
