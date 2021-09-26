package www.yunmouren.GUI;


import net.minecraft.entity.player.EntityPlayer;

public class Container extends net.minecraft.inventory.Container {
    public Container() {
        super();
    }
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
    }
    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}