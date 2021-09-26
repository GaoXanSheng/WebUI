package www.yunmouren.proxy;

import net.montoyo.mcef.api.*;

public class ClientProxy implements API {

    @Override
    public IBrowser createBrowser(String url, boolean b) {
        return null;
    }

    @Override
    public IBrowser createBrowser(String url) {
        return null;
    }

    @Override
    public void registerDisplayHandler(IDisplayHandler iDisplayHandler) {

    }

    @Override
    public void registerJSQueryHandler(IJSQueryHandler ijsQueryHandler) {

    }

    @Override
    public boolean isVirtual() {
        return false;
    }

    @Override
    public void openExampleBrowser(String s) {

    }

    @Override
    public String mimeTypeFromExtension(String s) {
        return null;
    }

    @Override
    public void registerScheme(String s, Class<? extends IScheme> aClass, boolean b, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6) {

    }

    @Override
    public boolean isSchemeRegistered(String s) {
        return false;
    }

    @Override
    public String punycode(String s) {
        return null;
    }
}
