package www.yunmouren.Command;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.montoyo.mcef.api.IBrowser;
import www.yunmouren.WEB;

import static www.yunmouren.GUI.GuiElementLoader.GUI_DEMO;

public class CommandWEB extends CommandBase {
    private net.montoyo.mcef.api.API mcef;
    private Minecraft mc = Minecraft.getMinecraft();
    public IBrowser view;
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
        } else{
//            view.resize(mc.displayHeight,mc.displayWidth);
//            view.draw(0,0,100,100);
//            打开GUI
            getPlayer(server,sender).openGui(WEB.INSTANCE,GUI_DEMO, sender.getEntityWorld(),0,0,0);
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