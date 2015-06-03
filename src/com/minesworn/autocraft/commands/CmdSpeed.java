package com.minesworn.autocraft.commands;

import org.bukkit.ChatColor;

import com.minesworn.autocraft.Autocraft;
import com.minesworn.autocraft.PermissionsManager.Permission;

public class CmdSpeed extends ACCommand {

	public CmdSpeed() {
		this.name = "speed";
		this.aliases.add("s");
		this.description = "Sets the current speed of your craft";
		this.permission = Permission.CMD_SPEED.node;
		this.mustBePlayer = true;
	}
	
	@Override
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
