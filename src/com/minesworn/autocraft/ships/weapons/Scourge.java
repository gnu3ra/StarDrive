package com.minesworn.autocraft.ships.weapons;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.TNTPrimed;

import com.minesworn.autocraft.Config;

public class Scourge extends Projectile {

	Block pulse;
	
	public Scourge(Block dispenser) {
		super(200L);
				
		pulse = dispenser.getRelative(0, -1, 0);
		pulse.setType(Material.WOOL);
		pulse.setData((byte) 14);
	}

	public void explode() {
		this.exploded = true;
		TNTPrimed tnt = pulse.getWorld().spawn(pulse.getLocation(), TNTPrimed.class);
		tnt.setYield(250.0f);
		tnt.setFuseTicks(0);
		pulse.setType(Material.AIR);
		burn();
	}
	
	public void burn() {
		for (int i = -Config.SCOURGE_BURN_RADIUS; i <= Config.SCOURGE_BURN_RADIUS; i++) {
			for (int j = -Config.SCOURGE_BURN_RADIUS; j <= Config.SCOURGE_BURN_RADIUS; j++) {
				for (int k = -Config.SCOURGE_BURN_RADIUS; k <= Config.SCOURGE_BURN_RADIUS; k++) {
					Block b = pulse.getRelative(i, j, k);
					if (b.getType().equals(Material.AIR) && !b.getRelative(0, -1, 0).getType().equals(Material.AIR))
						b.setType(Material.FIRE);
				}
			}
		}
	}
	
	@Override
	public void move() {
		if (!isExploded()) {
			Block b = pulse.getRelative(0, -1, 0);
			if (b.getType().equals(Material.AIR) ||
				b.getType().equals(Material.WATER) ||
				b.getType().equals(Material.STATIONARY_WATER) ||
				b.getType().equals(Material.LAVA) ||
				b.getType().equals(Material.STATIONARY_LAVA) ||
				b.getType().equals(Material.FIRE) ||
				b.getType().equals(Material.LADDER) ||
				b.getType().equals(Material.IRON_DOOR_BLOCK) ||
				b.getType().equals(Material.ENCHANTMENT_TABLE) ||
				b.getType().equals(Material.PORTAL) ||
				b.getType().equals(Material.ENDER_PORTAL) ||
				b.getType().equals(Material.ENDER_STONE) ||
				b.getType().equals(Material.ENDER_PORTAL_FRAME)) {
				b.setType(Material.WOOL);
				pulse.setType(Material.AIR);
				b.setData((byte) 13);
				pulse = b;
			} else {
				b.setType(Material.AIR);
				this.exploded = true;
				explode();
			}
		}
	}
	
}
