package com.company.forward.study.rest.controller.kafka;

import com.company.forward.study.rest.feign.kafka.HystrixStudyKafkaServerClientWithCause;
import org.company.forward.domain.basic.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class KafkaProducter {

    @Autowired
    private HystrixStudyKafkaServerClientWithCause hystrixStudyKafkaServerClientWithCause;

    @PostMapping(value = "/send/{msg}")
    public BasicResponse send(@PathVariable String msg){
//        hystrixStudyKafkaServerClientWithCause.send();
        return hystrixStudyKafkaServerClientWithCause.send(msg);
    }
    @PostMapping(value = "feignSend/{msg}")
    public BasicResponse feignSend(@PathVariable String msg){
//        hystrixStudyKafkaServerClientWithCause.send();
        return hystrixStudyKafkaServerClientWithCause.feignSend(msg);
    }
}
