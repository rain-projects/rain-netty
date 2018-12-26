package com.rain.netty.grpc.test;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.sound.midi.Soundbank;
import java.io.IOException;

public class StudentsServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new StudentsServiceImpl())
                .build()
                .start();
        System.out.println("server is start");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                server.shutdown();
                System.out.println("服务关闭！");
            }
        });

        server.awaitTermination();
    }

}
