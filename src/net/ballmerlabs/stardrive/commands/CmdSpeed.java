package net.ballmerlabs.stardrive.commands;

import net.ballmerlabs.stardrive.Autocraft;
import net.ballmerlabs.stardrive.PermissionsManager.Permission;

import org.bukkit.ChatColor;

public class CmdSpeed extends ACCommand {

	public CmdSpeed() {
		this.name = "speed";
		this.aliases.add("s");
		this.description = "Sets the current speed of your craft";
		this.permission = Permission.CMD_SPEED.node;
		this.mustBePlayer = true;
	}
	
	
	public void perform() {
			
			if (Autocraft.shipmanager.ships.containsKey(player.getName()))
			{
				try {
				if(args.length == 1)
				{
					String moveSpeeds = args[0];	
					int moveSpeed = Integer.parseInt(moveSpeeds);
				
					Autocraft.shipmanager.ships.get(player.getName()).setSpeed(moveSpeed);
				}
				else
				{
					sender.sendMessage(ChatColor.AQUA + "Drive system error. check args length");

				}
			
				}
				catch(Exception e)
				{
				sender.sendMessage(ChatColor.AQUA + "Drive system error. enter an integer");
				}
			}
			else
			{
				sender.sendMessage(ChatColor.AQUA + "You need to be piloting a ship to do this.");
			}
			
	}

}
