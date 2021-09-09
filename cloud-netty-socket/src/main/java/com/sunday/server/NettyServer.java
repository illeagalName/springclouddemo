package com.sunday.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.server
 * @ClassName: NettyServer
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/8 13:17
 * @Version: 1.0
 */
public class NettyServer {
    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();

            try {
                ServerBootstrap serverBootstrap = new ServerBootstrap();
                //在服务器端的handler()方法表示对bossGroup起作用，而childHandler表示对wokerGroup起作用
                serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();

                                pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                                pipeline.addLast(new LengthFieldPrepender(4));
                                //字符串解码
                                pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                                //字符串编码
                                pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                                //自己定义的处理器
                                pipeline.addLast(new NettyServerHandler());
                            }
                        });

                ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
                System.out.println("服务器启动成功：" + 8899);
                channelFuture.channel().closeFuture().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        }).start();

        Thread.sleep(Integer.MAX_VALUE);
    }
}
