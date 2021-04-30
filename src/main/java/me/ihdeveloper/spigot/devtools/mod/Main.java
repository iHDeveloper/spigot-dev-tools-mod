package me.ihdeveloper.spigot.devtools.mod;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import me.ihdeveloper.spigot.devtools.mod.command.HelloCommand;
import me.ihdeveloper.spigot.devtools.mod.command.TPSCommand;
import me.ihdeveloper.spigot.devtools.mod.command.WatcherCommand;
import me.ihdeveloper.spigot.devtools.mod.listener.GUIListener;
import me.ihdeveloper.spigot.devtools.mod.listener.RenderListener;
import me.ihdeveloper.spigot.devtools.mod.netty.ChannelHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S3FPacketCustomPayload;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.FMLOutboundHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import net.minecraftforge.fml.relauncher.Side;

import java.util.EnumMap;

@Mod(modid = "spigot-dev-tools", version = "0.1")
public class Main {
    public static final byte protocolMajor = 0;
    public static final byte protocolMinor = 1;

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    private EnumMap<Side, FMLEmbeddedChannel> channels;
    private Container container = new Container();

    private GUIListener guiListener = new GUIListener();

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(guiListener);
        MinecraftForge.EVENT_BUS.register(new RenderListener());

        ClientCommandHandler.instance.registerCommand(new HelloCommand());
        ClientCommandHandler.instance.registerCommand(new WatcherCommand());
        ClientCommandHandler.instance.registerCommand(new TPSCommand());

        channels = NetworkRegistry.INSTANCE.newChannel("Spigot|DevTools", new ChannelHandler());
    }

    @SubscribeEvent()
    public void onDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        container = new Container();
    }

    public void syncOpenGUI(GUIType type) {
        guiListener.openGUI(type);
    }

    public void sendToServer(byte[] data) {
        ByteBuf buffer = Unpooled.wrappedBuffer(data);
        FMLProxyPacket packet = new FMLProxyPacket(new S3FPacketCustomPayload("Spigot|DevTools", new PacketBuffer(buffer)));
        channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
        channels.get(Side.CLIENT).writeAndFlush(packet).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
    }

    public Container getContainer() {
        return container;
    }

}
