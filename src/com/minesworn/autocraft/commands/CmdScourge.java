package com.minesworn.autocraft.commands;

import com.minesworn.autocraft.Autocraft;
import com.minesworn.autocraft.PermissionsManager.Permission;

public class CmdScourge extends ACCommand {

	public CmdScourge() {
		this.name = "Scourge";
		this.aliases.add("scourge");
		this.description = "Fires Purification Pulse";
		this.permission = Permission.CMD_SCOURGE.node;
		this.mustBePlayer = true;
	}
	
	@Override
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.get(player.getName()).fireScourge();
		}
	}

}
