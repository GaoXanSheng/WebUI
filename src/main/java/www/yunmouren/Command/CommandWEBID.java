package www.yunmouren.Command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import www.yunmouren.WEB;
import www.yunmouren.network.Message;

import static www.yunmouren.GUI.GuiElementLoader.GUI_DEMO;
import static www.yunmouren.WEB.getNetwork;

public class CommandWEBID extends CommandBase {
    @Override
    public @NotNull String getName() {
        return "Url";
    }

    @Override
    public @NotNull String getUsage(@NotNull ICommandSender iCommandSender) {
        return "Url <player> <url>";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }

    @Override
    public void execute(@NotNull MinecraftServer server, @NotNull ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new TextComponentString("Player is required"));
            sender.sendMessage(new TextComponentString("Url <player> <url>"));
        } else {
            try {
                EntityPlayerMP Player = server.getPlayerList().getPlayerByUsername(args[0]);
                if (Player != null) {
                    getNetwork().sendTo(new Message(args[1]), Player);
                    Player.openGui(WEB.INSTANCE, GUI_DEMO, sender.getEntityWorld(), 0, 0, 0);
                }else {
                    sender.sendMessage(new TextComponentString("Player non-existent"));
                }
            } catch (RuntimeException e) {
                sender.sendMessage(new TextComponentString("I think you sent the command from the console."));
                sender.sendMessage(new TextComponentString("I'm sorry, I can't run him"));
            }
        }
    }
}