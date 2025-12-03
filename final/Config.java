/*
 * this class is purely a config file.
 * it will having nothing other than final static values, serving as constants for game balance.
 * this will make it easier to tweak certain things about the game during testing.
 */

public class Config {

	/*
	 * default values for a new Hotel
	 */
	public static class Default {
		public static final int BALANCE = 1500;
		public static final int ROOMS = 20;
		public static final int STAFF = 3;
		public static final int STAFF_SATISFACTION = 50;
		public static final int STAFF_PAY = 100;
		public static final int SERVICE = 10;
		public static final int REPUTATION = 10;
	} // end Default def
	
	/*
	 * minimum and maximum values for applicable hotel variables
	 */
	public static class Range {
		public static final int SERVICE_MIN = 0;
		public static final int SERVICE_MAX = 100;
		public static final int REPUTATION_MIN = 0;
		public static final int REPUTATION_MAX = 100;
		public static final int STAFF_SATISFACTION_MIN = 0;
		public static final int STAFF_SATISFACTION_MAX = 100;
	} // end Range def
	
	/*
	 * values relating to game balance
	 */
	public static class Balance {
		public static final int ROOMS_PER_STAFF = 10;
		public static final int ROOM_COST = 10;
		public static final int ROOM_INCOME = 20;
	} // end Balance def
	
} // end class def
