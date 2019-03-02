/*
 * Main Class
 */

package com.epam.student;

import java.util.List;
import java.util.Scanner;

/**
 * The Class Main.
 * 
 * @author Nitin_Hasija
 */
public class Main {

  /**
   * The main method.
   *
   * @param agr the arguments
   */
  public static void main(String[] agr) {

    System.out.println("1. Add Student Details");
    System.out.println("2. View Student Details");
    System.out.println("3. Exit");

    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    StudentManager manager = new StudentManager();

    while (true) {
      System.out.println("Choose Options from above:");
      int option = scanner.nextInt();

      switch (option) {
      case 1:
        System.out.println("Enter roll number and name of student");
        int rollNumber = scanner.nextInt();
        String name = scanner.nextLine();

        manager.addStudent(rollNumber, name);
        break;

      case 2:
        List<Student> list = manager.getStudents();
        manager.viewList(list);
        break;

      case 3:
        System.out.println("Thanks...");
        System.exit(0);
        break;

      default:
        System.out.println("Invalid Option");
        break;
      }
    }
  }
}
