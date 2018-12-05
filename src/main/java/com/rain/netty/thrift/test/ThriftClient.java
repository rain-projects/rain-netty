package com.rain.netty.thrift.test;

import com.rain.netty.thrift.generated.Persion;
import com.rain.netty.thrift.generated.PersionService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {

    public static void main(String[] args) {

        TTransport transport = new TFramedTransport(new TSocket("localhost", 8989), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersionService.Client client = new PersionService.Client(protocol);

        try {
            transport.open();

            Persion persion = client.getPersionByName("张三");

            System.out.println(persion.getName());
            System.out.println(persion.getAge());
            System.out.println(persion.isMarried());

            Persion persion1 = new Persion();
            persion1.setName("李四");
            persion1.setAge(23);
            persion1.setMarried(true);
            client.savePersion(persion1);

        } catch (TException e) {
            e.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
