/**
 * This class tells whether the student is good or bad
 */

package com.epam.service;

import com.epam.exception.EmptyArrayException;
import com.epam.model.Student;
import com.epam.util.StudentCatagory;

/**
 * The Class ReportGenerator.
 *
 * @author Nitin_Hasija
 */
public class ReportGenerator {

  /** The student. */
  Student student;

  /**
   * Checks if is good student.
   *
   * @return a boolean value
   * @throws EmptyArrayException the empty array exception
   */
  private boolean isGoodStudent() throws EmptyArrayException {
    StudentPerformance performance = new StudentPerformance(student);
    return (performance.isSatisfactoryTotalAvg() && performance.isSatisfactoryIndividualAvg());
  }

  /**
   * Gets the student status.
   *
   * @param student the student
   * @return either good or bad
   * @throws EmptyArrayException the empty array exception
   */
  public StudentCatagory getStudentStatus(Student student) throws EmptyArrayException {
    this.student = student;
    return isGoodStudent() ? StudentCatagory.GOOD : StudentCatagory.BAD;
  }
}
