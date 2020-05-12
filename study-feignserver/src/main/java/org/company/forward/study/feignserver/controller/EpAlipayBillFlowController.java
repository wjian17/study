package org.company.forward.study.feignserver.controller;

import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.company.forward.study.feignserver.service.EpAlipayBillFlowServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "test")
public class EpAlipayBillFlowController {

    @Autowired
    private EpAlipayBillFlowServer epAlipayBillFlowServer;

    @RequestMapping(value = "/EpAlipayBillFlow/{flowNo}",method = RequestMethod.GET)
    public BasicResponse EpAlipayBillFlow(@PathVariable String flowNo){
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setErrorCode(BasicErrorCode.SERVICE_SUCCESS_CODE);
        basicResponse.setErrorMsg(BasicErrorCode.SERVICE_SUCCESS_MSG);
        List<EpAlipayBillFlow> epAlipayBillFlowList = epAlipayBillFlowServer.queryEpAlipayBillFlowList(flowNo);
        basicResponse.setBody(epAlipayBillFlowList);
        return basicResponse;
    }

    @RequestMapping(value = "/test/{flowNo}",method = RequestMethod.GET)
    public BasicResponse test(@PathVariable String flowNo){
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setErrorCode(BasicErrorCode.SERVICE_SUCCESS_CODE);
        basicResponse.setErrorMsg(BasicErrorCode.SERVICE_SUCCESS_MSG);
        List<EpAlipayBillFlow> epAlipayBillFlowList = epAlipayBillFlowServer.queryEpAlipayBillFlowList(flowNo);
        basicResponse.setBody(epAlipayBillFlowList);
        return basicResponse;
    }
}
