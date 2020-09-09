package me.clixk.radiantdisguise.config;

import lombok.Getter;
import lombok.Setter;
import me.clixk.radiantdisguise.RadiantDisguise;
import me.clixk.radiantdisguise.utils.MessageUtils;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

@Getter @Setter
public class FileManager {

	/* File */
	private File file;
	/* Strings */
	private String name, directory;
	/* Configuration */
	private YamlConfiguration configuration;
	/* Plugin */
	private RadiantDisguise plugin;


	/**
	 * Bukkit Configuration Class
	 *
	 * @param plugin The class of the main class of plugin or extension
	 * @param name - Is the identifier for the configuration file and object.
	 */
	public FileManager(RadiantDisguise plugin, String name) {
		this.name = name;
		this.plugin = plugin;
		if (!new File(plugin.getDataFolder(), name + ".yml").exists()) {
			plugin.saveResource(name + ".yml", false);
		}
		try {
			this.file = new File(plugin.getDataFolder(), name + ".yml");
			this.configuration = YamlConfiguration.loadConfiguration(file);
		} catch (Exception exception) {
			plugin.getLogger().log(Level.SEVERE, MessageUtils.colorize("&cFailed to load " + file.getName() + "&c!"));
			exception.printStackTrace();
		}
	}

	/**
	 * Bukkit Configuration Class
	 *
	 * @param plugin The class of the main class of plugin or extension
	 * @param name - Is the identifier for the configuration file and object.
	 */
	public FileManager(RadiantDisguise plugin, String directory, String name) {
		this.name = name;
		this.directory = directory;
		this.plugin = plugin;
		if (!new File(plugin.getDataFolder() + File.separator + this.directory, name + ".yml").exists()) {
			plugin.saveResource(name + ".yml", false);
		}
		try {
			this.file = new File(plugin.getDataFolder() + File.separator + this.directory, name + ".yml");
			this.configuration = YamlConfiguration.loadConfiguration(file);
		} catch (Exception exception) {
			plugin.getLogger().log(Level.SEVERE, MessageUtils.colorize("&cFailed to load " + file.getName() + "&c!"));
			exception.printStackTrace();
		}
	}



	public void reload() {
		try {
			this.configuration.load(this.file);
		} catch (IOException | InvalidConfigurationException exception) {
			exception.printStackTrace();
			plugin.getLogger().log(Level.SEVERE, MessageUtils.colorize("&cFailed to reload " + file.getName() + "&c!"));
		}
	}

	public void save() {
		try {
			this.configuration.save(this.file);
		} catch (IOException exception) {
			exception.printStackTrace();
			plugin.getLogger().log(Level.SEVERE, MessageUtils.colorize("&cFailed to save " + file.getName() + "&c!"));
		}
	}

}

