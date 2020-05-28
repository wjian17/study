package org.company.forward.study.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(value = {StreamClient.class})
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class StreamReceiver {
 
    private Logger logger = LoggerFactory.getLogger(StreamReceiver.class);
 
    @StreamListener(StreamClient.INPUT)
    public void receive(String message) {
        logger.info("StreamReceiver: {}", message);
    }
}