package com.rain.netty.grpc.test;

import com.rain.netty.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentsServiceImpl extends StudentsServiceGrpc.StudentsServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {

        System.out.println(request.getUsername());
        MyResponse myResponse = MyResponse.newBuilder().setRealname("张三").build();
        responseObserver.onNext(myResponse);
        responseObserver.onCompleted();

    }

    @Override
    public void getStudentsByAge(StudentsAge request, StreamObserver<MyResponse> responseObserver) {

        System.out.println(request.getAge());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("李四").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("王五").build());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("赵柳").build());
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<MyRequest> getStudentsAge(StreamObserver<StudentsAge> responseObserver) {
        return new StreamObserver<MyRequest>() {
            @Override
            public void onNext(MyRequest value) {
                System.out.println("客户端的请求：" + value.getUsername());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {

                responseObserver.onNext(StudentsAge.newBuilder().setAge(20).build());
                responseObserver.onCompleted();

            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biStream(StreamObserver<StreamResponse> responseObserver) {

        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println("客户端的请求：" + value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
