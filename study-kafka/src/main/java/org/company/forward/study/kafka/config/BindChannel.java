package org.company.forward.study.kafka.config;

import org.company.forward.domain.basic.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

//这个注解给我们绑定消息通道的，Source是Stream给我们提供的，可以点进去看源码，可以看到output和input,这和配置文件中的output，input对应的。
@EnableBinding(value = {StreamClient.class})
public class BindChannel {
    @Autowired
    private StreamClient streamClient;

    public BasicResponse sendMsg(String msg){
        BasicResponse basicResponse = new BasicResponse();
        streamClient.output().send(MessageBuilder.withPayload(msg).build());
        return basicResponse;
    }
}