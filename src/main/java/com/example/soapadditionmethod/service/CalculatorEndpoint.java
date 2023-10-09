package com.example.soapadditionmethod.service;

import com.example.soapadditionmethod.dto.AddRequest;
import com.example.soapadditionmethod.dto.AddResponse;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CalculatorEndpoint {

    public static final String NAMESPACE_URI = "http://example.com/calculator";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "add")
    @ResponsePayload
    public AddResponse add(@RequestPayload JAXBElement<AddRequest> request) {
        System.out.println("Request.... "+ request.getValue().getNumber1() +" "+ request.getValue().getNumber2());
        AddResponse response = new AddResponse();
        response.setResult(request.getValue().getNumber1() + request.getValue().getNumber2());
        System.out.println("result..... "+ request.getValue().getNumber1() + request.getValue().getNumber2());
        return response;
    }




}
