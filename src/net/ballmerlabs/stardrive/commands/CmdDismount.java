package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

public class CmdDismount extends ACCommand {

	public CmdDismount() {
		this.name = "dismount";
		this.aliases.add("x");
		this.description = "Dismount your airship.";
		this.mustBePlayer = true;
		this.permission = Permission.CMD_DISMOUNT.node;
	}
	
	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			Autocraft.shipmanager.ships.remove(player.getName());
			confirmMessage("You have stopped piloting this ship.");
		}
	}

}
