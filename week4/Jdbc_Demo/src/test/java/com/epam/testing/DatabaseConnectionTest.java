/**
 * 
 */
package com.epam.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.epam.jdbcConnection.DatabaseConnection;

/**
 * The Class DatabaseConnectionTest.
 *
 * @author Nitin Hasija
 */
class DatabaseConnectionTest {

	/**
	 * Wrong connection test.
	 *
	 * @throws SQLException when database doesnot exist or wrong name entered
	 */
	@Test
	@DisplayName("when database doesnot exist or wrong name entered")
	void wrongConnectionTest() throws SQLException {
		assertThrows(SQLException.class, () -> DatabaseConnection.getConnection("database_Not_Exist"));
	}

	/**
	 * Rigth connection test.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException when correct dbname entered
	 */
	@Test
	@DisplayName("when correct dbname entered")
	void rigthConnectionTest() throws ClassNotFoundException, SQLException {
		assertNotNull(DatabaseConnection.getConnection("student_database"));
	}

}
