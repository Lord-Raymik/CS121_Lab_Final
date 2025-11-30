/*
 * this is the menu which allows the user the change the pay of or fire staff
 */

public class MenuStaff extends MenuBase {

	public MenuStaff (Hotel hotel) {
		super(hotel, "Manage Staff", "-");
	} // end constructor
	
	public void menu() {
		printHeader();
		System.out.println("0) Exit\n1) Fire Staff\n2) Set Salary");
	} // end menu
	
	public void start() {
		boolean keepGoing = true;
		while (keepGoing) {
			menu();
			int choice = getInt("Please Choose 0-2", 0, 2);
			if (choice == 0) {
				keepGoing = false;
			} else if (choice == 1) {
				int fireNum = getInt("How many", 0, hotel.getStaff());
				hotel.setStaff(hotel.getStaff() - fireNum);
				System.out.println("New Staff: " + hotel.getStaff());
			} else if (choice == 2) {
				System.out.println("Old Salary: $" + hotel.getStaffPay());
				int newPay = getInt("New Amount");
				hotel.setStaffPay(newPay);
				System.out.println("New Salary: $" + hotel.getStaffPay());
			} // end else if
		} // end while loop
	} // end start
	
} // end class def
