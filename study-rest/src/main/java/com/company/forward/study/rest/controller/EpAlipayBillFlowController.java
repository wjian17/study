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
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setErrorCode(BasicErrorCode.SERVICE_SUCCESS_CODE);
        basicResponse.setErrorMsg(BasicErrorCode.SERVICE_SUCCESS_MSG);
        List<EpAlipayBillFlow> epAlipayBillFlowList = epAlipayBillFlowServer.queryEpAlipayBillFlowList(flowNo);
        basicResponse.setBody(epAlipayBillFlowList);
        return basicResponse;
    }

    @RequestMapping(value = "test/{flowNo}",method = RequestMethod.GET)
    public BasicResponse test(@PathVariable String flowNo){
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setErrorCode(BasicErrorCode.SERVICE_SUCCESS_CODE);
        basicResponse.setErrorMsg(BasicErrorCode.SERVICE_SUCCESS_MSG);
        List<EpAlipayBillFlow> epAlipayBillFlowList = epAlipayBillFlowServer.queryEpAlipayBillFlowList(flowNo);
        basicResponse.setBody(epAlipayBillFlowList);
        return basicResponse;
    }
}
