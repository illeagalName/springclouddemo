package com.sunday.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.util.Scanner;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.client
 * @ClassName: MyClient
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/8 13:27
 * @Version: 1.0
 */
public class MyClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();

                            pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            pipeline.addLast(new LengthFieldPrepender(4));
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new MyClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();

            System.out.println(channelFuture.channel().localAddress().toString());
            System.out.println("#################################################");
            System.out.println("~~~~~~~~~~~~~~端口号#消息内容~~这样可以给单独一个用户发消息~~~~~~~~~~~~~~~~~~");
            System.out.println("#################################################");
            Channel channel = channelFuture.channel();
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                String str = scanner.nextLine();
                channel.writeAndFlush(str+"\n");
            }

            channelFuture.channel().closeFuture().sync();
            scanner.close();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
