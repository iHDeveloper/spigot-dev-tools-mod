package me.ihdeveloper.spigot.devtools.mod.gui;


import me.ihdeveloper.spigot.devtools.mod.GUIOverlay;
import me.ihdeveloper.spigot.devtools.mod.tool.Logger;
import me.ihdeveloper.spigot.devtools.mod.utils.DrawUtils;

import java.awt.Color;

public class GUILogger extends GUIOverlay {
    private static final int MAX_SIZE_RENDER = 20;

    private static final int defaultTextColor = DrawUtils.colorFromRGBA(1f, 1f, 1f, 1f);

    private static final byte TYPE_INFO = 4;
    private static final byte TYPE_WARNING = 3;
    private static final byte TYPE_ERROR = 2;
    private static final byte TYPE_DEBUG = 1;

    private static final int COLOR_INFO = Color.CYAN.getRGB();
    private static final int COLOR_WARNING = Color.YELLOW.getRGB();
    private static final int COLOR_ERROR = Color.RED.getRGB();
    private static final int COLOR_DEBUG = Color.ORANGE.getRGB();

    private final Logger logger;

    public GUILogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        beforeDrawScreen();
        drawTitle("§6Logger");
        drawDescription("§7Records events that occur in the server");
        drawTable();

        int size = logger.all().size();

        String header = "§7§oTotal: " + size;
        drawString(mc.fontRendererObj, header, this.tableX + 5, this.tableY + this.tableHeight - 10, defaultTextColor);

        if (size > 0)
            drawMessages();
    }

    private void drawMessages() {
        int x = this.tableX + 10;
        int y = this.tableY + this.tableHeight - 30;

        int count = 0;
        int color = DrawUtils.colorFromRGBA(0, 0, 0, 1f);
        for (int index = logger.all().size() - 1; index >= 0; index--) {
            count++;
            if (count > MAX_SIZE_RENDER) {
                break;
            }

            Logger.Message log = logger.all().get(index);
            int type = log.getType();
            String prefix = "§7[UNKNOWN]";
            if (type == TYPE_DEBUG) {
                color = COLOR_DEBUG;
                prefix = "§e[DEBUG]";
            } else if (type == TYPE_ERROR) {
                color = COLOR_ERROR;
                prefix = "§c[ERROR]";
            } else if (type == TYPE_WARNING) {
                color = COLOR_WARNING;
                prefix = "§6[WARNING]";
            } else if (type == TYPE_INFO) {
                color = COLOR_INFO;
                prefix = "§3[INFO]";
            }

            drawString(mc.fontRendererObj, prefix + "§r " + log.getMessage(), x, y, color);

            y -= 10;
        }
    }

}
