package com.mera.inkrot.apachecxf.service;

import com.mera.inkrot.apachecxf.model.Customer;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CustomerService {

    @WebMethod(action = "getById")
    Customer getById(@WebParam(name = "id") Long id);
}
