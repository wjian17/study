package com.company.forward.study.rest.controller;

import com.company.forward.study.rest.service.EpAlipayBillFlowServer;
import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EpAlipayBillFlowController {

    @Autowired
    private EpAlipayBillFlowServer epAlipayBillFlowServer;

    @PostMapping(value = "EpAlipayBillFlow/{flowNo}")
    public BasicResponse EpAlipayBillFlow(@PathVariable String flowNo){
        return epAlipayBillFlowServer.queryEpAlipayBillFlowList(flowNo);
    }

    @RequestMapping(value = "hystrixStudyFeignServerClient/{flowNo}",method = RequestMethod.GET)
    public BasicResponse hystrixStudyFeignServerClient(@PathVariable String flowNo){
        return epAlipayBillFlowServer.hystrixStudyFeignServerClient(flowNo);
    }

    @RequestMapping(value = "hystrixStudyFeignServerClientWithCause/{flowNo}",method = RequestMethod.GET)
    public BasicResponse hystrixStudyFeignServerClientWithCause(@PathVariable String flowNo){
        return epAlipayBillFlowServer.hystrixStudyFeignServerClientWithCause(flowNo);
    }
}
