package www.yunmouren;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.montoyo.mcef.api.IBrowser;

public class CommandWEB extends CommandBase {
    public Minecraft mc;
    IBrowser browser = null;

    @Override
    public String getName() {
        return "web";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "web <url>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new TextComponentString("web <url>"));
            sender.sendMessage(new TextComponentString("URL is required"));
        } else {
            sender.sendMessage(new TextComponentString(args[0]));
//            加载网站
        }
    }

    /**
     *  拿到玩家实体
     * @param server
     * @param sender
     * @return
     */
    public EntityPlayerMP getPlayer (MinecraftServer server, ICommandSender sender){
        return server.getPlayerList().getPlayerByUsername(sender.getName());
    }

}