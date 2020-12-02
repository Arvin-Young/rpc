package com.tony.rpc.config.spring.annotation;

import com.tony.rpc.config.spring.TRPCConfiguration;
import com.tony.rpc.config.spring.TRPCPostProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({TRPCPostProcessor.class, TRPCConfiguration.class})
public @interface EnableTRPC {
}
