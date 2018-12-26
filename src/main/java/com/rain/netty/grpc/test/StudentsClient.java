package com.rain.netty.grpc.test;

import com.rain.netty.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.concurrent.TimeUnit;

public class StudentsClient {

    private static final Logger logger = Logger.getLogger(StudentsClient.class.getName());

    private final ManagedChannel channel;
    private final StudentsServiceGrpc.StudentsServiceBlockingStub blockingStub;
    private final StudentsServiceGrpc.StudentsServiceStub studentsServiceStub;

    public StudentsClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    StudentsClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = StudentsServiceGrpc.newBlockingStub(channel);
        studentsServiceStub = StudentsServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name) {
        MyRequest myRequest = MyRequest.newBuilder().setUsername(name).build();

        try {
            MyResponse myResponse = blockingStub.getRealNameByUsername(myRequest);
            System.out.println(myResponse.getRealname());
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
    }

    public void getStreamStudents(int age){
        StudentsAge build = StudentsAge.newBuilder().setAge(age).build();

        Iterator<MyResponse> studentsByAge = blockingStub.getStudentsByAge(build);
        while (studentsByAge.hasNext()) {
            System.out.println(studentsByAge.next().getRealname());
        }
    }

    public void getStudentsOnStream(String name) throws InterruptedException {


        StreamObserver<StudentsAge> streamObserver = new StreamObserver<StudentsAge>() {
            @Override
            public void onNext(StudentsAge value) {
                System.out.println("服务器响应的单个对象：" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
        StreamObserver<MyRequest> studentsAge = studentsServiceStub.getStudentsAge(streamObserver);
        studentsAge.onNext(MyRequest.newBuilder().setUsername("zhangsan").build());
        studentsAge.onNext(MyRequest.newBuilder().setUsername("lisi").build());
        studentsAge.onNext(MyRequest.newBuilder().setUsername("wangwu").build());
        studentsAge.onNext(MyRequest.newBuilder().setUsername("zhaoliu").build());
        studentsAge.onCompleted();

        Thread.sleep(1000);
    }

    public void TestBiStream() throws InterruptedException {
        StreamObserver<StreamResponse> responseObserver = new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println("服务器响应流：" + value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
        StreamObserver<StreamRequest> streamRequestStreamObserver = studentsServiceStub.biStream(responseObserver);
        for (int i = 0; i < 10; i++) {
            streamRequestStreamObserver.onNext(StreamRequest.newBuilder()
                    .setRequestInfo(LocalDate.now().toString()).build());
            Thread.sleep(1000);
        }
        streamRequestStreamObserver.onCompleted();
        Thread.sleep(1000);

    }

    public static void main(String[] args) throws Exception {
        StudentsClient studentsClient = new StudentsClient("localhost", 50051);
        try {
            String user = "zhangsan";
            studentsClient.greet(user);
            System.out.println("-----------------------");
            studentsClient.getStreamStudents(20);
            System.out.println("-----------------------");
            studentsClient.getStudentsOnStream("");
            System.out.println("-----------------------");
            studentsClient.TestBiStream();
            System.out.println("-----------------------");
        } finally {
            studentsClient.shutdown();
        }
    }

}
