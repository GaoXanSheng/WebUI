package www.yunmouren.Command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;
import www.yunmouren.WEB;

import static www.yunmouren.GUI.GuiElementLoader.GUI_DEMO;

public class CommandWEB extends CommandBase {
    public static String url;

    @Override
    public @NotNull String getName() {
        return "web";
    }

    @Override
    public @NotNull String getUsage(@NotNull ICommandSender iCommandSender) {
        return "web <url>";
    }

    @Override
    public void execute(@NotNull MinecraftServer server, @NotNull ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new TextComponentString("URL is required"));
        } else {
            try {
                url = args[0];
                getPlayer(server, sender).openGui(WEB.INSTANCE, GUI_DEMO, sender.getEntityWorld(), 0, 0, 0);
            } catch (NullPointerException e) {
                sender.sendMessage(new TextComponentString("Command Not Running Server Because There Was An Error"));
                sender.sendMessage(new TextComponentString("I can't tell you what the mistake was"));
            }
        }
    }

    /**
     * 拿到玩家实体
     *
     */
    public EntityPlayerMP getPlayer(MinecraftServer server, ICommandSender sender) {
        return server.getPlayerList().getPlayerByUsername(sender.getName());
    }

}