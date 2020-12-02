package com.tony.rpc.common.tools;


import java.util.ServiceLoader;

public class SpiUtils {
    public static Object getServiceImpl(String serviceName, Class classType) {
        ServiceLoader services = ServiceLoader.load(classType, Thread.currentThread().getContextClassLoader());
        // ���ݷ������Э�飬���α�¶�� ����ж��Э���Ǿͱ�¶���
        for (Object s : services) {
            if (s.getClass().getSimpleName().equals(serviceName)) {
                return s;
            }
        }
        return null;
    }
}
