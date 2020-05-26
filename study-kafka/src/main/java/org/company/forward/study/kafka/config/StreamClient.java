package org.company.forward.study.kafka.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
 
    String INPUT = "shop_input";
    String OUTPUT = "shop_output";
 
    @Input(StreamClient.INPUT)
    SubscribableChannel input();
 
    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}