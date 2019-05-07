package com.mera.inkrot.apachecxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloService {

    @WebMethod(action = "hello")
    String hello(@WebParam(name = "name") String name);

    @WebMethod(action = "bye")
    String bye(@WebParam(name = "n") String n);
}
