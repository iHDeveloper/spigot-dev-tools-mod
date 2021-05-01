package me.ihdeveloper.spigot.devtools.mod.command;

import me.ihdeveloper.spigot.devtools.mod.GUIType;
import me.ihdeveloper.spigot.devtools.mod.Main;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class ProfilerCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "sdt-profiler";
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
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        Main.getInstance().syncOpenGUI(GUIType.PROFILER);
    }
}
