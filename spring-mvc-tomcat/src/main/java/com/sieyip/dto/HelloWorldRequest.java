package com.sieyip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldRequest {
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("greeting")
    private String greeting;

    public HelloWorldResponse toHelloWorldResponse() {
        HelloWorldResponse helloWorldResponse = new HelloWorldResponse();
        helloWorldResponse.message = this.name + " " + this.greeting;
        return helloWorldResponse;
    }
}

