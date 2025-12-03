/*
 * this is the main class around whihc the game revolves.
 * this class contains all the data for any single game, such as hotel stats, menus, events, etc.
 */

public class Hotel {

	// the main values for the game
	private int turn;
	private int balance;
	private int rooms;
	private int staff;
	private int staffSatisfaction;
	private int staffPay;
	private int service;
	private int reputation;

	//the variables for doing construction to expand room count
	private boolean underConstruction;
	private int constructionTime;
	private int expandAmount;

	// the control variable determining if the game will continue
	private boolean continueGame;

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.start();
	} // end main def
	
	public static int clampInt(int value, int min, int max) {
		if (value < min) {
			return min;
		} else if (value > max) {
			return max;
		} else {
			return value;
		} // end else if
	} // end clampInt

	public Hotel() {
		turn = 0;
		balance = Config.Default.BALANCE;
		rooms = Config.Default.ROOMS;
		staff = Config.Default.STAFF;
		staffSatisfaction = Config.Default.STAFF_SATISFACTION;
		staffPay = Config.Default.STAFF_PAY;
		service = Config.Default.SERVICE;
		reputation = Config.Default.REPUTATION;
		underConstruction = false;
		constructionTime = 0;
		expandAmount = 0;
	} // end constructor
	
	public void decay() {
		staffSatisfaction -= 1;
		service -= 1;
		if (underConstruction == true) {
			service -= 2;
		} // end if
		reputation -= 1;
	} // end decay
	
	public boolean staffQuit() {
		int rand = (int)Math.random() * 100;
		if (rand + staffSatisfaction < 50) {
			setStaff(staff - 1);
			return true;
		} else {
			return false;
		} // end else if
	} // end staffQuit
	
	public void update() {
		// calculating income based off of occupancy that month
		int occupancy = (int) (Math.random() * 10);
		int effectiveRooms = (int) Math.min(rooms, staff*20);
		occupancy = Math.min(occupancy, effectiveRooms);
		balance += (int) occupancy * (100 + (service * 3));

		// calculating the growth of service
		service += staff;

		// calculating the growth of reputation
		reputation += service;

		// calculating staffSatisfaction
		staffSatisfaction += (int) ((staff*20) - rooms)/10;

		// managing expanding the hotel
		if (underConstruction == true) {
			constructionTime--;
			if (constructionTime <= 0) {
				underConstruction = false;
				constructionTime = 0;
				rooms += expandAmount;
				expandAmount = 0;
			} // end if
		} // end if
	} // end update
	
	public void costs() {
		System.out.println("\nBefore costs: $" + balance);
		int cost = 0;
		cost += rooms * 10;
		cost += staff * staffPay;
		System.out.println("Costs: $" + cost);
		balance -= cost;
		System.out.println("Current balance: $" + balance);
	} // end costs
	
	public void displayStats() {
		System.out.println("Balance: $" + balance);
		System.out.println("Rooms: " + rooms);
		System.out.println("Staff: " + staff + ", Satisfaction: " + staffSatisfaction + ", Salary: $" + staffPay);
		System.out.println("Service: " + service);
		System.out.println("Reputation: " + reputation);
	} // end displayStats
	
	public void openMenu(MenuBase menu) {
		menu.start();
	} // end openMenu
	
	public void start() {
		continueGame = true;
		while (continueGame) {
			if (balance > 0) {
				openMenu(new MenuHotel(this));
			} else {
				stop();
			} // end else if
		} // end while loop
	} // end start
	
	public void stop() {
		continueGame = false;
	} // end stop
	
	public void expandRooms(int amount, int time) {
		underConstruction = true;
		constructionTime = time;
		expandAmount = amount;
	} // end expandRooms
	
	public String getDate() {
		return "Year " + (int)(turn/12) + ", Month " + ((turn % 12) + 1);
	} // end getDtae
	
	public int getTurn() {
		return turn;
	} // end getTurn
	
	public int getBalance() {
		return balance;
	} // end getBalance
	
	public int getRooms() {
		return rooms;
	} // end getRooms
	
	public int getStaff() {
		return staff;
	} // end getStaff
	
	public int getStaffSatisfaction() {
		return staffSatisfaction;
	} // end getStaffSatisfaction
	
	public int getStaffPay() {
		return staffPay;
	} // end getStaffPay
	
	public int getService() {
		return service;
	} // end getService
	
	public int getReputation() {
		return reputation;
	} // end getReputation
	
	public boolean getUnderConstruction() {
		return underConstruction;
	} // end getUnderConstruction
	
	public int getConstructionTime() {
		return constructionTime;
	} // end getConstructionTime
	
	public void setTurn(int input) {
		turn = input;
		if (turn < 0) {
			turn = 0;
		} // end if
	} // end setTurn
	
	public void setBalance(int input) {
		balance = input;
	} // end setBalance
	
	public void setRooms(int input) {
		rooms = input;
		if (rooms < 0) {
			rooms = 0;
		} // end if
	} // end setRooms

	public void setStaff(int input) {
		staff = input;
		if (staff < 0) {
			staff = 0;
		} // end if
	} // end setStaff
	
	public void setStaffSatisfaction(int input) {
		staffSatisfaction = clampInt(input, Config.Range.STAFF_SATISFACTION_MIN, Config.Range.STAFF_SATISFACTION_MAX);
	} // end setStaffSatisfaction

	public void setStaffPay(int input) {
		staffPay = input;
		if (staffPay < 0) {
			staffPay = 0;
		} // end if
	} // end setStaffPay
	
	public void setService(int input) {
		service = clampInt(input, Config.Range.SERVICE_MIN, Config.Range.SERVICE_MAX);
	} // end setService
	
	public void setReputation(int input) {
		reputation = clampInt(input, Config.Range.REPUTATION_MIN, Config.Range.REPUTATION_MAX);
	} // end setReputation

} // end class def
