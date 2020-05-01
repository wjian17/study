package com.company.forward.study.rest.service;

import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EpAlipayBillFlowServer {

    public List<EpAlipayBillFlow> queryEpAlipayBillFlowList(String flowNo);
}
