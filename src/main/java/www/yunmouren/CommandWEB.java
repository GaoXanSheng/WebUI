package www.yunmouren;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
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
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] args) {
        if (args.length == 0) {
            iCommandSender.sendMessage(new TextComponentString("web <url>"));
            iCommandSender.sendMessage(new TextComponentString("URL is required"));
        } else {
            iCommandSender.sendMessage(new TextComponentString(args[0]));
//            加载网站
        }
    }

}