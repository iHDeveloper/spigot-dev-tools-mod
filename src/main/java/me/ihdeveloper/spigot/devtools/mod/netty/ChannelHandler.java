package me.ihdeveloper.spigot.devtools.mod.netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.ihdeveloper.spigot.devtools.mod.AuthState;
import me.ihdeveloper.spigot.devtools.mod.Main;
import me.ihdeveloper.spigot.devtools.mod.utils.Debug;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

@Sharable
public class ChannelHandler extends SimpleChannelInboundHandler<FMLProxyPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) {
        byte[] data = new byte[msg.payload().readableBytes()];
        msg.payload().readBytes(data);
        ByteArrayInputStream stream = new ByteArrayInputStream(data);
        DataInputStream in = new DataInputStream(stream);

        String type = null;
        try {
            type = in.readUTF();

            in.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        Debug.info("Inbound Message: " + type);

        if (type == null) {
            Debug.warning("Empty message! §cThat's weird...");
            return;
        }

        if (type.equals("hello")) {
            Main.getInstance().getContainer().setAuthState(AuthState.AUTHORIZED);
        }
    }

}
