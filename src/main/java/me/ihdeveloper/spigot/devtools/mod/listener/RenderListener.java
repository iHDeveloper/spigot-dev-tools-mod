package me.ihdeveloper.spigot.devtools.mod.listener;

import me.ihdeveloper.spigot.devtools.mod.Container;
import me.ihdeveloper.spigot.devtools.mod.Main;
import me.ihdeveloper.spigot.devtools.mod.utils.RenderUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderListener {

    @SubscribeEvent()
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            Container container = Main.getInstance().getContainer();
            RenderUtils.renderAuthStatus(event.resolution, container.getAuthState());
            RenderUtils.renderTPS(event.resolution, container.getTPS());
        }
    }

}
