package me.ihdeveloper.spigot.devtools.mod.utils;

import me.ihdeveloper.spigot.devtools.mod.Main;
import net.minecraft.client.Minecraft;

public class DrawUtils {

    public static void drawStatus(String text) {
        int height = Main.getInstance().getScaledResolution().getScaledHeight();
        int width = Main.getInstance().getScaledResolution().getScaledWidth();
        int color = Main.getInstance().getStatusColor().getRGB();
        drawCenteredText(text, (width * 2f) - 100f, height - 20f, color);
    }

    public static void drawCenteredText(String text, float x, float y, int color) {
        int textWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(text);

        Minecraft.getMinecraft().fontRendererObj.drawString(text, (x - textWidth) / 2f, y, color, false);
    }

}
