package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

public class CmdNapalm extends ACCommand {

	public CmdNapalm() {
		this.name = "napalm";
		this.aliases.add("n");
		this.description = "Drop napalm from your ship's cannons";
		this.permission = Permission.CMD_NAPALM.node;
		this.mustBePlayer = true;
	}
	
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.get(player.getName()).dropNapalm();
		}
	}

}
