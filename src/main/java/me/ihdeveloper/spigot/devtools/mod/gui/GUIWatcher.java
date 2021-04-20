package me.ihdeveloper.spigot.devtools.mod.gui;

import me.ihdeveloper.spigot.devtools.mod.GUIOverlay;
import me.ihdeveloper.spigot.devtools.mod.tool.Watcher;
import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;

import java.util.Map;

public class GUIWatcher extends GUIOverlay {

    private final Watcher watcher;

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
        beforeDrawScreen();

        drawTitle("§eWatcher");
        drawTable();
        drawBox("§e§lKey", "§e§lValue", true);

        if (watcher == null) {
            return;
        }

        tableY += 10;
        for (Map.Entry<String, String> entry : watcher.entrySet()) {
            drawBox("§e" + entry.getKey(), entry.getValue(), false);
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

    private void drawBox(String key, String value, boolean noBox) {
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
