package net.ballmerlabs.stardrive.commands;

import org.bukkit.Bukkit;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

public class CmdWarp extends ACCommand {

	public CmdWarp() {
		this.name = "warp";
		this.aliases.add("w");
		this.description = "Teleports extreme distances";
		this.permission = Permission.CMD_WARP.node;
		this.mustBePlayer = true;
	}
	
	
	
	public void perform() {
		if(Bukkit.getWorld(args[3]) == null)
			args[3] = player.getWorld().getName();
		
		try {
			if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
				Autocraft.shipmanager.ships.get(player.getName()).warp(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Bukkit.getWorld(args[3]));
			}
		}
		catch(Exception e) {
			errorMessage("Coordinate format mismatch. Check your syntax");
		}
	}

}
