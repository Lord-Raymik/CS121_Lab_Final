/*
 * this is the primary hotel menu which the user interacts with between months/turns
 */

public class MenuHotel extends MenuBase {

	public MenuHotel(Hotel hotel) {
		super(hotel, "Hotel", "=");
	} // end constructor
	
	public void menu() {
		printHeader();
		System.out.println(hotel.getDate() + "\n");
		System.out.println("Current Balance: $" + hotel.getBalance() + "\n");
		System.out.println("0) Quit\n1) Begin Month\n2) Manage Staff\n3) Display Stats");
	} // end menu
	
	public void start() {
		boolean keepGoing = true;
		while (keepGoing) {
			menu();
			int input = getInt("Please choose 0-3", 0, 3);
			if (input == 0) {
				keepGoing = false;
				hotel.stop();
			} else if (input == 1) {
				keepGoing = false;
				hotel.openMenu(new MenuTurn(hotel));
			} else if (input == 2) {
				hotel.openMenu(new MenuStaff(hotel));
			} else if (input == 3) {
				hotel.openMenu(new MenuStats(hotel));
			} // end else if
		} // end while loop
	} // end start
} // end class def
