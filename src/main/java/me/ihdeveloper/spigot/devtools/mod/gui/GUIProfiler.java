package me.ihdeveloper.spigot.devtools.mod.gui;

import me.ihdeveloper.spigot.devtools.mod.GUIOverlay;
import me.ihdeveloper.spigot.devtools.mod.Profiler;
import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;

import java.util.ArrayList;
import java.util.List;

public class GUIProfiler extends GUIOverlay {

    private Profiler profiler;
    private List<Profiler.Item> updatedItems = new ArrayList<>();
    private List<Profiler.Item> oldItems = new ArrayList<>();

    public GUIProfiler(Profiler profiler) {
        this.profiler = profiler;
    }

    @Override
    public void updateScreen() {
        updatedItems.clear();
        oldItems.clear();

        for (Profiler.Item item : profiler.all()) {
            if (item.isUpdated()) {
                updatedItems.add(item);
            } else {
                oldItems.add(item);
            }
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        beforeDrawScreen();
        drawTitle("§6Profiler");
        drawTable();

        drawItems();
    }

    private void drawItems() {
        int x = this.tableX + 20;
        int y = this.tableY + 20;

        int defaultColor = DrawUtils.colorFromRGBA(1f, 1f, 1f, 1f);
        for (Profiler.Item item : updatedItems) {
            drawString(mc.fontRendererObj, "[0] " + item.getName(), x, y, defaultColor);
            drawString(mc.fontRendererObj, Math.round(item.getPercent()) + "%", x + 120, y, defaultColor);
            drawString(mc.fontRendererObj, "§e" + item.getTicks() + " §6ticks", x + 200, y, defaultColor);
            y += 10;
        }

        for (Profiler.Item item : oldItems) {
            drawString(mc.fontRendererObj, "§7§o[#] " + item.getName(), x, y, defaultColor);
            drawString(mc.fontRendererObj, "§7§o" + item.getTicks() + " ticks", x + 120, y, defaultColor);
        }
    }

}
