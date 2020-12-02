package com.tony.rpc.config.spring;

import com.tony.rpc.common.tools.SpiUtils;
import com.tony.rpc.config.ProtocolConfig;
import com.tony.rpc.config.RegistryConfig;
import com.tony.rpc.config.annotation.TRpcService;
import com.tony.rpc.remoting.Transporter;
import com.tony.rpc.remoting.netty.Netty4Transporter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.net.URI;
import java.net.URISyntaxException;

public class TRPCPostProcessor implements ApplicationContextAware, InstantiationAwareBeanPostProcessor {
    ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(TRpcService.class)) {
            System.out.println("扎到了需要开发网络访问的service实现类，启动网络服务，接受请求");
            ProtocolConfig protocolConfig = applicationContext.getBean(ProtocolConfig.class);
            String transporterName = protocolConfig.getTransporter();
            Transporter transporter = (Transporter) SpiUtils.getServiceImpl(transporterName, Transporter.class);
            try {
                transporter.start(new URI("xxx://127.0.0.1:8080/"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        if (bean.getClass().equals(RegistryConfig.class)) {
            RegistryConfig registryConfig = (RegistryConfig) bean;
            System.out.println("registryConfig: " + registryConfig.getAddress());
        }
        return bean;
    }
}
