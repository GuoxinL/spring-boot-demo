package pub.guoxin.netty.server;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.springframework.boot.CommandLineRunner;
import pub.guoxin.netty.client.TheMomentClient;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by guoxin on 17-10-10.
 */
public class UdpServer implements CommandLineRunner {

    // UDP服务监听的数据通道
    public static Channel channel;

    public static ChannelHandlerContext ctx;

    // 搞个map保存与客户端地址的映射关系
    public static ConcurrentMap<Integer, TheMomentClient> userSocketMap = new ConcurrentHashMap<>();

    // 创建一个阻塞队列，用于消息缓冲
    public static BlockingQueue<DatagramPacket> msgQueue = new LinkedBlockingQueue<DatagramPacket>();

    private int port;// 监听端口号

    public UdpServer(int port) {
        this.port = port;
    }

    public void run() {

        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap(); // udp不能使用ServerBootstrap
            bootstrap.group(workerGroup).channel(NioDatagramChannel.class); // 设置UDP通道
            bootstrap.handler(new UdpServerInitializer()); // 初始化处理器
            bootstrap.option(ChannelOption.SO_BROADCAST, true); // 支持广播
            bootstrap.option(ChannelOption.SO_BACKLOG, 128);
            bootstrap.option(ChannelOption.SO_RCVBUF, 1024 * 1024);// 设置UDP读缓冲区为1M
            bootstrap.option(ChannelOption.SO_SNDBUF, 1024 * 1024);// 设置UDP写缓冲区为1M

            System.out.println("[UDP 启动了]");

            // 绑定端口，开始接收进来的连接
            ChannelFuture channelFuture = bootstrap.bind(port).sync();

            channel = channelFuture.channel();

            // 等待服务器 socket 关闭 。
            // 这不会发生，可以优雅地关闭服务器。
            channelFuture.channel().closeFuture().await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();

            System.out.println("[UDP 关闭了]");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        UdpServer udpServer = new UdpServer(49224);
        udpServer.run();
    }
}