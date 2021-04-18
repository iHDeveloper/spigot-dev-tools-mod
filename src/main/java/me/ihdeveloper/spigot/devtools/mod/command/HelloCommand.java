package me.ihdeveloper.spigot.devtools.mod.command;

import me.ihdeveloper.spigot.devtools.mod.Main;
import me.ihdeveloper.spigot.devtools.mod.utils.Debug;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HelloCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "sdt-hello";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);
        try {
            out.writeUTF("hello");
            out.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            Debug.error("Failed to send hello! §7(" + exception.getMessage() + ")");
            sender.addChatMessage(new ChatComponentText("§cFailed to send hello! §7(" + exception.getMessage() + ")"));
            return;
        }

        Main.getInstance().setStatus("Authenticating...");
        Main.getInstance().setStatusColor(Color.YELLOW);
        sender.addChatMessage(new ChatComponentText("§eSending hello... §7o/"));
        Main.getInstance().sendToServer(stream.toByteArray());
    }
}
