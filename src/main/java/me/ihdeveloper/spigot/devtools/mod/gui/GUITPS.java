package me.ihdeveloper.spigot.devtools.mod.gui;

import me.ihdeveloper.spigot.devtools.mod.Container;
import me.ihdeveloper.spigot.devtools.mod.GUIOverlay;
import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;

public class GUITPS extends GUIOverlay {

    private final Container container;

    public GUITPS(Container container) {
        this.container = container;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        beforeDrawScreen();

        drawTitle("§eTPS");
        drawTable();

        int x = tableWidth / 2;
        int y = tableY + 10;
        int color = DrawUtils.colorFromRGBA(0f, 0f, 0f, 1f);

        DrawUtils.drawCenteredText("§e§l1m", tableX + x, y, color);
        DrawUtils.drawCenteredText("§e§l5m", tableX + (x * 2), y, color);
        DrawUtils.drawCenteredText("§e§l15m", tableX + (x * 3), y, color);

        y += 15;

        DrawUtils.drawCenteredText(format(container.getTPS(0)), tableX + x, y, color);
        DrawUtils.drawCenteredText(format(container.getTPS(1)), tableX + (x * 2), y, color);
        DrawUtils.drawCenteredText(format(container.getTPS(2)), tableX + (x * 3), y, color);
    }

    private String format(double tps) {
        double fixedTPS = Math.min(20.0D, ((double) Math.round(tps * 100.0D)) / 100.0D);
        char prefix = tps >= 18.0D ? 'a' : (tps >= 16.0D ? 'e' : 'c');
        return "§" + prefix + (tps > 20.0D ? "*" : "") + fixedTPS;
    }
}
