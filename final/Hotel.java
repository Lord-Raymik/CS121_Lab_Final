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

	// other variables (often consistently altered every turn)
	private int occupancy;

	// the control variable determining if the game will continue
	private boolean continueGame;

	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.start();
	} // end main def

	public Hotel() {
		turn = 0;
		balance = Config.START_BALANCE;
		rooms = Config.START_ROOMS;
		staff = Config.START_STAFF;
		staffSatisfaction = Config.START_STAFF_SATISFACTION;
		staffPay = Config.START_STAFF_PAY;
		service = Config.START_SERVICE;
		reputation = Config.START_REPUTATION;
	} // end constructor
	
	public void decay() {
		staffSatisfaction -= Config.DECAY_STAFF_SATISFACTION;
		service -= Config.DECAY_SERVICE;
		reputation -= Config.DECAY_REPUTATION;
		boolean quit = staffQuit();
		if (true) {
			staff--;
		} // end if

		// TO BE IRONED OUT FURTHER LATER (ALSO STAFF QUITTING WILL BE A METHOD THATS CALLED HERE)

	} // end decay
	
	private boolean staffQuit() {
		int rand = (int)Math.random() * 100;
		if (rand + staffSatisfaction < Config.DECAY_QUIT_CHANCE) {
			staff--;
			return true;
		} else {
			return false;
		} // end else if
	} // end staffQuit
	
	public void update() {
		occupancy = (int)(Math.random());
		int effectiveRooms = (int)Math.min(rooms, (staff*Config.ROOMS_PER_STAFF));
		if (occupancy > effectiveRooms) {
			occupancy = effectiveRooms;
		} // end if
		balance += (int)occupancy * (Config.ROOM_INCOME + (service));
		reputation += (int)service;
		staffSatisfaction += (effectiveRooms - rooms);
		service += (int)staff;
	} // end update
	
	public void costs() {
		balance -= rooms * Config.ROOM_COST;
		balance -= staff * staffPay;

		// wip

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
		staffSatisfaction = input;
	} // end setStaffSatisfaction

	public void setStaffPay(int input) {
		staffPay = input;
		if (staffPay < 0) {
			staffPay = 0;
		} // end if
	} // end setStaffPay
	
	public void setService(int input) {
		service = input;
	} // end setService
	
	public void setReputation(int input) {
		reputation = input;
	} // end setReputation

} // end class def
