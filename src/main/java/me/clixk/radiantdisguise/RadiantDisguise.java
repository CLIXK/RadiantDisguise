package me.clixk.radiantdisguise;

import lombok.Getter;
import me.clixk.radiantdisguise.commands.DisguiseCommand;
import me.clixk.radiantdisguise.config.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class RadiantDisguise extends JavaPlugin {

    @Getter
    private static RadiantDisguise plugin;

    public FileManager lang;

    //@Getter
    //private static CommandManager commandManager;

    @Override
    public void onEnable() {
        try {
            // Plugin startup logic
            plugin = this;
            long l = System.currentTimeMillis();
            plugin.getLogger().log(Level.INFO, "Loading configuration files...");
            lang = new FileManager(this, "lang");
            getCommand("baltop").setExecutor(new DisguiseCommand());
		/*
        Register Events
         */
            plugin.getLogger().log(Level.INFO, "Registering Events...");
         //   Bukkit.getPluginManager().registerEvents(new InteractListener(), this);

		/*
        Load Commands
         */
            plugin.getLogger().log(Level.INFO, "Registering Commands");
        //    commandManager = new CommandManager(this);
            plugin.getLogger().log(Level.INFO, "Plugin initialized (took " + (System.currentTimeMillis() - l) + " ms)");
        } catch (Exception exception) {

            getLogger().log(Level.WARNING, "+========================================+");
            getLogger().log(Level.WARNING, "| A FATAL ERROR OCCURRED WHILE ENABLING THE PLUGIN");
            getLogger().log(Level.WARNING, "| YOUR CONFIGURATION FILES MAY BE INVALID");
            getLogger().log(Level.WARNING, "| HERE'S A DEBUG OF THE CONFIG FILE:");
            getLogger().log(Level.WARNING, "| PLEASE SEND THIS TO THE PLUGIN DEVELOPER:");
            exception.printStackTrace();
            getLogger().log(Level.WARNING, "+========================================+");
            Bukkit.getPluginManager().disablePlugin(this);

        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
