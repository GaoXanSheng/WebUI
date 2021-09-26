package www.yunmouren.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class Message implements IMessage {

    String sender;

    public Message() {
    }

    public Message(String sender) {
        this.sender = sender;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        sender = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, sender);
    }
}
