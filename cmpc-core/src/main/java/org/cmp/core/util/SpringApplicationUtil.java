package org.cmp.core.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 不同jar包注意启动类扫描位置
 * @author: wangjian
 * @date: 2021/01/13 10:46
 */
@Configuration
public class SpringApplicationUtil implements ApplicationContextAware, ServletContextListener {

    private static ApplicationContext applicationContext;


    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext arg) throws BeansException {
        if(applicationContext==null){
            applicationContext = arg;
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    }
}
