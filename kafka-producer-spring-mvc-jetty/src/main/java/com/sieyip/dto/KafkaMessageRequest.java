package com.sieyip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KafkaMessageRequest {
    
    @JsonProperty("message")
    public String message;
    
}

