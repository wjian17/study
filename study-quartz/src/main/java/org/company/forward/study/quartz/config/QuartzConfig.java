package org.company.forward.study.quartz.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wangjian
 * @ClassName: QuartzConfig
 * @Description: 配置任务调度中心（服务启动时启动）
 * @date 2018年2月26日
 */
@Configuration
@ConditionalOnBean(name = "dataSource")
public class QuartzConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    //自定义的factory
    @Autowired
    private MyJobFactory myFactory;

	/**
	 *  数据库地址
	 */
	@Value("${spring.datasource.url}")
    private String url;

	/**
	 * 用户名
	 */
	@Value("${spring.datasource.username}")
    private String userName;

	/**
	 * 密码
	 */
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        try {
            schedulerFactoryBean.setQuartzProperties(quartzProperties());
            ////指向自建的调度工厂，用于解决方法类无法注入的问题
            schedulerFactoryBean.setJobFactory(myFactory);
            schedulerFactoryBean.setDataSource(dataSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler() throws IOException, SchedulerException {
        Scheduler scheduler = schedulerFactoryBean().getScheduler();
        scheduler.start();// 服务启动shi
        return scheduler;
    }

    /**
     * @param @return
     * @param @throws IOException参数
     * @return Properties返回类型
     * @throws
     * @Title: quartzProperties
     * @Description: 设置quartz属性
     */
    public Properties quartzProperties() throws IOException {
        Properties prop = new Properties();
		// 调度器的实例名
        prop.put("org.quartz.scheduler.instanceName", "quartzScheduler");
		// 实例的标识
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
		// 检查quartz是否有版本更新（true 不检查）
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
		// 表名前缀
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
		// 集群开关
        prop.put("org.quartz.jobStore.isClustered", "false");
		// 线程池的名字
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		// 指定线程数量
        prop.put("org.quartz.threadPool.threadCount", "10");
		// 线程优先级（1-10）默认为5
        prop.put("org.quartz.threadPool.threadPriority", "5");
        prop.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");
        /*prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
        prop.put("org.quartz.dataSource.quartzDataSource.driver", "com.mysql.jdbc.Driver");
        prop.put("org.quartz.dataSource.quartzDataSource.URL", url);
        prop.put("org.quartz.dataSource.quartzDataSource.user", userName);
        prop.put("org.quartz.dataSource.quartzDataSource.password", password);
        prop.put("org.quartz.dataSource.quartzDataSource.maxConnections", "50");*/
        return prop;
    }


}