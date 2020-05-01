package com.company.forward.study.rest.service;

import org.company.forward.domain.basic.BasicResponse;

public interface EpAlipayBillFlowServer {

    public BasicResponse queryEpAlipayBillFlowList(String flowNo);

    public BasicResponse hystrixStudyFeignServerClient(String flowNo);

    public BasicResponse hystrixStudyFeignServerClientWithCause(String flowNo);
}
