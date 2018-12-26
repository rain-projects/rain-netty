package com.rain.netty.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.17.1)",
    comments = "Source: Students.proto")
public final class StudentsServiceGrpc {

  private StudentsServiceGrpc() {}

  public static final String SERVICE_NAME = "com.rain.netty.grpc.StudentsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetRealNameByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealNameByUsername",
      requestType = MyRequest.class,
      responseType = MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MyRequest,
      MyResponse> getGetRealNameByUsernameMethod() {
    io.grpc.MethodDescriptor<MyRequest, MyResponse> getGetRealNameByUsernameMethod;
    if ((getGetRealNameByUsernameMethod = StudentsServiceGrpc.getGetRealNameByUsernameMethod) == null) {
      synchronized (StudentsServiceGrpc.class) {
        if ((getGetRealNameByUsernameMethod = StudentsServiceGrpc.getGetRealNameByUsernameMethod) == null) {
          StudentsServiceGrpc.getGetRealNameByUsernameMethod = getGetRealNameByUsernameMethod = 
              io.grpc.MethodDescriptor.<MyRequest, MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.rain.netty.grpc.StudentsService", "GetRealNameByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentsServiceMethodDescriptorSupplier("GetRealNameByUsername"))
                  .build();
          }
        }
     }
     return getGetRealNameByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StudentsAge,
      MyResponse> getGetStudentsByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsByAge",
      requestType = StudentsAge.class,
      responseType = MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<StudentsAge,
      MyResponse> getGetStudentsByAgeMethod() {
    io.grpc.MethodDescriptor<StudentsAge, MyResponse> getGetStudentsByAgeMethod;
    if ((getGetStudentsByAgeMethod = StudentsServiceGrpc.getGetStudentsByAgeMethod) == null) {
      synchronized (StudentsServiceGrpc.class) {
        if ((getGetStudentsByAgeMethod = StudentsServiceGrpc.getGetStudentsByAgeMethod) == null) {
          StudentsServiceGrpc.getGetStudentsByAgeMethod = getGetStudentsByAgeMethod = 
              io.grpc.MethodDescriptor.<StudentsAge, MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.rain.netty.grpc.StudentsService", "GetStudentsByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentsAge.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentsServiceMethodDescriptorSupplier("GetStudentsByAge"))
                  .build();
          }
        }
     }
     return getGetStudentsByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<MyRequest,
      StudentsAge> getGetStudentsAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentsAge",
      requestType = MyRequest.class,
      responseType = StudentsAge.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<MyRequest,
      StudentsAge> getGetStudentsAgeMethod() {
    io.grpc.MethodDescriptor<MyRequest, StudentsAge> getGetStudentsAgeMethod;
    if ((getGetStudentsAgeMethod = StudentsServiceGrpc.getGetStudentsAgeMethod) == null) {
      synchronized (StudentsServiceGrpc.class) {
        if ((getGetStudentsAgeMethod = StudentsServiceGrpc.getGetStudentsAgeMethod) == null) {
          StudentsServiceGrpc.getGetStudentsAgeMethod = getGetStudentsAgeMethod = 
              io.grpc.MethodDescriptor.<MyRequest, StudentsAge>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.rain.netty.grpc.StudentsService", "GetStudentsAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StudentsAge.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentsServiceMethodDescriptorSupplier("GetStudentsAge"))
                  .build();
          }
        }
     }
     return getGetStudentsAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StreamRequest,
      StreamResponse> getBiStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiStream",
      requestType = StreamRequest.class,
      responseType = StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<StreamRequest,
      StreamResponse> getBiStreamMethod() {
    io.grpc.MethodDescriptor<StreamRequest, StreamResponse> getBiStreamMethod;
    if ((getBiStreamMethod = StudentsServiceGrpc.getBiStreamMethod) == null) {
      synchronized (StudentsServiceGrpc.class) {
        if ((getBiStreamMethod = StudentsServiceGrpc.getBiStreamMethod) == null) {
          StudentsServiceGrpc.getBiStreamMethod = getBiStreamMethod = 
              io.grpc.MethodDescriptor.<StreamRequest, StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.rain.netty.grpc.StudentsService", "BiStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StudentsServiceMethodDescriptorSupplier("BiStream"))
                  .build();
          }
        }
     }
     return getBiStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentsServiceStub newStub(io.grpc.Channel channel) {
    return new StudentsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StudentsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StudentsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StudentsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *请求相应单个对象
     * </pre>
     */
    public void getRealNameByUsername(MyRequest request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealNameByUsernameMethod(), responseObserver);
    }

