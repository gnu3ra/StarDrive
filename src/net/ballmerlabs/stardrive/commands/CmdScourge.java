package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

public class CmdScourge extends ACCommand {

	public CmdScourge() {
		this.name = "Scourge";
		this.aliases.add("scourge");
		this.description = "Fires Purification Pulse";
		this.permission = Permission.CMD_SCOURGE.node;
		this.mustBePlayer = true;
	}
	
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.get(player.getName()).fireScourge();
		}
	}

}
