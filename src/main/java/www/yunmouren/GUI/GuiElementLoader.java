package www.yunmouren.GUI;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import www.yunmouren.WEB;

public class GuiElementLoader implements IGuiHandler {
    public static final int GUI_DEMO = 1;

    public GuiElementLoader() {
        NetworkRegistry.INSTANCE.registerGuiHandler(WEB.INSTANCE, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_DEMO:
                return new Container();
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GUI_DEMO:
                return new GuiContainer(new Container());
            default:
                return null;
        }
    }
}