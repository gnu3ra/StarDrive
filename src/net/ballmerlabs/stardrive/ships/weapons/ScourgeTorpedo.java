package net.ballmerlabs.stardrive.ships.weapons;

import net.ballmerlabs.stardrive.ships.RelativePosition;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.TNTPrimed;

public class ScourgeTorpedo extends Projectile {

	Block[] torpedo = new Block[2];
	BlockFace dir;
	
	//double gravity;
	//CHANGED: removed gravity variable and all related calculations and added
	// range safety system.
	
	private final int maxrange = 150;
	private int range;
	
	public ScourgeTorpedo(Block dispenser, BlockFace dir) {
		super(200L);
		this.dir = dir;
		
		torpedo[0] = dispenser.getRelative(dir.getModX() * 2, 0, dir.getModZ() * 2);
		torpedo[1] = dispenser.getRelative(dir.getModX(), 0, dir.getModZ());
		
		range = 0;
		
		if (torpedo[0].getType().equals(Material.AIR) && 
			torpedo[1].getType().equals(Material.AIR)) {
			torpedo[0].setType(Material.IRON_BLOCK);
			torpedo[1].setType(Material.NETHERRACK);
		} else {
			this.exploded = true;
			explode();
		}
		
	}

	@Override
	public void move() {
		if (!isExploded()) {   //this part uses the gravity var to set the y. CHANGED.
			//velocity var. this makes the torpedo drop.
			/*
			this.gravity += this.gravity / 15.0 + 0.00125;
			this.yvelo += this.gravity;
			if (this.yvelo > 20.0D)
				this.yvelo = 20.0D;
				
			 */
			//System.out.println("torpedo moved");
			//CHANGED yvelo removed. just zero now.
			if(range<=maxrange)
			{
				Block b = torpedo[0].getRelative(dir.getModX(), (int) 0, dir.getModZ());
				if (b.getType().equals(Material.AIR) || b.getType().equals(Material.WATER) || b.getType().equals(Material.STATIONARY_WATER)) {
					torpedo[0].setType(Material.NETHERRACK);
					//torpedo[0].setData((byte) 14);
					torpedo[1].setType(Material.AIR);
					torpedo[1] = torpedo[0];
					torpedo[0] = b;
					torpedo[0].setType(Material.IRON_BLOCK);
					range++;
				} else {
					if (b.getType().equals(Material.ENCHANTMENT_TABLE) || b.getType().equals(Material.ENDER_CHEST))
						b.setType(Material.AIR);
					//removes a lot of obsidian
					if(b.getType().equals(Material.OBSIDIAN))
					{
						b.setType(Material.AIR);
						for (RelativePosition dir : RelativePosition.values()) 
						{
							b.getRelative(dir.x, dir.y, dir.z).setType(Material.AIR);
						}
					}
					this.exploded = true;
					explode();
				}
			}
			else
			{
				this.exploded = true;
				explode();
			}
			
		}
	}
	
	public void explode() {
		this.exploded = true;
		torpedo[0].setType(Material.AIR);
		torpedo[1].setType(Material.AIR);
		TNTPrimed tnt = torpedo[0].getWorld().spawn(torpedo[0].getLocation(), TNTPrimed.class);
		tnt.setYield(15f);
		tnt.setFuseTicks(0);	
	}
	
}

