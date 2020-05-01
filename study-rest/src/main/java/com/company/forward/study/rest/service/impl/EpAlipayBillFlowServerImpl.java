package com.company.forward.study.rest.service.impl;

import com.company.forward.study.rest.mapper.EpAlipayBillFlowMapper;
import com.company.forward.study.rest.service.EpAlipayBillFlowServer;
import org.company.forward.db.config.CurDataSource;
import org.company.forward.db.config.DataSourceNames;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpAlipayBillFlowServerImpl implements EpAlipayBillFlowServer {

    @Autowired
    private EpAlipayBillFlowMapper epAlipayBillFlowMapper;

    @Override
    @CurDataSource(name = DataSourceNames.SALVER)
    public List<EpAlipayBillFlow> queryEpAlipayBillFlowList(String flowNo) {
        return epAlipayBillFlowMapper.queryEpAlipayBillFlowList(flowNo);
    }
}
