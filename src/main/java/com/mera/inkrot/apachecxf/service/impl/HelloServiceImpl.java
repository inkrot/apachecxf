package com.mera.inkrot.apachecxf.service.impl;

import com.mera.inkrot.apachecxf.service.HelloService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(endpointInterface = "com.mera.inkrot.apachecxf.service.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello, " + name + "!";
    }

    @Override
    public String bye(String n) {
        return "Bye, " + n + "!";
    }
}
