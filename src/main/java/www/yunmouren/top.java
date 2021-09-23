package www.yunmouren;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
        modid = top.MOD_ID,
        name = top.MOD_NAME,
        version = top.VERSION
)
public class top {

    public static final String MOD_ID = "www.yunmouren.top";
    public static final String MOD_NAME = "WEB";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static top INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        System.out.println("WEB mod By Yun_Nan");

    }
    @Mod.EventHandler
    public static void serverInit(FMLServerStartingEvent event) {serverRegister(event);}

    public static void serverRegister(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandWEB());
    }
}
