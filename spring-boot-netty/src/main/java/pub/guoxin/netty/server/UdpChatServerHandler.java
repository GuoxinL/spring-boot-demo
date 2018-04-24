package pub.guoxin.netty.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * Created by guoxin on 17-10-11.
 */
public class UdpChatServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //注意，UDP的通道至始至终只有一个，关了就不能接收了。
        System.out.println("UDP通道已经连接");
        UdpServer.ctx = ctx;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {

        System.out.println("消息来源" + packet.sender().getHostName() + ":" + packet.sender().getPort());

        // 消息处理。。。。。
        String s = packet.content().toString(CharsetUtil.UTF_8);
        System.out.println(s);
        //消息发送。。。。
        DatagramPacket dp = new DatagramPacket(Unpooled.copiedBuffer("消息".getBytes()), packet.sender());
        UdpServer.channel.writeAndFlush(dp);

    }


}
