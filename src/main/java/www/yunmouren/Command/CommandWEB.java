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
    public int getRequiredPermissionLevel()
    {
        return 1;
    }

    @Override
    public void execute(@NotNull MinecraftServer server, @NotNull ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new TextComponentString("URL is required"));
        } else {
            try {
                getNetwork().sendTo(new Message(args[0]),getPlayer(server,sender));
            }catch (RuntimeException e){
                sender.sendMessage(new TextComponentString("I think you sent the command from the console."));
                sender.sendMessage(new TextComponentString("I'm sorry, I can't run him"));
            }
            try {
                getPlayer(server, sender).openGui(WEB.INSTANCE, GUI_DEMO, sender.getEntityWorld(), 0, 0, 0);
            } catch (NullPointerException e) {
                sender.sendMessage(new TextComponentString("Command Not Running Server Because There Was An Error"));
                sender.sendMessage(new TextComponentString("I can't tell you what the mistake was"));
            }
        }
    }
    public static String GetURl(){
        return url;
    }

    /**
     * 拿到玩家实体
     *
     */
    public EntityPlayerMP getPlayer(MinecraftServer server, ICommandSender sender) {
        return server.getPlayerList().getPlayerByUsername(sender.getName());
    }

}