package org.company.forward.domain.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjian
 * @date 2020/6/3 0003 14:19
 */
@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCuratorZkLock {
    String value();

    int time() default 3000;

    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}