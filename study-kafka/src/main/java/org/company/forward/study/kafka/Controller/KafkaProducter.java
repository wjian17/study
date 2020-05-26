package org.company.forward.study.kafka.Controller;

import org.company.forward.domain.basic.BasicResponse;
import org.company.forward.study.kafka.config.BindChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducter {

    private Logger logger = LoggerFactory.getLogger(KafkaProducter.class);

    @Autowired
    private BindChannel bindChannel;

    @RequestMapping("/send/{msg}")
    public BasicResponse send(@PathVariable("msg") String msg) {
        logger.info(msg);
        return bindChannel.sendMsg(msg);
    }

    @RequestMapping("/feignSend")
    public BasicResponse feignSend(String msg) {
        logger.info(msg);
        return bindChannel.sendMsg(msg);
    }

}
