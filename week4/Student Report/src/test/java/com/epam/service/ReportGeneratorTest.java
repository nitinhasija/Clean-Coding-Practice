/**
 * Test the report that is generated
 */

// To Do
// 1. Test with less total average.
// 2. Test with more total than average.
// 3. Test with less individual average.
// 4. Test with null array.

package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.exception.EmptyArrayException;
import com.epam.model.Student;
import com.epam.service.ReportGenerator;
import com.epam.util.StudentCatagory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The Class ReportGeneratorTest.
 *
 * @author Nitin_Hasija
 */
class ReportGeneratorTest {

  /** The student. */
  static Student student;

  /** The report generator. */
  static ReportGenerator reportgenerator;

  /**
   * Inits the.
   */
  @BeforeAll
  public static void init() {
    student = new Student();
    reportgenerator = new ReportGenerator();
  }

  /**
   * Test with less total average.
   *
   * @throws EmptyArrayException the empty array exception
   */
  @Test
  @DisplayName("when student has less total average and less individual average")
  public void testWithLessTotalAverage() throws EmptyArrayException {
    double[] marks = { 10.0, 15.0, 20.5, 40, 36 };
    student.setmarks(marks);
    assertEquals(StudentCatagory.BAD, reportgenerator.getStudentStatus(student));
  }

  /**
   * Test with more total than average.
   *
   * @throws EmptyArrayException the empty array exception
   */
  @Test
  @DisplayName("when student has more total average and more individual average")
  public void testWithMoreTotalThanAverage() throws EmptyArrayException {
    double[] marks = { 60, 75, 80, 65, 90 };
    student.setmarks(marks);
    assertEquals(StudentCatagory.GOOD, reportgenerator.getStudentStatus(student));
  }

  /**
   * Test with less individual average.
   *
   * @throws EmptyArrayException the empty array exception
   */
  @Test
  @DisplayName("when student has more total average but less individual average")
  public void testWithLessIndividualAverage() throws EmptyArrayException {
    double[] marks = { 80, 30, 70, 90, 65 };
    student.setmarks(marks);
    assertEquals(StudentCatagory.BAD, reportgenerator.getStudentStatus(student));
  }

  /**
   * Test with null array.
   */
  @Test
  @DisplayName("when marks array is null")
  public void testWithNullArray() {
    double[] marks = null;
    student.setmarks(marks);
    assertThrows(EmptyArrayException.class, () -> reportgenerator.getStudentStatus(student));
  }
}
