package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

public class CmdDrop extends ACCommand {

	public CmdDrop() {
		this.name = "drop";
		this.aliases.add("d");
		this.mustBePlayer = true;
		this.permission = Permission.CMD_DROP.node;
		this.description = "Drop a bomb";
	}
	
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.get(player.getName()).drop();
		}
	}

}
