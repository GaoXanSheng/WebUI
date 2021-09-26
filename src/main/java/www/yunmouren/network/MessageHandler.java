package www.yunmouren.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import www.yunmouren.GUI.GuiContainer;

public class MessageHandler implements IMessageHandler<Message, IMessage> {

    @Override
    public IMessage onMessage(Message message, MessageContext ctx) {
        if(ctx.side == Side.CLIENT) {
            GuiContainer.GetUrl(message.sender);
        }
        return null; //不回复消息，返回null;
    }
}