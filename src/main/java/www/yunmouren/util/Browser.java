package www.yunmouren.util;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.montoyo.mcef.MCEF;
import net.montoyo.mcef.api.API;
import net.montoyo.mcef.api.IBrowser;
import net.montoyo.mcef.api.MCEFApi;
import net.montoyo.mcef.example.ExampleMod;
import net.montoyo.mcef.example.ScreenCfg;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Browser extends GuiScreen {
    IBrowser browser = null;
    private GuiButton back = null;
    private GuiButton fwd = null;
    private GuiButton go = null;
    private GuiButton min = null;
    private GuiButton vidMode = null;
    private GuiTextField url = null;
    private String urlToLoad;

    public Browser() {
        this.urlToLoad = MCEF.HOME_PAGE;
    }

    public Browser(String url) {
        this.urlToLoad = url;
    }
    public void initGui() {
        if (this.browser == null) {
            API api = MCEFApi.getAPI();
            if (api == null) {
                return;
            }

            this.browser = api.createBrowser(urlToLoad, true);
            this.urlToLoad = null;
        }

        if (this.browser != null) {
            this.browser.resize(this.mc.displayWidth, this.mc.displayHeight);
        }

        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        if (this.url == null) {
            this.buttonList.add(this.back = new GuiButton(0, 0, 0, 0, 0, ""));
            this.buttonList.add(this.fwd = new GuiButton(1, 0, 0, 0, 0, ""));
            this.buttonList.add(this.go = new GuiButton(2, 0, 0, 0, 0, ""));
            this.buttonList.add(this.min = new GuiButton(3, 0, 0, 0, 0, ""));
            this.buttonList.add(this.vidMode = new GuiButton(4, 0, 0, 20, 0, ""));
            this.vidMode.enabled = true;
            this.url = new GuiTextField(5, this.fontRenderer, 0, 0, 0, 0);
            this.url.setMaxStringLength(65535);
        } else {
            this.buttonList.add(this.back);
            this.buttonList.add(this.fwd);
            this.buttonList.add(this.go);
            this.buttonList.add(this.min);
            this.buttonList.add(this.vidMode);
            this.vidMode.x = this.width - 40;
            this.go.x = this.width - 60;
            this.min.x = this.width - 20;
            String old = this.url.getText();
            this.url = new GuiTextField(5, this.fontRenderer, 0, 0, 0, 0);
            this.url.setMaxStringLength(65535);
            this.url.setText(old);
        }

    }

    public int scaleY(int y) {
        double sy = (double) y / (double) this.height * (double) this.mc.displayHeight;
        return (int) sy;
    }


    public void updateScreen() {
        if (this.urlToLoad != null && this.browser != null) {
            this.browser.loadURL(this.urlToLoad);
            this.urlToLoad = null;
        }

    }

    public void drawScreen(int i1, int i2, float f) {
        this.url.drawTextBox();
        super.drawScreen(i1, i2, f);
        if (this.browser != null) {
            GlStateManager.disableDepth();
            GlStateManager.enableTexture2D();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.browser.draw(0.0D, (double)this.height, (double)this.width, 0.0D);
            GlStateManager.enableDepth();
        }

    }


    public void handleInput() {
        boolean pressed;
        int num;
        while (Keyboard.next()) {
            if (Keyboard.getEventKey() == 1) {
                this.mc.displayGuiScreen((GuiScreen) null);
                return;
            }

            pressed = Keyboard.getEventKeyState();
            pressed = this.url.isFocused();
            char key = Keyboard.getEventCharacter();
            num = Keyboard.getEventKey();
            if (this.browser != null && !pressed) {
                if (pressed) {
                    this.browser.injectKeyPressedByKeyCode(num, key, 0);
                } else {
                    this.browser.injectKeyReleasedByKeyCode(num, key, 0);
                }

                int code = 0;
                if (key != 0) {
                    this.browser.injectKeyTyped(key, code, 0);
                }
            }

            if (!pressed && pressed && num == 28) {
                this.actionPerformed(this.go);
            } else if (pressed) {
                this.url.textboxKeyTyped(key, num);
            }
        }

        while (Mouse.next()) {
            int btn = Mouse.getEventButton();
            pressed = Mouse.getEventButtonState();
            int sx = Mouse.getEventX();
            num = Mouse.getEventY();
            int wheel = Mouse.getEventDWheel();
            int y;
            if (this.browser != null) {
                y = this.mc.displayHeight - num - this.scaleY(0);
                if (wheel != 0) {
                    this.browser.injectMouseWheel(sx, y, 0, 1, wheel);
                } else if (btn == -1) {
                    this.browser.injectMouseMove(sx, y, 0, y < 0);
                } else {
                    byte btn_;
                    if (btn == 0) {
                        btn_ = 1;
                    } else if (btn == 1) {
                        btn_ = 3;
                    } else {
                        btn_ = 2;
                    }

                    this.browser.injectMouseButton(sx, y, 0, btn_, pressed, 1);
                }
            }

            if (pressed) {
                y = sx * this.width / this.mc.displayWidth;
                y = this.height - num * this.height / this.mc.displayHeight - 1;

                try {
                    this.mouseClicked(y, y, btn);
                } catch (Throwable var9) {
                    var9.printStackTrace();
                }

                this.url.mouseClicked(y, y, btn);
            }
        }

    }

    protected void actionPerformed(GuiButton src) {
        if (this.browser != null) {
            if (src.id == 0) {
                this.browser.goBack();
            } else if (src.id == 1) {
                this.browser.goForward();
            } else {
                String loc;
                if (src.id == 2) {
                    loc = ExampleMod.INSTANCE.getAPI().punycode(this.url.getText());
                    this.browser.loadURL(loc);
                } else if (src.id == 3) {
                    this.mc.displayGuiScreen((GuiScreen) null);
                } else if (src.id == 4) {
                    loc = this.browser.getURL();
                    String vId = null;
                    boolean redo = false;
                    if (loc.matches("^https?://(?:www\\.)?youtube\\.com/watch\\?v=([a-zA-Z0-9_\\-]+)$")) {
                        vId = loc.replaceFirst("^https?://(?:www\\.)?youtube\\.com/watch\\?v=([a-zA-Z0-9_\\-]+)$", "$1");
                    } else if (loc.matches("^https?://(?:www\\.)?youtu\\.be/([a-zA-Z0-9_\\-]+)$")) {
                        vId = loc.replaceFirst("^https?://(?:www\\.)?youtu\\.be/([a-zA-Z0-9_\\-]+)$", "$1");
                    } else {
                        redo = true;
                    }

                    if (vId != null || redo) {
                        this.mc.displayGuiScreen(new ScreenCfg(this.browser, vId));
                    }
                }
            }

        }
    }
}
