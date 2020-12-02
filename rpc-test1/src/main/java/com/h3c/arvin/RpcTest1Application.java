package com.h3c.arvin;

import com.tony.rpc.config.spring.annotation.EnableTRPC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableTRPC
@PropertySource("classpath:/trpc.properties")
public class RpcTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(RpcTest1Application.class, args);
    }

}
