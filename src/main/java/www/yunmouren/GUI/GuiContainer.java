package www.yunmouren.GUI;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import www.yunmouren.util.Browser;



@SideOnly(Side.CLIENT)
public class GuiContainer extends net.minecraft.client.gui.inventory.GuiContainer {
    public Minecraft mc = Minecraft.getMinecraft();
    public static String URL;
    public GuiContainer(Container inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize = mc.displayWidth;
        this.ySize = mc.displayHeight;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        drawString(mc.fontRenderer, "WEB UI", 2, 0, 10);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        // TODO
        this.mc.displayGuiScreen(new Browser(URL));
    }
    public static void GetUrl(String url){
        URL = url;
    }
}