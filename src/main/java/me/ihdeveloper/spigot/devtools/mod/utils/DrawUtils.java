package me.ihdeveloper.spigot.devtools.mod.utils;

import net.minecraft.client.Minecraft;

public class DrawUtils {

    public static int colorFromRGBA(float red, float green, float blue, float alpha) {
        int result = -1;
        result = (result & ((int) (alpha * 255.0f))) << 24;
        result |= ((int) (Math.max(0.0f, red) * 255.0f)) << 16;
        result |= ((int) (Math.max(0.0f, green) * 255.0f)) << 8;
        result |= ((int) (Math.max(0.0f, blue) * 255.0f));
        return result;
    }

    public static void drawCenteredText(String text, float x, float y, int color) {
        drawCenteredText(text, x, y, color, false);
    }

    public static void drawCenteredText(String text, float x, float y, int color, boolean dropShadow) {
        int textWidth = Minecraft.getMinecraft().fontRendererObj.getStringWidth(text);
        textWidth /= 2;

        Minecraft.getMinecraft().fontRendererObj.drawString(text, (x - textWidth), y, color, dropShadow);
    }

}
