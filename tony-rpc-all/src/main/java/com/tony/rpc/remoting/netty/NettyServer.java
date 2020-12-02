package com.tony.rpc.remoting.netty;

import com.tony.rpc.remoting.Server;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;

public class NettyServer implements Server {
   /* public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        try {
            nettyServer.start(new URI("xxx://127.0.0.1:8080/"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }*/

    // 开启一个网络服务
    // 创建事件循环组
    EventLoopGroup boss = new NioEventLoopGroup();
    EventLoopGroup worker = new NioEventLoopGroup();

    public void start(URI uri) {
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(uri.getHost(), uri.getPort()))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyHandler());
                        }
                    });
            bootstrap.bind().sync();
            System.out.println("完成端口绑定和服务器启动");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
