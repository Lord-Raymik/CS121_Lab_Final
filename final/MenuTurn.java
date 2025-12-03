/*
 * this is the menu that processes a user's decisions for each turn
 */

public class MenuTurn extends MenuBase {

	private boolean didQuit;

	public MenuTurn (Hotel hotel) {
		super(hotel, hotel.getDate(), "~");
		didQuit = false;
	} // end constructor
	
	public void menu() {
		printHeader();
		if (didQuit) {
			System.out.println("A staff member quit this month...\n");
		} // end if
		System.out.println("Current Balance: $" + hotel.getBalance() + "\n");
		System.out.println("What will you focus on this month?\n");
		System.out.println("0) Nothing");
		System.out.println("1) Hiring Campaign ($250)");
		System.out.println("2) Hotel Service ($400)");
		System.out.println("3) Marketing ($700)");
		System.out.println("");
		System.out.println("4) Hotel Expansion ($" + (hotel.getRooms() * 150) + ")\n          - large undertaking\n          - takes multiple months");
	} // end menu
	
	public void start() {
		// calculating the decay to the hotel
		hotel.decay();
		didQuit = hotel.staffQuit();

		// the menu whihc the user interacts with
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
					hotel.setBalance(hotel.getBalance() - 250);
					hotel.setStaff(hotel.getStaff() + hireNum);
					System.out.println("\nNew staff number: " + hotel.getStaff() + "\n");
				} // end if
			} else if (choice == 2) {
				keepGoing = false;
				hotel.setBalance(hotel.getBalance() - 400);
				hotel.setService(hotel.getService() + 6);
			} else if (choice == 3) {
				keepGoing = false;
				hotel.setBalance(hotel.getBalance() - 700);
				hotel.setReputation(hotel.getReputation() + 15);
			} else if (choice == 4) {
				if (hotel.getUnderConstruction() == false) {
					keepGoing = false;
					hotel.setBalance(hotel.getBalance() - (hotel.getRooms()*150));
					hotel.expandRooms(10, 5);
				} // end if
			} // end else if
		} // end while loop
		hotel.update();
		hotel.openMenu(new MenuReport(hotel));
		hotel.setTurn(hotel.getTurn() + 1);
	} // end start
	
} // end class def
