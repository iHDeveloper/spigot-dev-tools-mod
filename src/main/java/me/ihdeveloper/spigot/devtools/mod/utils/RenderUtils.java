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

        DrawUtils.drawCenteredText(status, (width * 2f) - 100f, height - 20f, color.getRGB());
    }

}
