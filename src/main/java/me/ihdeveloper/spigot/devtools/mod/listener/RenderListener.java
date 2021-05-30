package me.ihdeveloper.spigot.devtools.mod.listener;

import me.ihdeveloper.spigot.devtools.mod.AuthState;
import me.ihdeveloper.spigot.devtools.mod.Container;
import me.ihdeveloper.spigot.devtools.mod.Main;
import me.ihdeveloper.spigot.devtools.mod.utils.RenderUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderListener {

    @SubscribeEvent()
    @SuppressWarnings("unused")
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            Container container = Main.getInstance().getContainer();
            RenderUtils.renderAuthStatus(event.resolution, container.getAuthState());

            if (container.getAuthState() == AuthState.AUTHORIZED) {
                RenderUtils.renderTPS(event.resolution, container.getTPS(0));
            } else {
                RenderUtils.renderDiscovery(event.resolution, container.isDiscovered(), container.getSupportedMajor(), container.getSupportedMinor());
            }
        }
    }

}
