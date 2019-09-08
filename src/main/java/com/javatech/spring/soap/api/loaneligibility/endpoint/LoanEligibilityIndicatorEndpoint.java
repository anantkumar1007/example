package com.javatech.spring.soap.api.loaneligibility.endpoint;

import com.javatech.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatech.spring.soap.api.loaneligibility.CustomerRequest;
import com.javatech.spring.soap.api.loaneligibility.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {
    private static  final String NAMESPACE="http://www.javatech.com/spring/soap/api/loaneligibility";
    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace= NAMESPACE,localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return service.checkLoanEligibility(request);
    }
}
