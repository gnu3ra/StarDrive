package com.minesworn.autocraft.commands;

import com.minesworn.autocraft.Autocraft;
import com.minesworn.autocraft.PermissionsManager.Permission;

public class CmdScourgeTorpedo extends ACCommand {

	public CmdScourgeTorpedo() {
		this.name = "sTorpedo";
		this.aliases.add("sm");
		this.description = "Fire a light nuclear torpedo from your ship";
		this.permission = Permission.CMD_SCOURGE_TORPEDO.node;
		this.mustBePlayer = true;
	}
	
	@Override
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.get(player.getName()).fireScourgeTorpedo(); //TODO: change this
		}		
	}

}