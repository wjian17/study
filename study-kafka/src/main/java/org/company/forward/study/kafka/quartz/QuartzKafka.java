package org.company.forward.study.kafka.quartz;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangjian
 * @date 2020/5/29 0029 11:12
 */
@EnableScheduling
public class QuartzKafka {

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        System.out.println("执行静态定时任务时间: " + df.format(new Date()));
    }
}
