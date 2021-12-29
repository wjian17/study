package org.cmp.core.annotation;

import org.cmp.core.config.AdapterManagerRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wangjian
 * @date: 2021/12/29 9:30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AdapterManagerRegistrar.class)
public @interface EnableAdapterMgr {
    String[] basePackages() default {};
}
