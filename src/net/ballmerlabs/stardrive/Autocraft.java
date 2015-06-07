package net.ballmerlabs.stardrive;
//experimental
import net.ballmerlabs.stardrive.commands.ACCommandRoot;
import net.ballmerlabs.stardrive.core.SPlugin;
import net.ballmerlabs.stardrive.core.commands.CmdHelp;
import net.ballmerlabs.stardrive.core.util.SLang;
import net.ballmerlabs.stardrive.listeners.PlayerListener;
import net.ballmerlabs.stardrive.ships.ACPropertiesManager;
import net.ballmerlabs.stardrive.ships.ACShipManager;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Autocraft extends SPlugin {

	public static Autocraft p;
	public static ACPropertiesManager propertiesmanager;
	public static ACShipManager shipmanager;
	
	@Override
	public void onEnable() {
		Autocraft.p = this;
		preEnable();
		
		lang = new SLang(this);
		lang.load();
		Config.load();
		shipmanager = new ACShipManager();
		propertiesmanager = new ACPropertiesManager(p);
		commandRoot = new ACCommandRoot(p);

		registerEvents();
	}
	
	@Override
	public void onDisable() {
		preDisable();
	}
	
	@Override
	public void newHelpCommand(CommandSender sender, String[] args) {
		 new CmdHelp<Autocraft>().execute(sender, args);
	}
	
	public void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(p), p);
	}
	
}
