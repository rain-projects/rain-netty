package com.rain.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class ProtoTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        ProtoData.Students students = ProtoData.Students.newBuilder()
                .setName("张三").setAge(22).setAddress("深圳").build();

        byte[] bytes = students.toByteArray();

        System.out.println(Arrays.toString(bytes));

        ProtoData.Students students1 = ProtoData.Students.parseFrom(bytes);
        System.out.println(students1.getName());
        System.out.println(students1.getAge());
        System.out.println(students1.getAddress());

    }
}