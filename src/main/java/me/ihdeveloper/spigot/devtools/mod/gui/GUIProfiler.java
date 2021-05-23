package me.ihdeveloper.spigot.devtools.mod.gui;

import me.ihdeveloper.spigot.devtools.mod.GUIOverlay;
import me.ihdeveloper.spigot.devtools.mod.tool.Profiler;
import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;

import java.util.ArrayList;
import java.util.List;

public class GUIProfiler extends GUIOverlay {
    private static final int defaultTextColor = DrawUtils.colorFromRGBA(1f, 1f, 1f, 1f);

    private final Profiler profiler;
    private final List<Profiler.Item> updatedItems = new ArrayList<>();
    private final List<Profiler.Item> oldItems = new ArrayList<>();

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
        drawDescription("§7Provide an overview of the performance of certain operations");
        drawTable();

        String header = "§7§oTotal: " + profiler.getTotalTicks() + " ticks (" + profiler.getTotalMilliseconds() + " ms)";
        drawString(mc.fontRendererObj, header, this.tableX + 15, this.tableY + 10, defaultTextColor);

        drawItems();
    }

    private void drawItems() {
        int x = this.tableX + 30;
        int y = this.tableY + 25;

        int index = 1;
        for (Profiler.Item item : updatedItems) {
            // TODO implement better color scheme
            int defaultColor = DrawUtils.colorFromRGBA(0.75f + (0.05f * index), 0.1f + (0.15f * index), 0.25f + (0.05f * index), 1f);
            drawString(mc.fontRendererObj, "[" + index + "] " + item.getName(), x, y, defaultColor);
            drawString(mc.fontRendererObj, ((double)Math.round(item.getPercent() * 100.0) / 100.0) + "%", x + 160, y, defaultColor);
            drawString(mc.fontRendererObj, "§e" + item.getTicks() + " §6ticks", x + 200, y, defaultColor);
            drawString(mc.fontRendererObj, item.getMilliseconds() + "ms", x + 300, y, defaultColor);
            y += 10;
            index++;
        }

        for (Profiler.Item item : oldItems) {
            drawString(mc.fontRendererObj, "§7§o[#] " + item.getName(), x, y, defaultTextColor);
            drawString(mc.fontRendererObj, "§7§o" + item.getTicks() + " ticks", x + 200, y, defaultTextColor);
            drawString(mc.fontRendererObj, "§7§o" + item.getMilliseconds() + "ms", x + 300, y, defaultTextColor);
            y += 10;
        }
    }

}
