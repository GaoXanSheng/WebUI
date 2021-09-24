package www.yunmouren;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import www.yunmouren.Command.CommandWEB;
import www.yunmouren.GUI.test.GuiElementLoader;

@Mod(
        modid = www.yunmouren.WEB.MOD_ID,
        name = www.yunmouren.WEB.MOD_NAME,
        version = www.yunmouren.WEB.VERSION,
        dependencies = "required-after:mcef@[1.0,2.0);after:opencomputers;after:computercraft;"
)
public class WEB {

    public static final String MOD_ID = "web";
    public static final String MOD_NAME = "WEB";
    public static final String VERSION = "1.0-SNAPSHOT";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static WEB INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        new GuiElementLoader();
        System.out.println("WEB mod By Yun_Nan");

    }

    @Mod.EventHandler
    public static void serverInit(FMLServerStartingEvent event) {serverRegister(event);}

    public static void serverRegister(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandWEB());
    }
}
