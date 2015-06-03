package net.ballmerlabs.stardrive.ships.weapons;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.core.util.SThread;

import org.bukkit.Bukkit;

public class ProjectileUpdateThread extends SThread {
	final Projectile p;
	final long updatePeriod;
	public ProjectileUpdateThread(Projectile p, long updatePeriod) {
		super();
		this.p = p;
		this.updatePeriod = updatePeriod;
	}
	
	public void run() {
		try {
			while (!p.isExploded()) {
				Thread.sleep(updatePeriod);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Autocraft.p, new Runnable() {
					public void run() {
						p.move();
					}
				});
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
