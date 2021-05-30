package me.ihdeveloper.spigot.devtools.mod.utils;

import me.ihdeveloper.spigot.devtools.mod.AuthState;
import me.ihdeveloper.spigot.devtools.mod.Main;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.Color;

public class RenderUtils {

    public static void renderAuthStatus(ScaledResolution scaledResolution, AuthState authState) {
        int height = scaledResolution.getScaledHeight();
        int width = scaledResolution.getScaledWidth();

        String status;
        Color color;

        if (authState == AuthState.NOT_REQUESTED) {
            status = "Not Authorized!";
            color = Color.RED;
        } else if (authState == AuthState.WAITING_FOR_RESPONSE) {
            status = "Authenticating...";
            color = Color.YELLOW;
        } else if (authState == AuthState.AUTHORIZED) {
            status = "Authorized!";
            color = Color.GREEN;
        } else {
            status = "§7Unknown";
            color = Color.BLACK;
        }

        DrawUtils.drawCenteredText(status, (width * 2f) - 100f, height - 40f, color.getRGB());
    }

    public static void renderDiscovery(ScaledResolution scaledResolution, boolean discovered, byte major, byte minor) {
        int height = scaledResolution.getScaledHeight();
        int width = scaledResolution.getScaledWidth();

        String status;
        if (discovered) {
            boolean compatible = (Main.protocolMajor == major && Main.protocolMinor >= minor);
            status = "§2Discovered! §ev§" + (compatible ? '6' : 'c') + major + "." + minor;
        } else {
            status = "§4Not Discovered";
        }

        DrawUtils.drawCenteredText(status, (width * 2f) - 100f, height - 20f, DrawUtils.colorFromRGBA(0, 0, 0, 1));
    }

    public static void renderTPS(ScaledResolution scaledResolution, double tps) {
        int height = scaledResolution.getScaledHeight();
        int width = scaledResolution.getScaledWidth();

        char prefix;
        double fixedTPS = Math.min((double)Math.round(tps * 100.0D) / 100.0D, 20.0D);

        if (fixedTPS >= 18.0D)
            prefix = 'f';
        else if (fixedTPS >= 16.0D)
            prefix = 'e';
        else
            prefix = 'c';

        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (tps > 20.0D)
            builder.append('*');
        builder.append(fixedTPS);

        DrawUtils.drawCenteredText("§eTPS: §" + builder.toString(), (width * 2f) - 100f, height - 20f, Color.WHITE.getRGB());
    }

}
