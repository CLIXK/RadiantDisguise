package me.clixk.radiantdisguise.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisguiseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
        if (paramCommandSender instanceof Player) {
            Player paramPlayer = (Player) paramCommandSender;
            if (paramPlayer.hasPermission("radiantdisguise.use")) {
                if (paramCommand.getName().equalsIgnoreCase("radiantprison")) {
                    paramCommandSender.sendMessage("works!");
                }
            }
        }
        return false;
    }
}
