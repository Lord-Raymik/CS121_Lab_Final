/*
 * this is the menu that display's the hotel's status at the end of the month
 */

import java.util.*;

public class MenuReport extends MenuBase {

	public MenuReport (Hotel hotel) {
		super(hotel, "Month Report", "^");
	} // end constructor
	
	public void menu() {
		printHeader();
	} // end menu
	
	public void start() {
		Scanner pause = new Scanner(System.in);
		menu();
		hotel.costs();
		System.out.print("\n\nPress ENTER to continue...");
		pause.nextLine();
	} // end start	
} // end class def
