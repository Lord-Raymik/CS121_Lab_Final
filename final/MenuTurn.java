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
		System.out.println("1) Hiring Campaign ($" + Config.Focus.COST_HIRE + ")");
		System.out.println("2) Hotel Service ($" + Config.Focus.COST_SERVICE + ")");
		System.out.println("3) Marketing ($" + Config.Focus.COST_REPUTATION + ")");
		System.out.println("");
		System.out.println("4) Hotel Expansion ($" + (Config.Focus.COST_EXPAND_BASE + (hotel.getRooms() - Config.Default.ROOMS) * Config.Focus.COST_EXPAND_SCALING) + ")\n          - large undertaking\n          - takes multiple months");
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
				hotel.setBalance(hotel.getBalance() - Config.Focus.COST_SERVICE);
				hotel.setService(hotel.getService() + Config.Focus.FOCUS_SERVICE);
			} else if (choice == 3) {
				keepGoing = false;
				hotel.setBalance(hotel.getBalance() - Config.Focus.COST_REPUTATION);
				hotel.setReputation(hotel.getReputation() + Config.Focus.FOCUS_REPUTATION);
			} else if (choice == 4) {
				if (hotel.getUnderConstruction() == false) {
					keepGoing = false;
					hotel.setBalance(hotel.getBalance() - (Config.Focus.COST_EXPAND_BASE + ((hotel.getRooms() - Config.Default.ROOMS) * Config.Focus.COST_EXPAND_SCALING)));
					hotel.expandRooms(Config.Focus.FOCUS_EXPAND, 5);
				} // end if
			} // end else if
		} // end while loop
		hotel.update();
		hotel.openMenu(new MenuReport(hotel));
		hotel.setTurn(hotel.getTurn() + 1);
	} // end start
	
} // end class def
