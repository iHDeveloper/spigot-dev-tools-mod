package me.ihdeveloper.spigot.devtools.mod.utils;

import net.minecraft.client.Minecraft;

public class DrawUtils {

    public static void drawCenteredText(String text, float x, float y, int color) {
        int textWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(text);

        Minecraft.getMinecraft().fontRendererObj.drawString(text, (x - textWidth) / 2f, y, color, false);
    }

}
