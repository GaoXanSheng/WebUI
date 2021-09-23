package www.yunmouren;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class GUI extends Container {
    // 此方法必须覆写，因为父类里这是个抽象方法。
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
        // 返回 false 的时候会给你关掉 GUI。
    }
}