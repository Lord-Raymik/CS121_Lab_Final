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
		hotel.decay();
		boolean keepGoing = true;
		while (keepGoing) {
			menu();
			int choice = getInt("Please Choose 0-4", 0, 4);
			if (choice == 0) {
				keepGoing = false;
			} else if (choice == 1) {
				int hireNum = getInt("How many are you looking to hire", 0, 100);
				if (hireNum > 0) {
					keepGoing = false;
					hotel.setStaff(hotel.getStaff() + hireNum);
					System.out.println("\nNew staff number: " + hotel.getStaff() + "\n");
				} // end if
			} else if (choice == 2) {
				hotel.setService(hotel.getService() + 10);
			} else if (choice == 3) {
				hotel.setReputation(hotel.getReputation() + 10);
			} else if (choice == 4) {

				// W.I.P

			} // end else if
		} // end while loop
		hotel.update();
		hotel.costs();
		hotel.displayStats();
		hotel.setTurn(hotel.getTurn() + 1);
	} // end start
	
} // end class def
