package com.mera.inkrot.apachecxf.service;

import com.mera.inkrot.apachecxf.model.Customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CustomerService {

    @WebMethod(action = "getById")
    Customer getById(@WebParam(name = "id") Long id);

    @WebMethod(action = "add")
    Customer save(@WebParam(name = "name") String name);
}
