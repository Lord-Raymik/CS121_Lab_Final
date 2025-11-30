/*
 * this class is purely a config file.
 * it will having nothing other than final static values, serving as constants for game balance.
 * this will make it easier to tweak certain things about the game during testing.
 */

public class Config {
	
	// the default values the game starts at
	public static final int START_BALANCE = 1;
	public static final int START_ROOMS = 1;
	public static final int START_STAFF = 1;
	public static final int START_STAFF_SATISFACTION = 1;
	public static final int START_STAFF_PAY = 1;
	public static final int START_SERVICE = 1;
	public static final int START_REPUTATION = 1;
	
	// scaling values which influence how decay/growth works in the game
	public static final int DECAY_STAFF_SATISFACTION = 1;
	public static final int DECAY_SERVICE = 1;
	public static final int DECAY_REPUTATION = 1;
	public static final int DECAY_QUIT_CHANCE = 1;

	public static final int GROWTH_OCCUPANCY = 1;
	public static final int GROWTH_REPUTATION = 1;
	public static final int GROWTH_SERVICE = 1;
	public static final int GROWTH_STAFF_SATISFACTION = 1;
	
	// various other multipliers
	public static final int ROOMS_PER_STAFF = 1;
	public static final int BASE_ROOM_INCOME = 1;
	
	// constants for monthly costs
	public static final int COST_ROOM = 1;

} // end class def
