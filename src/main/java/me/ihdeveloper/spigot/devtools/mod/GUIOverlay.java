package me.ihdeveloper.spigot.devtools.mod;

import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.Color;

public abstract class GUIOverlay extends GuiScreen {

    protected int tableX;
    protected int tableY;
    protected int tableWidth;
    protected int tableHeight;

    protected void beforeDrawScreen() {
        GlStateManager.color(1f, 1f, 1f, 1f);
        drawDefaultBackground();
    }

    protected void drawTitle(String title) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(3f, 3f, 3f);
        DrawUtils.drawCenteredText(title, width / 3F, (height / 16f) / 3f, Color.WHITE.getRGB(), true);
        GlStateManager.popMatrix();
    }

    protected void drawTable() {
        int left = 10;
        int right = width - left;
        int top = ((height / 16) * 3) + 2;
        int bottom = height - (height / 32);
        drawRect(10, top, width - 10, bottom, DrawUtils.colorFromRGBA(0f, 0f, 0f, .4f));

        this.tableX = left;
        this.tableY = top;
        this.tableWidth = right - left;
        this.tableHeight = bottom - top;
    }

}