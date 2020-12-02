package com.tony.rpc.config.spring;

import com.tony.rpc.config.ProtocolConfig;
import com.tony.rpc.config.RegistryConfig;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Field;

// ��ΰ��Լ������Ķ��� �ŵ� spring --  BeanDefinition
public class TRPCConfiguration implements ImportBeanDefinitionRegistrar {

    StandardEnvironment environment;

    public TRPCConfiguration(Environment environment) {
        this.environment = (StandardEnvironment) environment;
    }

    // ��spring������ʱ��װ�� û��ע�� /xml����
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        // ����spring ���� ������ö������
        BeanDefinitionBuilder beanDefinitionBuilder = null;

        // 1.2 ProtocolConfig - ��ȡ���� ��ֵ trpc.protocol.name
        beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(ProtocolConfig.class);
        for (Field field : ProtocolConfig.class.getDeclaredFields()) {
            String value = environment.getProperty("trpc.protocol." + field.getName());
            beanDefinitionBuilder.addPropertyValue(field.getName(), value);
        }
        registry.registerBeanDefinition("protocolConfig", beanDefinitionBuilder.getBeanDefinition());

        // 1.2 RegistryConfig - ��ȡ���� ��ֵ trpc.registry.name
        beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(RegistryConfig.class);
        for (Field field : RegistryConfig.class.getDeclaredFields()) {
            String value = environment.getProperty("trpc.registry." + field.getName());// �������ļ� �ҵ� ��ƥ���ֵ
            beanDefinitionBuilder.addPropertyValue(field.getName(), value);
        }
        registry.registerBeanDefinition("registryConfig", beanDefinitionBuilder.getBeanDefinition());
    }
}
