/**
 * Makes Connection to database and return connection's instance.
 */
package com.epam.jdbcConnection;

/**
 * @author Nitin_Hasija
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class DatabaseConnection.
 */
public class DatabaseConnection {

  /**
   * Gets the connection.
   *
   * @param databaseName the database name
   * @return instance of connection
   * @throws SQLException           the SQL exception
   * @throws ClassNotFoundException the class not found exception
   */
  public static Connection getConnection(String databaseName) throws SQLException, ClassNotFoundException {
    String localhostConnection = ConstantsUtility.getURL() + databaseName;
    String username = ConstantsUtility.getUsername();
    String password = ConstantsUtility.getPassword();

    Connection connect = DriverManager.getConnection(localhostConnection, username, password);
    return connect;
  }
}
