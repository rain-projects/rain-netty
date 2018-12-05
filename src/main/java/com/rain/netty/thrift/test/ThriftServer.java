package com.rain.netty.thrift.test;

import com.rain.netty.thrift.generated.PersionService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServer {

    public static void main(String[] args) throws TTransportException {

        TNonblockingServerSocket socket = new TNonblockingServerSocket(8989);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(6);
        PersionService.Processor<PersionServiceImpl> persionServiceProcessor = new PersionService.Processor<>(new PersionServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(persionServiceProcessor));

        TServer server = new THsHaServer(arg);

        System.out.println("server started!!");

        server.serve();
    }

}
