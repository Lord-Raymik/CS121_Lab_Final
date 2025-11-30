/*
 * this is the menu for displaying the hotel's stats
 */

public class MenuStats extends MenuBase {

	public MenuStats (Hotel hotel) {
		super(hotel, "Hotel Stats", "-");
	} // end constructor
	
	public void menu() {
		printHeader();
		hotel.displayStats();
	} // end menu
	
	public void start() {
		menu();
	} // end start
	
} // end class def
