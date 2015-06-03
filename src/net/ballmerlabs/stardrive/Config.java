package net.ballmerlabs.stardrive;

import java.util.ArrayList;
import java.util.List;

import net.ballmerlabs.stardrive.core.io.SPersist;

public class Config {
	
	public static int WEAPON_COOLDOWN_TIME = 1;
	public static int NUM_TNT_TO_FIRE_NORMAL = 1;
	public static int NUM_TNT_TO_FIRE_TORPEDO = 1;
	public static int NUM_TNT_TO_DROP_BOMB = 1;
	public static int NUM_TNT_TO_DROP_NAPALM = 1;
	public static int NUM_TNT_TO_DROP_SCOURGE = 15;
	public static List<Integer> MATERIALS_NEEDED_FOR_TORPEDO = new ArrayList<Integer>();
	public static List<Integer> MATERIALS_NEEDED_FOR_NAPALM = new ArrayList<Integer>();
	public static List<Integer> MATERIALS_NEEDED_FOR_SCOURGE = new ArrayList<Integer>();
		
	public static int NAPALM_BURN_RADIUS = 6;
	public static int SCOURGE_BURN_RADIUS = 50;
	
	public static boolean SHIPS_CAN_FLY = true;

	static {
		Config.MATERIALS_NEEDED_FOR_TORPEDO.add(46);
		Config.MATERIALS_NEEDED_FOR_TORPEDO.add(42);
		Config.MATERIALS_NEEDED_FOR_NAPALM.add(341);
		Config.MATERIALS_NEEDED_FOR_NAPALM.add(327);
		Config.MATERIALS_NEEDED_FOR_NAPALM.add(57);
		Config.MATERIALS_NEEDED_FOR_SCOURGE.add(399);
		Config.MATERIALS_NEEDED_FOR_SCOURGE.add(57);
		Config.MATERIALS_NEEDED_FOR_SCOURGE.add(42);
	}
	
	public static void load() {
		SPersist.load(Autocraft.p, Config.class);
	}
	
}
