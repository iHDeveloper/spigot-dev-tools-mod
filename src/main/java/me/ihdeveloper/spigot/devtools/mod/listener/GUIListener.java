package me.ihdeveloper.spigot.devtools.mod.listener;

import me.ihdeveloper.spigot.devtools.mod.Container;
import me.ihdeveloper.spigot.devtools.mod.GUIType;
import me.ihdeveloper.spigot.devtools.mod.Main;
import me.ihdeveloper.spigot.devtools.mod.gui.GUITPS;
import me.ihdeveloper.spigot.devtools.mod.gui.GUIWatcher;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Set;
import java.util.TreeSet;

public class GUIListener {
    private Set<GUIType> open = new TreeSet<>();

    public void openGUI(GUIType type) {
        open.add(type);
    }

    @SubscribeEvent()
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            Container container = Main.getInstance().getContainer();

            if (open.contains(GUIType.WATCHER)) {
                Minecraft.getMinecraft().displayGuiScreen(new GUIWatcher(container.getWatcher()));
            }

            if (open.contains(GUIType.TPS)) {
                Minecraft.getMinecraft().displayGuiScreen(new GUITPS(container));
            }

            open.clear();
        }
    }
}
