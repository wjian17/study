package org.company.forward.study.quartz.service;

import org.company.forward.domain.rest.EpAlipayBillFlow;

import java.util.List;


public interface EpAlipayBillFlowServer {

    public List<EpAlipayBillFlow> queryEpAlipayBillFlowList(String flowNo);
}
