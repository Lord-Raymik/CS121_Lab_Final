/*
 * this is the menu that processes a user's decisions for each turn
 */

public class MenuTurn extends MenuBase {

	public MenuTurn (Hotel hotel) {
		super(hotel, hotel.getDate(), "~");
	} // end constructor
	
	public void menu() {
		printHeader();
		System.out.println("What will you focus on this month?\n");
		System.out.println("0) Nothing");
		System.out.println("1) Hiring Campaign");
		System.out.println("2) Hotel Service");
		System.out.println("3) Marketing");
		System.out.println("");
		System.out.println("4) Hotel Expansion\n          - large undertaking\n          - takes multiple months");
	} // end menu
	
	public void start() {
		//hotel.decay();
		boolean keepGoing = true;
		while (keepGoing) {
			menu();
			int choice = getInt("Please Choose 0-4", 0, 4);
			if (choice == 0) {
				keepGoing = false;
			} else if (choice == 1) {

			} else if (choice == 2) {

			} else if (choice == 3) {

			} else if (choice == 4) {

			} // end else if
		} // end while loop
		hotel.setTurn(hotel.getTurn() + 1);
	} // end start
	
} // end class def
