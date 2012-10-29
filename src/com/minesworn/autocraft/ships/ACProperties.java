package com.minesworn.autocraft.ships;

import java.util.ArrayList;
import java.util.List;

import com.minesworn.core.io.Entity;

public class ACProperties extends Entity {
	public static final transient int MAX_ALTITUDE = 254;
	public static final transient int MAX_SHIP_SIZE = 4000;
	public int MAX_BLOCKS;
	public int MIN_BLOCKS;
	public int MAX_SHIP_DIMENSIONS;
	public int MAIN_TYPE;
	public int MOVE_SPEED;
	public boolean DROPS_NAPALM;
	public boolean DROPS_BOMB;
	public boolean FIRES_TNT;
	public boolean FIRES_TORPEDO;
	public int CANNON_LENGTH;
	public int MAX_NUMBER_OF_CANNONS;
	public int CANNON_MATERIAL;
	public List<Integer> ALLOWED_BLOCKS = new ArrayList<Integer>();
}
