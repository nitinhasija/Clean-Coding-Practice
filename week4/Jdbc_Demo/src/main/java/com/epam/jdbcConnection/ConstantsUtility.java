/**
 *  class contains constant fields used in database
 */
package com.epam.jdbcConnection;

/**
 * The Class ConstantsUtility.
 *
 * @author Nitin_Hasija
 */
public class ConstantsUtility {
	
	/** The Constant URL. */
	private final static String URL = "jdbc:mysql://localhost:3306/";
	
	/** The Constant USERNAME. */
	private final static String USERNAME = "root";
	
	/** The Constant PASSOWRD. */
	private final static String PASSOWRD = "root";

	/**
	 * Gets the url.
	 *
	 * @return url of the connection
	 */
	public final static String getURL() {
		return URL;
	}

	/**
	 * Gets the username.
	 *
	 * @return username of the database
	 */
	public final static String getUsername() {
		return USERNAME;
	}

	/**
	 * Gets the password.
	 *
	 * @return password of the database
	 */
	public final static String getPassword() {
		return PASSOWRD;
	}
}
