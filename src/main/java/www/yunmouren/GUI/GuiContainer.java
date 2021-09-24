package www.yunmouren.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.montoyo.mcef.api.API;
import www.yunmouren.proxy.ClientProxy;

@SideOnly(Side.CLIENT)
public class GuiContainer extends GuiContainer {
    private Minecraft mc = Minecraft.getMinecraft();
    private API api;
    private ClientProxy.PadData pad;
    public GuiContainer(Container inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize = mc.displayWidth;
        this.ySize = mc.displayHeight;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        drawDefaultBackground();
//        pad.view.draw(0,10,0,10);
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        drawString(mc.fontRenderer, "WEB UI", 0, 0, 10);
        int offsetX = (this.width - this.xSize) / 2, offsetY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        // TODO
    }
}