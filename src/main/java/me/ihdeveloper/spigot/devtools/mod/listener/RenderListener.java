package me.ihdeveloper.spigot.devtools.mod.listener;

import me.ihdeveloper.spigot.devtools.mod.Main;
import me.ihdeveloper.spigot.devtools.mod.utils.RenderUtils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderListener {

    @SubscribeEvent()
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            RenderUtils.renderAuthStatus(event.resolution, Main.getInstance().getContainer().getAuthState());
        }
    }

}
