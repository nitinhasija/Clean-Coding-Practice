package com.epam.student;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class StudentManager.
 * 
 * @author Nitin Hasija
 */
class StudentManager {

  /** The student list. */
  private ArrayList<Student> studentList;

  /**
   * Constructor to initialize list.
   */
  public StudentManager() {
    studentList = new ArrayList<>();
  }

  /**
   * Adds the student.
   *
   * @param rollNum the roll num
   * @param name    the name
   */
  public void addStudent(int rollNum, String name) {
    studentList.add(new Student(rollNum, name));
  }

  /**
   * Gets the students.
   *
   * @return the students
   */
  public List<Student> getStudents() {
    return studentList;
  }

  /**
   * View list.
   *
   * @param list the list
   */
  public void viewList(List<Student> list) {
    for (Student eachStudent : list)
      System.out.println(
          "Student's roll number: '" + eachStudent.getRollNumber() + "' and name:" + eachStudent.getName() + "");
  }
}
