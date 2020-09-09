package me.clixk.radiantdisguise.utils;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;

public class MessageUtils {

	public static String colorize(final String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public static String colorize(final String... strings) {
		return MessageUtils.colorize(StringUtils.join(strings, "\n"));
	}

	//public static ItemStack makeSkull(String base64EncodedString) {
	//	final ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
	//	SkullMeta meta = (SkullMeta) skull.getItemMeta();
	//	assert meta != null;
	//	GameProfile profile = new GameProfile(UUID.randomUUID(), null);
	//	profile.getProperties().put("textures", new Property("textures", base64EncodedString));
	//	try {
	//		Field profileField = meta.getClass().getDeclaredField("profile");
	//		profileField.setAccessible(true);
	//		profileField.set(meta, profile);
	//	} catch (NoSuchFieldException | IllegalAccessException e) {
	//		e.printStackTrace();
	//	}
	//	skull.setItemMeta(meta);
	//	return skull;
	//}
}
