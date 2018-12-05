package com.rain.netty.thrift.test;

import com.rain.netty.thrift.generated.DataException;
import com.rain.netty.thrift.generated.Persion;
import com.rain.netty.thrift.generated.PersionService;
import org.apache.thrift.TException;

public class PersionServiceImpl implements PersionService.Iface {

    @Override
    public Persion getPersionByName(String name) throws DataException, TException {

        System.out.println("客户端传过来的name" + name);
        Persion persion = new Persion();
        persion.setName("李晓红");
        persion.setAge(18);
        persion.setMarried(false);
        return persion;
    }

    @Override
    public void savePersion(Persion persion) throws DataException, TException {
        System.out.println(persion);
    }
}
