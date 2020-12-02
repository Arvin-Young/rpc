package com.tony.rpc.remoting;

import java.net.URI;

public interface Transporter {

    Server start(URI uri);
}
