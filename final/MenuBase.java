/*
 * this is an abstract class representing qualities that all menus have.
 * it's subclasses make up the various menus of the game.
 */

public abstract class MenuBase implements HasMenu {
	public static enum TYPE {
		HOTEL,
		STAFF,
		TURN // more to be added later
	} // end TYPES def
	
	private Hotel hotel;

	private String title;

	private TYPE type;

	public MenuBase(Hotel hotel) {
		this.hotel = hotel;
	} // end constructor
	
	public void printHeader() {
		String bar = "";
		switch (type) {
			case TYPE.HOTEL:
				bar = "==========";
			case TYPE.STAFF:
				bar = "----------";
			case TYPE.TURN:
				bar = "~~~~~~~~~~";
		} // end switch
		System.out.println(bar + " " + title + " " + bar);
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
		int input;
		boolean valid = false;
		while (valid == false) {
			System.out.print(prompt + ": ");
			try {
				input = scan.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input...");
			} // end try-catch
		} // end while loop
		return input;
	} // end getInt
	
	public int getInt(String prompt, int min, int max) {
		int input;
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
