package com.company.forward.study.rest.service.impl;

import com.company.forward.study.rest.feign.HystrixStudyFeignServerClient;
import com.company.forward.study.rest.feign.HystrixStudyFeignServerClientWithCause;
import com.company.forward.study.rest.mapper.EpAlipayBillFlowMapper;
import com.company.forward.study.rest.service.EpAlipayBillFlowServer;
import org.company.forward.db.config.CurDataSource;
import org.company.forward.db.config.DataSourceNames;
import org.company.forward.domain.basic.BasicErrorCode;
import org.company.forward.domain.basic.BasicResponse;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpAlipayBillFlowServerImpl implements EpAlipayBillFlowServer {

    @Autowired
    private EpAlipayBillFlowMapper epAlipayBillFlowMapper;

    @Autowired
    private HystrixStudyFeignServerClient hystrixStudyFeignServerClient;

    @Autowired
    private HystrixStudyFeignServerClientWithCause hystrixStudyFeignServerClientWithCause;

    @Override
    @CurDataSource(name = DataSourceNames.SALVER)
    public BasicResponse queryEpAlipayBillFlowList(String flowNo) {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setErrorCode(BasicErrorCode.SERVICE_SUCCESS_CODE);
        basicResponse.setErrorMsg(BasicErrorCode.SERVICE_SUCCESS_MSG);
        List<EpAlipayBillFlow> epAlipayBillFlowList = epAlipayBillFlowMapper.queryEpAlipayBillFlowList(flowNo);
        basicResponse.setBody(epAlipayBillFlowList);
        return basicResponse;
    }

    public BasicResponse hystrixStudyFeignServerClient(String flowNo) {
        return hystrixStudyFeignServerClient.epAlipayBillFlow(flowNo);
    }

    public BasicResponse hystrixStudyFeignServerClientWithCause(String flowNo) {
        return hystrixStudyFeignServerClientWithCause.epAlipayBillFlow(flowNo);
    }
}
