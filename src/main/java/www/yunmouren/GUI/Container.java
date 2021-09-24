package www.yunmouren.GUI;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class Container extends net.minecraft.inventory.Container
{
    public Container()
    {
        super();
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
      return true;
    }
}