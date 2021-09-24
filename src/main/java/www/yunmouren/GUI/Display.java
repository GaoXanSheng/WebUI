package www.yunmouren.GUI;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.montoyo.mcef.api.IBrowser;
import www.yunmouren.WEB;

public class Display extends Gui {
    // 材质图
    public static final ResourceLocation hud = new ResourceLocation(WEB.MOD_ID, "textures/img.png");
    // mc 实例，方便使用
    private Minecraft mc;
    private IBrowser IBrowser;

    public Display() {
        this.mc = Minecraft.getMinecraft();
    }

    public void render() {
        ScaledResolution r = new ScaledResolution(this.mc);
        this.mc.getTextureManager().bindTexture(hud);
        int win_w = r.getScaledWidth();
        int win_h = r.getScaledHeight();
        // 分别画左右两边的图
        drawString(mc.fontRenderer, "NB", 10, 10, 255);
        drawModalRectWithCustomSizedTexture(win_w / 3 - 32, win_h / 2 - 32, 0, 0, 64, 64, 128, 64);
    }
}