package me.ihdeveloper.spigot.devtools.mod.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public final class Debug {

    public static void info(String message) {
        print("§3INFO:", EnumChatFormatting.GRAY, message);
    }

    public static void warning(String message) {
        print("§eWARN:", EnumChatFormatting.GOLD, message);
    }

    public static void error(String message) {
        print("§cERROR:", EnumChatFormatting.DARK_RED, message);
    }

    private static void print(String prefix, EnumChatFormatting color, String message) {
        ChatComponentText component = new ChatComponentText("§7[§cSDT §6DEBUG§7] " + prefix + " ");
        component.getChatStyle().setColor(color);
        component.appendSibling(new ChatComponentText(message));
        Minecraft.getMinecraft().thePlayer.addChatMessage(component);
    }

}
