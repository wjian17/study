package org.company.forward.study.quartz.config;

import org.company.forward.study.quartz.service.EpAlipayBillFlowServer;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zxj
 * @ClassName: ReportMailBatch
 * @Description: 邮件汇报批
 * @date 2018年2月26日
 */
@Component
public class ReportMailBatch implements Job {

    private static final Logger log = LoggerFactory.getLogger(ReportMailBatch.class);

    @Autowired
    private EpAlipayBillFlowServer epAlipayBillFlowServer;

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        log.info("ReportMailBatch--data-c->execute()");
        epAlipayBillFlowServer.queryEpAlipayBillFlowList(new Date().toString());
        log.info("--本次邮件汇报批处理结束--");
    }
}