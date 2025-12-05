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
		public static final int BALANCE = 5000;
		public static final int ROOMS = 20;
		public static final int STAFF = 3;
		public static final int STAFF_SATISFACTION = 100;
		public static final int STAFF_PAY = 100;
		public static final int SERVICE = 50;
		public static final int REPUTATION = 50;
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
		public static final int ROOM_INCOME_BASE = 20;
		public static final double ROOM_INCOME_SERVICE_SCALING = 0.3;
		public static final double REPUTATION_TARGET_SCALING = 0.9;
		public static final double STAFF_SATISFACTION_TARGET_SCALING = 1.0;
		public static final double STAFF_PAY_BASE = 100;
		public static final double STAFF_PAY_MULT = 1.0;
	} // end Balance def
	
	/*
	 * values relating to the decay of hotel values
	 */
	public static class Decay {
		public static final int SERVICE_NATURAL_DECAY = 1;
		public static final double SERVICE_DECAY_SCALING = 0.1;
		public static final double SERVICE_DECAY_EXPONENT = 1.0;
		public static final int REPUTATION_NATURAL_DECAY = 1;
		public static final double REPUTATION_DECAY_SCALING = 0.33;
		public static final int STAFF_SATISFACTION_NATURAL_DECAY = 1;
		public static final double STAFF_SATISFACTION_DECAY_SCALING = 0.25;
		public static final double STAFF_SATISFACTION_DECAY_EXPONENT = 1.5;
	} // end Decay def
	
	/*
	 * values relating to the growth og hotel values
	 */
	public static class Growth {
		public static final double SERVICE_GROWTH_SCALING = 0.03;
		public static final double REPUTATION_GROWTH_SCALING = 0.03;
		public static final double STAFF_SATISFACTION_GROWTH_SCALING = 1.5;
	} // end Growth def
	
	/*
	 * the values relating to monthly focuses
	 */
	public static class Focus {
		public static final int FOCUS_SERVICE = 5;
		public static final int FOCUS_REPUTATION = 10;
		public static final int FOCUS_EXPAND = 10;
		public static final int COST_HIRE = 250;
		public static final int COST_SERVICE = 400;
		public static final int COST_REPUTATION = 700;
		public static final int COST_EXPAND_BASE = 3000;
		public static final int COST_EXPAND_SCALING = 150;
	} // end Focus def
	
} // end class def
