package me.ihdeveloper.spigot.devtools.mod.gui;

import me.ihdeveloper.spigot.devtools.mod.GUIOverlay;
import me.ihdeveloper.spigot.devtools.mod.tool.ServerWall;
import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;

import java.util.Map;

public class GUIServerWall extends GUIOverlay {

    private final ServerWall wall;

    public GUIServerWall(ServerWall wall) {
        super();
        this.wall = wall;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        beforeDrawScreen();

        drawTitle("§eServer Wall");
        drawDescription("§7Global Information about the server");
        drawTable();
        drawBox("§e§lName", "§e§lValue", true);

        if (wall == null) {
            return;
        }

        tableY += 10;
        for (Map.Entry<String, String> entry : wall.all()) {
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
