package org.company.forward.db.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Method;

/**
 * 多数据源，切面处理类
 *
 * @author xiaohe
 * @version V1.0.0
 */
@Aspect
@Component
public class DataSourceAspect implements Ordered {

    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("@annotation(org.company.forward.db.config.CurDataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        CurDataSource ds = method.getAnnotation(CurDataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceNames.MASTER);
            logger.debug("set datasource is " + DataSourceNames.MASTER);
        } else {
            DynamicDataSource.setDataSource(ds.name());
            logger.debug("set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.debug("clean datasource");
        }
    }

    public int getOrder() {
        return 1;
    }
}
