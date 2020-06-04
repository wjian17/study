package org.company.forward.study.kafka.controller;

import org.company.forward.domain.basic.BasicResponse;
import org.company.forward.study.kafka.config.BindChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class KafkaProducter {

    private Logger logger = LoggerFactory.getLogger(KafkaProducter.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private BindChannel bindChannel;

    @RequestMapping("/send/{msg}")
    public BasicResponse send(@PathVariable("msg") String msg) {
        logger.info(msg);
//        KafkaProducer
        //kafkaTemplate发送消息至topic test2
        ListenableFuture future = kafkaTemplate.send("test1", msg.getBytes());
        future.addCallback(o -> System.out.println(" "), e -> System.err.println("发送失败,"+e.getCause()));

        return bindChannel.sendMsg(msg);
    }

    @RequestMapping("/feignSend")
    public BasicResponse feignSend(String msg) {
        logger.info(msg);
        return bindChannel.sendMsg(msg);
    }

}
