package org.company.forward.study.kafka.Controller;

import org.company.forward.study.kafka.config.BindChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducter {

    @Autowired
    private BindChannel bindChannel;

    @RequestMapping("/send/{msg}")
    public void send(@PathVariable("msg") String msg) {
        bindChannel.sendMsg(msg);
    }

}
