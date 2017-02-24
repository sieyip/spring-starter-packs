package com.sieyip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldResponse {
    
    @JsonProperty("message")
    public String message;
    
}

