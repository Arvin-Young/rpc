package com.h3c.arvin.service;

import com.tony.rpc.config.annotation.TRpcService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@TRpcService
public class TestService {
    @Value("${trpc.registry.address}")
    private String address;
    public void test() {
        System.out.println(address);
    }
}
