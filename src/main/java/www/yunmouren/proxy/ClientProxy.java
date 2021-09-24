package www.yunmouren.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourceManager;
import net.minecraftforge.client.resource.IResourceType;
import net.minecraftforge.client.resource.ISelectiveResourceReloadListener;
import net.montoyo.mcef.api.*;
import net.montoyo.mcef.example.ModScheme;

import java.util.function.Predicate;

public class ClientProxy implements ISelectiveResourceReloadListener, IDisplayHandler, IJSQueryHandler {
    public class PadData {

        public IBrowser view;
        private final int id;
        public Minecraft minecraft = Minecraft.getMinecraft();
        private PadData(String url, int id) {
            view = mcef.createBrowser("www.baidu.com");
            view.resize(minecraft.displayHeight,minecraft.displayWidth);
            this.id = id;
        }

    }

    private Minecraft mc;
    private net.montoyo.mcef.api.API mcef;

    /**************************************** INHERITED METHODS ****************************************/

    public void preInit() {
        mcef = MCEFApi.getAPI();
        if(mcef != null)
            mcef.registerScheme("WEB", ModScheme.class, true, false, false, true, true, false, false);
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager) {
        ISelectiveResourceReloadListener.super.onResourceManagerReload(resourceManager);
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager, Predicate<IResourceType> resourcePredicate) {

    }

    @Override
    public void onAddressChange(IBrowser iBrowser, String s) {

    }

    @Override
    public void onTitleChange(IBrowser iBrowser, String s) {

    }

    @Override
    public void onTooltip(IBrowser iBrowser, String s) {

    }

    @Override
    public void onStatusMessage(IBrowser iBrowser, String s) {

    }

    @Override
    public boolean handleQuery(IBrowser iBrowser, long l, String s, boolean b, IJSQueryCallback ijsQueryCallback) {
        return false;
    }

    @Override
    public void cancelQuery(IBrowser iBrowser, long l) {

    }
}
