/**
 * class to test selectQuery functionality
 */
package com.epam.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.epam.query.SelectQuery;

/**
 * The Class SelectQueryTest.
 *
 * @author Nitin_Hasija
 */
class SelectQueryTest {

  /** The query demo. */
  static private SelectQuery queryDemo;

  /** The expected name list. */
  private List<String> expectedNameList;

  /**
   * when dbname or query is incorrect.
   */
  @Test
  @DisplayName("when dbname or query is incorrect")
  public void testingWrongQuery() {
    assertThrows(SQLException.class, () -> new SelectQuery("student_database", "Select  from student_info"));
  }

  /**
   * Testing right query.
   *
   * @throws ClassNotFoundException the class not found exception
   * @throws SQLException           when dbname and query is correct
   */
  @Test
  @DisplayName("when dbname and query is correct")
  public void testingRightQuery() throws ClassNotFoundException, SQLException {
    assertDoesNotThrow(() -> new SelectQuery("student_database", "Select name from student_info"));
  }

  /**
   * Test with forward result set.
   *
   * @throws SQLException           the SQL exception
   * @throws ClassNotFoundException when result displays in forward way
   */
  @Test
  @DisplayName("when result displays in forward way")
  public void testWithForwardResultSet() throws SQLException, ClassNotFoundException {
    queryDemo = new SelectQuery("student_database", "Select name from student_info");

    expectedNameList = new ArrayList<String>();
    expectedNameList.add("abc");
    expectedNameList.add("pqr");
    expectedNameList.add("xyz");

    assertEquals(expectedNameList, queryDemo.getForwardListOfNames());
  }

  /**
   * Test with backward result set.
   *
   * @throws SQLException           the SQL exception
   * @throws ClassNotFoundException when result displays in backward way
   */
  @Test
  @DisplayName("when result displays in backward way")
  public void testWithBackwardResultSet() throws SQLException, ClassNotFoundException {
    queryDemo = new SelectQuery("student_database", "Select name from student_info");

    expectedNameList = new ArrayList<String>();
    expectedNameList.add("xyz");
    expectedNameList.add("pqr");
    expectedNameList.add("abc");

    assertEquals(expectedNameList, queryDemo.getBackwardListOfNames());
  }

}
