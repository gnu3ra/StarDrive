package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

public class CmdScourgeTorpedo extends ACCommand {

	public CmdScourgeTorpedo() {
		this.name = "sTorpedo";
		this.aliases.add("sm");
		this.description = "Fire a light nuclear torpedo from your ship";
		this.permission = Permission.CMD_SCOURGE_TORPEDO.node;
		this.mustBePlayer = true;
	}
	
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.get(player.getName()).fireScourgeTorpedo(); //TODO: change this
		}		
	}

}