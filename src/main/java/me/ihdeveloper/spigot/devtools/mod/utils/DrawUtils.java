package me.ihdeveloper.spigot.devtools.mod.utils;

import net.minecraft.client.Minecraft;

public class DrawUtils {

    public static int colorFromRGBA(float red, float green, float blue, float alpha) {
        int result = -1;
        result = (result & ((int) (alpha * 255.0f))) << 24;
        result |= ((int) (red * 255.0f)) << 16;
        result |= ((int) (green * 255.0f)) << 8;
        result |= ((int) (blue * 255.0f));
        return result;
    }

    public static void drawCenteredText(String text, float x, float y, int color) {
        drawCenteredText(text, x, y, color, false);
    }

    public static void drawCenteredText(String text, float x, float y, int color, boolean dropShadow) {
        int textWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(text);

        Minecraft.getMinecraft().fontRendererObj.drawString(text, (x - textWidth) / 2f, y, color, dropShadow);
    }

}
