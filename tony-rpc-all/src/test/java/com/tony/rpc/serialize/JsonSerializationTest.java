package com.tony.rpc.serialize;

import com.tony.rpc.TestClass;
import com.tony.rpc.common.serialize.Serialization;
import com.tony.rpc.common.tools.SpiUtils;

import java.util.Arrays;

public class JsonSerializationTest {
    public static void main(String[] args) throws Exception {
        TestClass testClass = new TestClass();
        testClass.setName("Tony");
        testClass.setAge(18);

        Serialization jsonSerialization =
                (Serialization) SpiUtils.getServiceImpl("JsonSerialization", Serialization.class);
        byte[] serialize = jsonSerialization.serialize(testClass);
        System.out.println(Arrays.toString(serialize));

        TestClass deserialize = (TestClass) jsonSerialization.deserialize(serialize, TestClass.class);
        System.out.println(deserialize);
    }
}
