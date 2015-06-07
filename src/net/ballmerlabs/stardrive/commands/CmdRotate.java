package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;
import net.ballmerlabs.stardrive.ships.TurnDirection;

public class CmdRotate extends ACCommand {

	public CmdRotate() {
		this.name = "rotate";
		this.aliases.add("r");
		this.aliases.add("turn");
		this.aliases.add("t");
		this.description = "Turns your airship left or right.";
		this.requiredArgs.add("left/right");
		this.mustBePlayer = true;
		this.permission = Permission.CMD_ROTATE.node;
	}

	public void perform() {
		if (Autocraft.shipmanager.ships.containsKey(player.getName())) {
			if (args[0].equalsIgnoreCase("left") || args[0].equalsIgnoreCase("l")) {
				Autocraft.shipmanager.ships.get(player.getName()).rotate(TurnDirection.LEFT);
			} else if (args[0].equalsIgnoreCase("right") || args[0].equalsIgnoreCase("r")) {
				Autocraft.shipmanager.ships.get(player.getName()).rotate(TurnDirection.RIGHT);
			}
		} else
			errorMessage("You need to be piloting a ship to do this");
	}
	
}
