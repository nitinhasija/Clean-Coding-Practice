/**
 * class to perform operations on select query
 */

package com.epam.query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epam.connection.DatabaseConnection;

/**
 * The Class SelectQuery.
 *
 * @author Nitin_Hasija
 */
public class SelectQuery {

  /** The rs. */
  private ResultSet rs;

  /** The stmt. */
  private Statement stmt;

  /** The con. */
  private Connection con;

  /** The names. */
  private List<String> names;

  /**
   * Instantiates a new select query.
   *
   * @param databaseName the database name
   * @param query        the query
   * @throws ClassNotFoundException the class not found exception
   * @throws SQLException           the SQL exception
   */
  public SelectQuery(String databaseName, String query) throws ClassNotFoundException, SQLException {
    con = DatabaseConnection.getConnection(databaseName);
    stmt = con.createStatement();
    rs = stmt.executeQuery(query);
  }

  /**
   * Gets the forward list of names.
   *
   * @return array list of names in forward fashion
   * @throws SQLException the SQL exception
   */
  public List<String> getForwardListOfNames() throws SQLException {
    names = new ArrayList<>();
    while (rs.next()) {
      names.add(rs.getString("name"));
    }
    return names;
  }

  /**
   * Gets the backward list of names.
   *
   * @return array list of names in backward fashion
   * @throws SQLException the SQL exception
   */
  public List<String> getBackwardListOfNames() throws SQLException {
    names = new ArrayList<>();
    rs.afterLast();

    while (rs.previous()) {
      names.add(rs.getString("name"));
    }

    return names;
  }
}
