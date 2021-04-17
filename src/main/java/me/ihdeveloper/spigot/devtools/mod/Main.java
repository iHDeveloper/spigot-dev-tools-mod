package me.ihdeveloper.spigot.devtools.mod;

import me.ihdeveloper.spigot.devtools.mod.netty.ChannelHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = "spigot-dev-tools", version = "0.1")
public class Main {

    private SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
         Object s = NetworkRegistry.INSTANCE.newChannel("Spigot|DevTools", new ChannelHandler());
    }

}