    /**
     * <pre>
     *请求单个对象，响应流
     * </pre>
     */
    public void getStudentsByAge(StudentsAge request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentsByAgeMethod(), responseObserver);
    }

    /**
     * <pre>
     *请求流，响应单个对象
     * </pre>
     */
    public io.grpc.stub.StreamObserver<MyRequest> getStudentsAge(
        io.grpc.stub.StreamObserver<StudentsAge> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentsAgeMethod(), responseObserver);
    }

    /**
     * <pre>
     *请求流，响应流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<StreamRequest> biStream(
        io.grpc.stub.StreamObserver<StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiStreamMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealNameByUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                MyRequest,
                MyResponse>(
                  this, METHODID_GET_REAL_NAME_BY_USERNAME)))
          .addMethod(
            getGetStudentsByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                StudentsAge,
                MyResponse>(
                  this, METHODID_GET_STUDENTS_BY_AGE)))
          .addMethod(
            getGetStudentsAgeMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                MyRequest,
                StudentsAge>(
                  this, METHODID_GET_STUDENTS_AGE)))
          .addMethod(
            getBiStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                StreamRequest,
                StreamResponse>(
                  this, METHODID_BI_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class StudentsServiceStub extends io.grpc.stub.AbstractStub<StudentsServiceStub> {
    private StudentsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *请求相应单个对象
     * </pre>
     */
    public void getRealNameByUsername(MyRequest request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *请求单个对象，响应流
     * </pre>
     */
    public void getStudentsByAge(StudentsAge request,
        io.grpc.stub.StreamObserver<MyResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentsByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *请求流，响应单个对象
     * </pre>
     */
    public io.grpc.stub.StreamObserver<MyRequest> getStudentsAge(
        io.grpc.stub.StreamObserver<StudentsAge> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentsAgeMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *请求流，响应流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<StreamRequest> biStream(
        io.grpc.stub.StreamObserver<StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentsServiceBlockingStub extends io.grpc.stub.AbstractStub<StudentsServiceBlockingStub> {
    private StudentsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *请求相应单个对象
     * </pre>
     */
    public MyResponse getRealNameByUsername(MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealNameByUsernameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *请求单个对象，响应流
     * </pre>
     */
    public java.util.Iterator<MyResponse> getStudentsByAge(
        StudentsAge request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentsByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentsServiceFutureStub extends io.grpc.stub.AbstractStub<StudentsServiceFutureStub> {
    private StudentsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StudentsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StudentsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *请求相应单个对象
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<MyResponse> getRealNameByUsername(
        MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealNameByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_NAME_BY_USERNAME = 0;
  private static final int METHODID_GET_STUDENTS_BY_AGE = 1;
  private static final int METHODID_GET_STUDENTS_AGE = 2;
  private static final int METHODID_BI_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_NAME_BY_USERNAME:
          serviceImpl.getRealNameByUsername((MyRequest) request,
              (io.grpc.stub.StreamObserver<MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENTS_BY_AGE:
          serviceImpl.getStudentsByAge((StudentsAge) request,
              (io.grpc.stub.StreamObserver<MyResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENTS_AGE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentsAge(
              (io.grpc.stub.StreamObserver<StudentsAge>) responseObserver);
        case METHODID_BI_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biStream(
              (io.grpc.stub.StreamObserver<StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentsServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Students.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentsService");
    }
  }

  private static final class StudentsServiceFileDescriptorSupplier
      extends StudentsServiceBaseDescriptorSupplier {
    StudentsServiceFileDescriptorSupplier() {}
  }

  private static final class StudentsServiceMethodDescriptorSupplier
      extends StudentsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentsServiceFileDescriptorSupplier())
              .addMethod(getGetRealNameByUsernameMethod())
              .addMethod(getGetStudentsByAgeMethod())
              .addMethod(getGetStudentsAgeMethod())
              .addMethod(getBiStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
