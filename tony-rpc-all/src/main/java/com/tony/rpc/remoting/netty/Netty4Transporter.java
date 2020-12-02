package com.tony.rpc.remoting.netty;

import com.tony.rpc.remoting.Server;
import com.tony.rpc.remoting.Transporter;

import java.net.URI;

public class Netty4Transporter implements Transporter {
    public Server start(URI uri) {
        NettyServer server = new NettyServer();
        server.start(uri);
        return server;
    }
}
