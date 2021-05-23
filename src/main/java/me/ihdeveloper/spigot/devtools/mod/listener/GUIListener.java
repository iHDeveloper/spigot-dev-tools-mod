package me.ihdeveloper.spigot.devtools.mod.listener;

import me.ihdeveloper.spigot.devtools.mod.Container;
import me.ihdeveloper.spigot.devtools.mod.GUIType;
import me.ihdeveloper.spigot.devtools.mod.Main;
import me.ihdeveloper.spigot.devtools.mod.gui.GUIProfiler;
import me.ihdeveloper.spigot.devtools.mod.gui.GUIServerWall;
import me.ihdeveloper.spigot.devtools.mod.gui.GUITPS;
import me.ihdeveloper.spigot.devtools.mod.gui.GUIWatcher;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Set;
import java.util.TreeSet;

public class GUIListener {
    private final Set<GUIType> open = new TreeSet<>();

    public void openGUI(GUIType type) {
        open.add(type);
    }

    @SubscribeEvent()
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            Container container = Main.getInstance().getContainer();

            GuiScreen screen = null;
            if (open.contains(GUIType.WATCHER)) {
                screen = new GUIWatcher(container.getWatcher());
            }

            if (open.contains(GUIType.TPS)) {
                screen = new GUITPS(container);
            }

            if (open.contains(GUIType.PROFILER)) {
                screen = new GUIProfiler(container.getProfiler());
            }

            if (open.contains(GUIType.SERVER_WALL)) {
                screen = new GUIServerWall(container.getServerWall());
            }

            if (screen != null) {
                Minecraft.getMinecraft().displayGuiScreen(screen);
            }

            open.clear();
        }
    }
}
