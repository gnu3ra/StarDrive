package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

public class CmdFire extends ACCommand {

	public CmdFire() {
		this.name = "fire";
		this.aliases.add("f");
		this.mustBePlayer = true;
		this.permission = Permission.CMD_FIRE.node;
		this.description = "Fire your ship's tnt cannons";
	}
	
	@Override
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.get(player.getName()).fire();
		}
	}

}
