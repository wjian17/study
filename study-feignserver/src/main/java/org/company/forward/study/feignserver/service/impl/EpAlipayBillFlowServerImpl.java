package org.company.forward.study.feignserver.service.impl;

import org.company.forward.db.config.CurDataSource;
import org.company.forward.db.config.DataSourceNames;
import org.company.forward.domain.rest.EpAlipayBillFlow;
import org.company.forward.study.feignserver.mapper.EpAlipayBillFlowMapper;
import org.company.forward.study.feignserver.service.EpAlipayBillFlowServer;
import org.springframework.beans.factory.annotation.Autowired;
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
