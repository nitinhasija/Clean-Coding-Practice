package com.epam.student;

/**
 * The Class Student.
 * 
 * @author Nitin_Hasija
 */
final class Student {

  /** The roll number. */
  private final int rollNumber;

  /** The name. */
  private final String name;

  /**
   * Instantiates a new student.
   *
   * @param rollNumber of a student
   * @param name       of student
   */
  Student(int rollNumber, String name) {
    this.rollNumber = rollNumber;
    this.name = name;
  }

  /**
   * Gets the roll number.
   *
   * @return student's roll number
   */
  int getRollNumber() {
    return rollNumber;
  }

  /**
   * Gets the name.
   *
   * @return student's name
   */
  String getName() {
    return name;
  }
}