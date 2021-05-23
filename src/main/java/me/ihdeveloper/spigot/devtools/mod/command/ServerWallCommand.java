package me.ihdeveloper.spigot.devtools.mod.command;

import me.ihdeveloper.spigot.devtools.mod.GUIType;
import me.ihdeveloper.spigot.devtools.mod.Main;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class ServerWallCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "sdt-wall";
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
        Main.getInstance().syncOpenGUI(GUIType.SERVER_WALL);
    }

}
