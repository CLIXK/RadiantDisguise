package me.clixk.radiantdisguise.listerners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListerners implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onChat(AsyncPlayerChatEvent paramAsyncPlayerChatEvent) {

    }
}
