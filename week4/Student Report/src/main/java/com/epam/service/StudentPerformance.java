/**
 * This class tells the student performance.
 */

package com.epam.service;

import com.epam.exception.EmptyArrayException;
import com.epam.model.Student;

import com.epam.util.Constants;

import java.util.Arrays;
import java.util.Optional;

import java.util.stream.DoubleStream;

/**
 * The Class StudentPerformance.
 * 
 * @author Nitin_Hasija
 */
class StudentPerformance {

  /** The student. */
  Student student;

  /**
   * Instantiates a new student performance.
   *
   * @param student the student
   */
  StudentPerformance(Student student) {
    this.student = student;
  }

  /**
   * Total marks.
   *
   * @return total marks
   * @throws EmptyArrayException the empty array exception
   */
  private double totalMarks() throws EmptyArrayException {
    double[] marks = getNonEmptyArray();

    return Arrays.stream(marks).sum();
  }

  /**
   * Gets the non empty array.
   *
   * @return the non empty array
   * @throws EmptyArrayException the empty array exception
   */
  private double[] getNonEmptyArray() throws EmptyArrayException {
    Optional<double[]> opt = Optional.ofNullable(student.getMarks());
    return opt.orElseThrow(() -> new EmptyArrayException("Array is Empty"));
  }

  /**
   * Total average.
   *
   * @return average of total marks
   * @throws EmptyArrayException the empty array exception
   */
  private double totalAverage() throws EmptyArrayException {
    return totalMarks() / Constants.MAX_MARKS.getScore();
  }

  /**
   * Checks if is satisfactory total average.
   *
   * @return boolean value
   * @throws EmptyArrayException the empty array exception
   */
  public boolean isSatisfactoryTotalAvg() throws EmptyArrayException {
    return totalAverage() >= Constants.REQUIRED_AVERAGE.getScore();
  }

  /**
   * Checks if is satisfactory individual average.
   *
   * @return boolean value
   * @throws EmptyArrayException the empty array exception
   */
  public boolean isSatisfactoryIndividualAvg() throws EmptyArrayException {
    double[] marks = getNonEmptyArray();
    return !containsLessIndividualMarks(marks);
  }

  /**
   * Contains less individual marks.
   *
   * @param marks the marks
   * @return true, if successful
   */
  private boolean containsLessIndividualMarks(double[] marks) {
    return DoubleStream.of(marks).anyMatch(score -> score < Constants.INDIVIDUAL_MARKS.getScore());
  }
}
