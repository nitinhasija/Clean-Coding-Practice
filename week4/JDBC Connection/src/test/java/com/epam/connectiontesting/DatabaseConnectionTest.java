/**
 * Database Connection Testing
 */

// To Do
// 1. Test wrong connection.
// 2. Test right connection.

package com.epam.connectiontesting;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.epam.connection.DatabaseConnection;

/**
 * The Class DatabaseConnectionTest.
 *
 * @author Nitin_Hasija
 */

class DatabaseConnectionTest {

  /**
   * Test wrong connection.
   *
   * @throws SQLException the SQL exception
   */
  @Test
  @DisplayName("when database doesnot exist or wrong name entered")
  void testWrongConnection() throws SQLException {
    assertThrows(SQLException.class, () -> DatabaseConnection.getConnection("database_Not_Exist"));
  }

  /**
   * Test right connection.
   *
   * @throws ClassNotFoundException the class not found exception
   * @throws SQLException           the SQL exception
   */
  @Test
  @DisplayName("when correct dbname entered")
  void testRighthConnection() throws ClassNotFoundException, SQLException {
    assertNotNull(DatabaseConnection.getConnection("student_database"));
  }
}
