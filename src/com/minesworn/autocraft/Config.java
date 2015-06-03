package com.minesworn.autocraft;

import java.util.ArrayList;
import java.util.List;

import com.minesworn.autocraft.core.io.SPersist;

public class Config {
	
	public static int WEAPON_COOLDOWN_TIME = 6;
	public static int NUM_TNT_TO_FIRE_NORMAL = 4;
	public static int NUM_TNT_TO_FIRE_TORPEDO = 8;
	public static int NUM_TNT_TO_DROP_BOMB = 2;
	public static int NUM_TNT_TO_DROP_NAPALM = 4;
	public static int NUM_TNT_TO_DROP_SCOURGE = 64;
	public static int NUM_TNT_TO_FIRE_SCOURGE_TORPEDO = 16;

	public static List<Integer> MATERIALS_NEEDED_FOR_TORPEDO = new ArrayList<Integer>();
	public static List<Integer> MATERIALS_NEEDED_FOR_NAPALM = new ArrayList<Integer>();
	public static List<Integer> MATERIALS_NEEDED_FOR_SCOURGE = new ArrayList<Integer>();
	public static List<Integer> MATERIALS_NEEDED_FOR_SCOURGE_TORPEDO = new ArrayList<Integer>();


	
	
	public static int NAPALM_BURN_RADIUS = 6;
	public static int SCOURGE_BURN_RADIUS = 30;
	
	public static boolean SHIPS_CAN_FLY = true;
		
	static {
		Config.MATERIALS_NEEDED_FOR_TORPEDO.add(57);
		Config.MATERIALS_NEEDED_FOR_TORPEDO.add(42);
		Config.MATERIALS_NEEDED_FOR_NAPALM.add(341);
		Config.MATERIALS_NEEDED_FOR_NAPALM.add(327);
		Config.MATERIALS_NEEDED_FOR_NAPALM.add(57);
		Config.MATERIALS_NEEDED_FOR_SCOURGE.add(20);
		Config.MATERIALS_NEEDED_FOR_SCOURGE.add(49);
		Config.MATERIALS_NEEDED_FOR_SCOURGE.add(399);
		Config.MATERIALS_NEEDED_FOR_SCOURGE_TORPEDO.add(399);
	}
	
	public static void load() {
		SPersist.load(Autocraft.p, Config.class);
	}
	
}
