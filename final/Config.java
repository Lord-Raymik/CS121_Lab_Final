/*
 * this class is purely a config file.
 * it will having nothing other than final static values, serving as constants for game balance.
 * this will make it easier to tweak certain things about the game during testing.
 */

public class Config {
	
	// the default values the game starts at
	public static final int START_BALANCE = 1000;
	public static final int START_ROOMS = 20;
	public static final int START_STAFF = 1;
	public static final int START_STAFF_SATISFACTION = 1;
	public static final int START_STAFF_PAY = 1;
	public static final int START_SERVICE = 1;
	public static final int START_REPUTATION = 1;

	// balance constants
	public static final int ROOMS_PER_STAFF = 20;
	public static final int ROOM_COST = 10;
	public static final int ROOM_INCOME = 20;
		// W.I.P

	// default decay values
	public static final int DECAY_STAFF_SATISFACTION = 1;
	public static final int DECAY_REPUTATION = 1;
	public static final int DECAY_SERVICE = 1;
	public static final int DECAY_QUIT_CHANCE = 1;

	// decay multipliers
	public static final double DECAY_MULT_UNDERSTAFF = 1.0;

	// growth/influence multipliers
	public static final double GROWTH_MULT_OVERSTAFF = 1.0;

} // end class def
