package net.ballmerlabs.stardrive.core.io;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.ballmerlabs.stardrive.core.SPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class SPersist {
	
	/*
	 * this saves data to config files
	 */

	public static <T> void save(SPlugin p, T instance, Class<? extends T> clazz) {
		save(p, instance, clazz, clazz.getSimpleName().toLowerCase());
	}
	
	public static <T> void save(SPlugin p, Class<? extends T> clazz) {
		save(p, null, clazz);
	}
	
	public static <T> void save(SPlugin p, T instance, Class<? extends T> clazz, String fName) {
		save(p, instance, clazz, new File(p.getDataFolder(), fName));
	}
	
	public static <T> void save(SPlugin p, T instance, Class<? extends T> clazz, File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
				
			FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
				
			for (Field f : clazz.getDeclaredFields()) {
				if (!Modifier.isTransient(f.getModifiers())) {
					f.setAccessible(true);
					fc.set(f.getName(), f.get(instance));
				}
			}
			
			fc.save(file);
		} catch (Exception e) {
			p.log("Exception ocurred while attempting to save file: " + file.getName());
			e.printStackTrace();
		}
	}
	
	public static <T> void load(SPlugin p, T instance, Class<? extends T> clazz) {
		load(p, instance, clazz, clazz.getSimpleName().toLowerCase());
	}
	
	public static <T> void load(SPlugin p, Class<? extends T> clazz) {
		load(p, null, clazz);
	}
	
	public static <T> void load(SPlugin p, T instance, Class<? extends T> clazz, String fName) {
		load(p, instance, clazz, new File(p.getDataFolder(), fName));
	}
	
	public static <T> void load(SPlugin p, T instance, Class<? extends T> clazz, File file) {
		try {
			if (!file.exists()) {
				save(p, instance, clazz, file);
			}
			
			FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
			
			for (Field f : clazz.getDeclaredFields()) {
				if (!Modifier.isTransient(f.getModifiers())) {
					//I think that this if statement fills out missing lines in
					//file with defaults
					if (fc.get(f.getName()) == null) {
						addDefaults(p, f, fc, instance);
					}
					f.setAccessible(true);
					f.set(instance, fc.get(f.getName()));
				}
			}
			
			fc.save(file);
		} catch (Exception e) {
			p.log("Exception ocurred while attempting to load file: " + file.getName());
			e.printStackTrace();
		}
	}
	
	public static Object readLine(SPlugin p, File file, String f) {
		try {			
			FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
			return fc.get(f);
		} catch (Exception e) {
			p.log("Exception ocurred while attempting to read: " + file.getName());
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> void loadDefaultsFromInstance(T instance, T defaults) {
		for (Field f : instance.getClass().getDeclaredFields()) {
			if (!Modifier.isTransient(f.getModifiers())) {
				f.setAccessible(true);
				try {
					f.set(instance, f.get(defaults));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static <T> void addDefaults(SPlugin p, Field f, FileConfiguration fc, T instance) {
		try {
			f.setAccessible(true);
			fc.set(f.getName(), f.get(instance));
		} catch (Exception e) {
			p.log("Exception ocurred while attempting to add defaults to file.");
			e.printStackTrace();
		}
	}
	
}
