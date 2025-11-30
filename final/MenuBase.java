/*
 * this is an abstract class representing qualities that all menus have.
 * it's subclasses make up the various menus of the game.
 */

import java.util.*;

public abstract class MenuBase implements HasMenu {
	
	protected Hotel hotel;

	protected String title;

	protected String bar;

	public MenuBase(Hotel hotel, String title, String bar) {
		this.hotel = hotel;
		this.title = title;
		this.bar = bar;
	} // end constructor
	
	public void printHeader() {
		String header = bar.repeat(10);
		System.out.println("\n" + header + " " + title + " " + header + "\n");
	} // end printHeader
	
	public String getString(String prompt) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		while(input.equals("")) {
			System.out.print(prompt + ": ");
			input = scan.nextLine();
		} // end while loop
		return input;
	} // end getString
	
	public int getInt(String prompt) {
		Scanner scan = new Scanner(System.in);
		int input = -999;
		boolean valid = false;
		while (valid == false) {
			System.out.print(prompt + ": ");
			try {
				input = scan.nextInt();
				scan.nextLine();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input...");
				scan.nextLine();
			} // end try-catch
		} // end while loop
		return input;
	} // end getInt
	
	public int getInt(String prompt, int min, int max) {
		int input = -999;
		boolean valid = false;
		while (valid == false) {
			input = getInt(prompt);
			if (input >= min && input <= max) {
				valid = true;
			} else {
				System.out.println("Invalid input... Out of range (" + min + "-" + max + ")");
			} // end elseif
		} // end while loop
		return input;
	} // end getInt (different signature)
	
	public void menu() {
		// abstract
	} // end menu

	public void start() {
		// abstract
	} // end start
} // end class def
