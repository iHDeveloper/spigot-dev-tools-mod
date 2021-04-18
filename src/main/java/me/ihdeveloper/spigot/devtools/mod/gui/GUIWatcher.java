package me.ihdeveloper.spigot.devtools.mod.gui;

import me.ihdeveloper.spigot.devtools.mod.tool.Watcher;
import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.Color;
import java.util.Map;

public class GUIWatcher extends GuiScreen {

    private final Watcher watcher;

    private int tableX;
    private int tableY;
    private int tableWidth;
    private int tableHeight;

    public GUIWatcher(Watcher watcher) {
        super();
        this.watcher = watcher;
    }

    @Override
    public void initGui() {
    }

    @Override
    public void updateScreen() {
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.color(1f, 1f, 1f, 1f);

        drawDefaultBackground();

        GlStateManager.pushMatrix();
        GlStateManager.scale(3f, 3f, 3f);
        DrawUtils.drawCenteredText("§eWatcher", width / 3F, (height / 16f) / 3f, Color.WHITE.getRGB(), true);
        GlStateManager.popMatrix();

        drawTable();
        drawBox("§e§lKey", "§e§lValue", 1, true);

        if (watcher == null) {
            return;
        }

        int index = 2;
        tableY += 10;
        for (Map.Entry<String, String> entry : watcher.entrySet()) {
            drawBox("§e" + entry.getKey(), entry.getValue(), index, false);
            index++;
            tableY += 25;
        }
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private void drawTable() {
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

    private void drawBox(String key, String value, int index, boolean noBox) {
        int left = tableX + 10;
        int right = tableWidth - 10;
        int top = tableY + 10;
        int bottom = tableY + 30;

        if (noBox) {
            top -= 10;
            bottom -= 10;
        } else {
            drawRect(left, top, right, bottom, DrawUtils.colorFromRGBA(0f, 0f, 0f, .7f));
        }

        int width = (right - left);
        int height = (bottom - top);
        drawCenteredString(mc.fontRendererObj, key, (width / 4), top + (height / 4), DrawUtils.colorFromRGBA(0f, 0f, 0f, 1f));
        drawCenteredString(mc.fontRendererObj, value, (width / 2) + (width / 4), top + (height / 4), DrawUtils.colorFromRGBA(1f, 1f, 1f, 1f));
    }
}
