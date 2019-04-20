package com.epam.sumAndAverage;

import java.util.Scanner;

/**
 * Represents a class to display menu, and to take input from user
 * 
 * @author Nitin Hasija
 *
 */

public class TakeInput {

	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
	}

	/**
	 * method to return selected option from menu
	 * 
	 * @return selected option from menu
	 */
	public static int getMenu() {
		System.out.println("Choose Options from menu:");
		int option = scanner.nextInt();

		return option;
	}

	/**
	 * method to take input from the user to add it to the list
	 * 
	 * @return integer entered by the user
	 */
	public static int getNumberToAddInList() {
		int input = scanner.nextInt();
		return input;
	}
}
