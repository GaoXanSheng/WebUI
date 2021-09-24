package www.yunmouren.proxy;

import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;

public interface IProxy {
    void init();
    World getClientWorld();
    PlayerEvent getClientPlayer();
}
